package service;

import dataBase.EmployeeDao;
import models.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();

    public EmployeeService() throws SQLException, ClassNotFoundException {
    }

    public List<Employee> sortBySalary(List<Employee> employeeList) {
        List<Employee> newList = new ArrayList<>(employeeList);
        newList.sort((t0, t1) -> Double.compare(t0.getSalary(), t1.getSalary()));
        return newList;
    }

    public List<Employee> sortByEnteringYear(List<Employee> employeeList) {
        List<Employee> newList = new ArrayList<>(employeeList);
        newList.sort((t0, t1) -> Integer.compare(t0.getEnteringYear(), t1.getEnteringYear()));
        return newList;
    }

    public List<Employee> sortByYearANDSalary(List<Employee> employeeList) throws SQLException {
        List<Employee> employeesSortByYear = sortByEnteringYear(employeeList);
        List<Employee> employeesSortByYearSalary = sortBySalary(employeesSortByYear);
        return employeesSortByYearSalary;
    }

    public void showListOfEmployeeSortedBySalary(List<Employee> employeeList, double min, double max, int numOfEmployeeWithThisSalary, int row, int year) {
        if (numOfEmployeeWithThisSalary != 0) {
            int countForSout = 1;
            for (Employee employee : employeeList) {
                if (numOfEmployeeWithThisSalary / 2 + 1 == countForSout) {
                    if (employee.getSalary() < max && employee.getSalary() >= min)
                        System.out.println("  " + row + "  " + "|    " + year + "    |      " + min + " to " + max + "       |" + employee + "\n     |            |                        |");
                } else {
                    if (employee.getSalary() < max && employee.getSalary() >= min)
                        System.out.println("     |            |                        |" + employee + "\n     |            |                        |");
                }
                countForSout++;
            }
        }
    }


    public void showListOfEmployeeSortedBySalary(List<Employee> employeeList, double min, int numOfEmployeeWithThisSalary, int row, int year) {
        if (numOfEmployeeWithThisSalary != 0) {
            int countForSout = 1;
            for (Employee employee : employeeList) {
                if (numOfEmployeeWithThisSalary / 2 + 1 == countForSout) {
                    if (employee.getSalary() >= min)
                        System.out.println("  " + row + "  " + "|    " + year + "    |     " + " upper than " + min + "   |" + employee + "\n     |            |                        |");
                } else {
                    if (employee.getSalary() >= min)
                        System.out.println("     |            |                        |" + employee + "\n     |            |                        |");
                }
                countForSout++;
            }
        }
    }

    public int getNumOfEmployeeWithThisSalary(List<Employee> employeeList, double min, double max) {
        int numOfEmployeeWithThisSalary = 0;
        for (Employee employee : employeeList) {
            if (employee.getSalary() < max && employee.getSalary() >= min) numOfEmployeeWithThisSalary++;
        }
        return numOfEmployeeWithThisSalary;
    }

    public int getNumOfEmployeeWithThisSalary(List<Employee> employeeList, double min) {
        int numOfEmployeeWithThisSalary = 0;
        for (Employee employee : employeeList) {
            if (employee.getSalary() >= min) numOfEmployeeWithThisSalary++;
        }
        return numOfEmployeeWithThisSalary;
    }


    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
}
