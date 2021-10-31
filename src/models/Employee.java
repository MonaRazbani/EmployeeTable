package models;

import enums.Gender;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Employee {

    private String firstName;
    private String lastName;
    private String nationalCode;
    private String employeeCode;
    private int enteringYear;
    private String phoneNumber;
    private Address address;
    private Gender gender;
    private int salary;

    public Employee(String firstName, String lastName, String nationalCode, String employeeCode, int enteringYear, String phoneNumber, Address address, Gender gender, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.employeeCode = employeeCode;
        this.enteringYear = enteringYear;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public int getEnteringYear() {
        return enteringYear;
    }

    public void setEnteringYear(int enteringYear) {
        this.enteringYear = enteringYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "  " + employeeCode+"  |  "+
        firstName +
                " " + lastName + " "
                ;
    }
}

