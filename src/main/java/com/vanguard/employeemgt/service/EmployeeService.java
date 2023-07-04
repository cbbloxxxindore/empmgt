package com.vanguard.employeemgt.service;

import com.vanguard.employeemgt.models.Employee;

import java.util.List;

public interface EmployeeService {



    Employee saveEmployee(Employee employee);

    List<Employee> getAllemployee();

    Employee getEmployeeByName(String name);

    public Employee getEmployeeById(int id) ;


    Employee getEmployeeByIdAndName(int id, String name);

     List<Employee> getAllEmployeeBySalary(double salary);

    List<Employee> findEmployeeByAgeGraterthen37(int age);

    Employee findNthHigestsalary(int n);


}
