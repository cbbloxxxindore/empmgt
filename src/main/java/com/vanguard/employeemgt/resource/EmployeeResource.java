package com.vanguard.employeemgt.resource;

import com.vanguard.employeemgt.exception.EmployeeNotFoundException;
import com.vanguard.employeemgt.models.Employee;
import com.vanguard.employeemgt.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);
    public  static final String  CLASS_NAME= EmployeeResource.class.getName()  ;
    private static final Logger log = LoggerFactory.getLogger(EmployeeResource.class);
    private static final String SAVE_METHOD = "createEmployee";
    private static final String EXCEPTION = " Exception occurred while saving Employee";

    @Autowired
    private EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
@PostMapping("/employees")
    public ResponseEntity<Employee >createEmployee(@RequestBody @Valid Employee employee) {

    StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
    try {
        log.info(msgBuilder.append("Attemping to save employee  resource").toString());



        log.info(msgBuilder.append("sucessfully  saved employee ").toString());
        return  new ResponseEntity(employeeService.saveEmployee(employee), HttpStatus.OK);

    }catch (EmployeeNotFoundException e)
    {
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);    }
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