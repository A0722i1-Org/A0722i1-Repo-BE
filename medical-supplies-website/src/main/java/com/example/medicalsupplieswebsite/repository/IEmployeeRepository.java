package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select e.employee_id, e.employee_name, e.gender, e.date_of_birth, e.employee_address, e.employee_img, e.salary, e.is_enable, p.position_id, a.account_id " +
            "from employee e " +
            "inner join position p on e.position_id = p.position_id " +
            "inner join account a on e.account_id = a.account_id " +
            "where (e.is_enable = true) and (a.is_enable = true) and (a.username = :username)",
            nativeQuery = true)
    Optional<Employee> findByUsername(@Param("username") String username);
}
