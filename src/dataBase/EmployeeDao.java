package dataBase;

import models.Employee;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.StreamSupport;

public class EmployeeDao  extends DataBaseAccess{
        public EmployeeDao() throws ClassNotFoundException, SQLException {
            super();
        }

        public int save(Employee employee, int addressId ) throws SQLException {
            if (getConnection()!=null) {
                Statement statement = getConnection().createStatement();
                String sql = String.format("insert into `employee` (`first_name`, `last_name`, `national_code`, `employee_code`, `entering_year` , `phone`, `gender`, `address`) values ('%s','%s','%s','%tf`,'%s','%s','%d'  )",
                        employee.getFirstName(), employee.getLastName(), employee.getNationalCode(), employee.getEnteringYear() ,employee.getPhoneNumber(),employee.getGender(), addressId );
                return statement.executeUpdate(sql);
            }
            else return -1 ;
        }

        public List<Integer> findAllYear (int year ) throws SQLException {

            List <Integer> allYear = new ArrayList<>();
            if (getConnection()!= null){
                String sql = "select distinct `entering_year` from `employee` order by `entering_year`; ";
                PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
                ResultSet resultSet =  preparedStatement.executeQuery();
                while(resultSet.next()){
                    if (resultSet.getInt(1 )>year){
                       allYear.add(resultSet.getInt(1)) ;
                    }
                }
                return allYear;
            }
            else return Collections.emptyList();

        }

        public List<Employee> getAllEmployeesForShowSomeInfo () throws SQLException {
            if ( getConnection()!= null ){
                List<Employee> employeeList = new ArrayList<>();
                Statement statement = getConnection().createStatement();
                String sql = "select `first_name` , `last_name` , `employee_code` ,`salary` , `entering_year` from `employee` ; ";
                return getEmployeesFromResultSet(employeeList, statement, sql);
            }
            else return Collections.emptyList();
        }

    public List<Employee> getEmployeesThisYearForShowSomeInfo (int year ) throws SQLException {
        if ( getConnection()!= null ){
            List<Employee> employeeList = new ArrayList<>();
            Statement statement = getConnection().createStatement();
            String sql = String.format("select `first_name` , `last_name` , `employee_code` ,`salary` , `entering_year` from `employee` where `entering_year` = '%d'; ", year);
            return getEmployeesResultInfo(employeeList, statement, sql);
        }

        else return Collections.emptyList();
    }

    private List<Employee> getEmployeesFromResultSet(List<Employee> employeeList, Statement statement, String sql) throws SQLException {
        return getEmployeesResultInfo(employeeList, statement, sql);
    }

    private List<Employee> getEmployeesResultInfo(List<Employee> employeeList, Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Employee employee = new Employee();
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setSalary(resultSet.getInt("salary"));
            employee.setEmployeeCode(resultSet.getString("employee_code"));
            employee.setEnteringYear(resultSet.getInt("entering_year"));
            employeeList.add(employee);
        }
        return employeeList;
    }

}





