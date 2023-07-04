package com.vanguard.employeemgt.service;

import com.vanguard.employeemgt.models.Employee;
import com.vanguard.employeemgt.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSrviceImpl implements  EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeSrviceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
@Transactional
    @Override
    public List<Employee> getAllemployee() {
        return employeeRepository.empprocedure();
    }

    @Override
    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeRepository.emppr2(name);
    }
    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    public Employee getEmployeeByIdAndName(int id,String name) {
        return employeeRepository.getEmployeeByIdAndName(id,name);
    }

    @Override
    public List<Employee> getAllEmployeeBySalary(double salary) {
        return employeeRepository.getAllEmployeeBySalary(salary);
    }

    @Override
    public List<Employee> findEmployeeByAgeGraterthen37(int age) {
        return employeeRepository. findEmployeeByAge(age);
    }

    @Override
    public Employee findNthHigestsalary(int n) {
        return employeeRepository.findNthHigestsalary(3);
    }
}
