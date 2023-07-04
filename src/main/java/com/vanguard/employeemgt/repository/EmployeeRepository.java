package com.vanguard.employeemgt.repository;

import com.vanguard.employeemgt.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Procedure(name = "emppr2")
    Employee emppr2(String name);
    @Procedure(name = "empprocedure")
    List<Employee> empprocedure();
@Query("select e from Employee e where e.emp_id=:id ")
    Employee getEmployeeById(@Param("id") int id);

@Query(value = "select * from employee where emp_id= ?1 AND name = ?2",nativeQuery = true)
    Employee getEmployeeByIdAndName(int id, String name);
@Query(name = "findSalarygraterthenfiftyEmployee")
    List<Employee> getAllEmployeeBySalary(double salary);
    @Query(name = "findEmployeeByAgeGraterthen37")
    List<Employee> findEmployeeByAge(int age);
    @Query(name = "findnthmaxsalary")
    Employee findNthHigestsalary(int n);
}
