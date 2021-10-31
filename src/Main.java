import models.Employee;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EmployeeService employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" enter the year that you want see the employee list after that  :less than 10 ");
        try {
            try {
                int year = scanner.nextInt();
                if (year > 10)
                    throw new RuntimeException("enter number less than 10 ");
                else {
                    System.out.println("               ****************** Employee List ******************\n");
                    System.out.println(" row   enteringYear         salary        employeeCode         fullName     \n");
                    int rowNum = 1;
                    List<Integer> allYears = employeeService.getEmployeeDao().findAllYear(year);
                    for (Integer integer : allYears) {
                        List <Employee> employeeList = employeeService.getEmployeeDao().getEmployeesThisYearForShowSomeInfo(integer);
                        List<Employee> employeesOfThisYear =employeeService.sortByYearANDSalary(employeeList);
                      int numOfEmployeeWithSalary1_5 =employeeService.getNumOfEmployeeWithThisSalary(employeeList,1,5);
                        employeeService.showListOfEmployeeSortedBySalary(employeesOfThisYear, 1, 5, numOfEmployeeWithSalary1_5,rowNum,integer);
                        System.out.println("     |            |------------------------|");
                        int numOfEmployeeWithSalary5_10 = employeeService.getNumOfEmployeeWithThisSalary(employeesOfThisYear,5,10);
                        employeeService.showListOfEmployeeSortedBySalary(employeesOfThisYear, 5, 10,numOfEmployeeWithSalary5_10,rowNum,integer);
                        System.out.println("     |            |------------------------|");
                        int numOfEmployeeWithSalaryUp10 =employeeService.getNumOfEmployeeWithThisSalary(employeesOfThisYear,10);
                        employeeService.showListOfEmployeeSortedBySalary(employeesOfThisYear, 10,numOfEmployeeWithSalaryUp10,rowNum,integer);
                        System.out.println("-----|------------|------------------------|");
                        rowNum++;
                    }
                }
            } catch (RuntimeException runtimeException) {
                System.out.println(runtimeException.getMessage());
            }
        } catch (
                NumberFormatException e) {
            System.out.println("enter number");
        }


    }
}

