package com.example.medicalsupplieswebsite.repository;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    /**
     * Create by: PhongTD
     * Date create: 12/07/2023
     * @param employeeName
     * @param email
     * @param phone
     * @param employeeAddress
     * @param gender
     * @param idCard
     * @param dateOfBirth
     * @param position
     * @param id
     */
    @Modifying
    @Query("UPDATE Employee SET employeeName = ?1, email = ?2, phone = ?3, employeeAddress = ?4, gender = ?5, idCard = ?6," +
            " dateOfBirth = ?7,employeeImg = ?8 ,position = ?9 WHERE employeeId = ?10")
    void updateEmployee(String employeeName, String email, String phone, String employeeAddress, Integer gender,
                        String idCard, Date dateOfBirth, String avatar, Position position, Long id);

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param id
     * @return Employee was found by id
     */
    @Query("SELECT employee FROM Employee employee WHERE employee.employeeId = ?1")
    Employee findAllById(Long id);

    @Query(value =
            "select e.employee_id, e.employee_code, e.employee_name, e.email, e.phone, " +
            "e.employee_address, e.gender, e.date_of_birth, e.id_card, e.salary, e.employee_img, " +
            "e.is_enable, p.position_id, a.account_id " +
            "from employee e " +
            "inner join position p on e.position_id = p.position_id " +
            "inner join account a on e.account_id = a.account_id " +
            "where (e.is_enable = true) and (a.is_enable = true) and (a.username = :username)",
            nativeQuery = true)
    Optional<Employee> findByUsername(@Param("username") String username);

    /**
     * A0722I1-KhanhNL
     */
    @Query(value =
            "select e.employee_id, e.employee_code, e.employee_name, e.phone, " +
                    "e.employee_address, e.gender, e.date_of_birth, e.id_card, e.salary, e.employee_img, " +
                    "e.is_enable, p.position_name, a.username, a.email " +
                    "from employee e " +
                    "inner join position p on e.position_id = p.position_id " +
                    "inner join account a on e.account_id = a.account_id " +
                    "where (e.is_enable = true) and (a.is_enable = true) and (a.username = :username)",
            nativeQuery = true)
    Optional<Tuple> findUserDetailByUsername(@Param("username") String username);

    /**
     * this function could return a list of employee ,that can display all employee or combines search with 3 params
     * @param nameEmployee
     * @param nameEmployee
     * @param position
     * @return list of employee
     */
    @Query(value = "SELECT employee.employee_id, " +
            "date_of_birth, employee_address," +
            " employee_img, employee_name, gender, " +
            "employee.is_enable, salary, employee.account_id, " +
            "employee.position_id, position_name, username,employee.email," +
            "employee_code,id_card,phone\n" +
            "FROM employee\n" +
            "JOIN account ON employee.account_id = account.account_id\n" +
            "JOIN position ON employee.position_id = position.position_id\n" +
            "WHERE employee_name LIKE %?% \n" +
            "  AND date_of_birth LIKE %?% \n" +
            "  AND position_name LIKE %?% \n" +
            "  AND employee.is_enable = false\n" +
            "LIMIT 0, 300;"
            ,nativeQuery = true)
    List<Employee> findAllByNameAndDobAndAndPosition(String nameEmployee, String dof, String position);
    /**
     * this function could return 1 employee of employee table by id employee
     * @param id
     * @return employee
     */
    @Modifying
    @Query(value = "UPDATE employee \n" +
            "SET is_enable = true \n" +
            "WHERE employee_id = ?1 AND is_enable = false; \n",nativeQuery = true)
    void deleteEmployeeByID(Long id);

    /**
     * this function could delete employee by id employee
     * @param id
     * @return none
     */
    @Query(value = "SELECT employee.employee_id, " +
            "date_of_birth, employee_address, employee_img," +
            " employee_name, gender, employee.is_enable, salary, " +
            "employee.account_id, employee.position_id, position_name, " +
            "username,employee.email,employee_code,id_card,phone\n" +
            "FROM employee\n" +
            "JOIN account ON employee.account_id = account.account_id\n" +
            "JOIN position ON employee.position_id = position.position_id\n" +
            "WHERE employee.employee_id = ? \n" +
            "  AND employee.is_enable = false \n" +
            "LIMIT 0, 300;",nativeQuery = true)
    Employee getEmployeeById(Long id);
}
