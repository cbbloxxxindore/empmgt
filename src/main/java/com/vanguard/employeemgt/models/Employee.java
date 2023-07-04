package com.vanguard.employeemgt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NamedQueries({@NamedQuery(name = "findSalarygraterthenfiftyEmployee" ,query = "select e from Employee e where e.salary>?1"),
    @NamedQuery(name = "findEmployeeByAgeGraterthen37",query = "select e from Employee e where e.age>=?1")})
@NamedNativeQueries({@NamedNativeQuery(name = "findnthmaxsalary",query = "select * from employee  order by  salary DESC  limit ?1,1 ",resultClass = Employee.class)})

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "employee")
public class Employee {
    @Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private  int emp_id ;
    private  String name;
    private double salary;
    private String department;
    private  int age;
    private String gender;
    private Date doj;
}
