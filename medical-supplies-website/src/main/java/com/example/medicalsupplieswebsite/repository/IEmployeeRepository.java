package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.Optional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Modifying
    @Query("UPDATE Employee SET employeeName = ?1, email = ?2, phone = ?3, employeeAddress = ?4, gender = ?5, idCard = ?6," +
            " dateOfBirth = ?7,employeeImg = ?8 ,position = ?9 WHERE employeeId = ?10")
    void updateEmployee(String employeeName, String email, String phone, String employeeAddress, Integer gender,
                        String idCard, Date dateOfBirth, String avatar, Position position, Long id);

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
}
