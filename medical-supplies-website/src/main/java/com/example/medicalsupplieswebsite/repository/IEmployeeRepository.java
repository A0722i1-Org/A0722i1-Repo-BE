package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    /**
     * this function could return a list of employee ,that can display all employee or combines search with 3 params
     * @param nameEmployee
     * @param nameEmployee
     * @param position
     * @return list of employee
     */
    @Query(value = "SELECT employee.employee_id, date_of_birth, employee_address, employee_img, employee_name, gender, employee.is_enable, salary, employee.account_id, employee.position_id, position_name, username\n" +
            "FROM employee\n" +
            "JOIN account ON employee.account_id = account.account_id\n" +
            "JOIN position ON employee.position_id = position.position_id\n" +
            "WHERE employee_name LIKE %?% \n" +
            "  AND date_of_birth LIKE %?% \n" +
            "  AND position_name LIKE %?% \n" +
            "  AND employee.is_enable = false\n" +
            "LIMIT 0, 300;"
            ,nativeQuery = true)
    List<Employee> findAllByNameAndDobAndAndPosition(String nameEmployee,String dof,String position);
    /**
     * this function could return 1 employee of employee table by id employee
     * @param id
     * @return employee
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE employee \n" +
            "SET is_enable = true \n" +
            "WHERE employee_id = ?1 AND is_enable = false; \n",nativeQuery = true)
    void deleteEmployeeByID(Long id);

    /**
     * this function could delete employee by id employee
     * @param id
     * @return none
     */
    @Query(value = "SELECT employee.employee_id, date_of_birth, employee_address, employee_img, employee_name, gender, employee.is_enable, salary, employee.account_id, employee.position_id, position_name, username\n" +
            "FROM employee\n" +
            "JOIN account ON employee.account_id = account.account_id\n" +
            "JOIN position ON employee.position_id = position.position_id\n" +
            "WHERE employee.employee_id = ? \n" +
            "  AND employee.is_enable = false \n" +
            "LIMIT 0, 300;",nativeQuery = true)
    Employee getEmployeeById(Long id);

}
