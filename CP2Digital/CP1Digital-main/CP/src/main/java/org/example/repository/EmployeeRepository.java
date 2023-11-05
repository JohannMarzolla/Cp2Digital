package org.example.repository;

import org.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    @Query(value = "select e from Employee e where e.salario =:salary",nativeQuery = false)
   List<Employee> findEmployessBySalary(@Param("salary") Double salary);
    @Query(value = "select salario from Employee INNER JOIN Departament where Departament.name=?",nativeQuery = true) //SQL
    Double findSalarioFromDepartament(@Param("name") String name);
}
