package com.vanguard.employeemgt.resource;

import com.vanguard.employeemgt.models.Employee;
import com.vanguard.employeemgt.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@PostMapping("/employees")
    public Employee createEmployee(@RequestBody @Valid Employee employee) {


        return employeeService.saveEmployee(employee);
    }
@GetMapping("/employees/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);

    }
    @GetMapping("/employees")
    public List<Employee> getAllemployee() {

        return employeeService.getAllemployee();

    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);


    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeByIdAndName(@RequestParam int id, @RequestParam("name") String name) {
        Employee employee = employeeService.getEmployeeByIdAndName(id, name);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/employe/{salary}")
    public ResponseEntity<List<Employee>> getAllEmployeeBySalary(@PathVariable double salary) {

        List<Employee>employee = employeeService.getAllEmployeeBySalary(salary);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }


    }
    @GetMapping("/employee/age/{age}")
    public ResponseEntity<List<Employee>> findEmployeeByAgeGraterthen37(@PathVariable int age) {


        List<Employee>employee = employeeService.findEmployeeByAgeGraterthen37(age);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/employee/salary/{n}")

    public ResponseEntity<Employee> findNthHigestsalary(@PathVariable int n) {

        Employee employee = employeeService.findNthHigestsalary(n);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    }