package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Employee;
import com.example.medicalsupplieswebsite.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    /**
     * Create by: PhongTD
     * Date create: 12/07/2023
     * @param name
     * @param email
     * @param phone
     * @param address
     * @param gender
     * @param idCard
     * @param dateOfBirth
     * @param position
     * @param id
     */
    @Modifying
    @Query("UPDATE Employee SET employeeName = ?1, email = ?2, phone = ?3, employeeAddress = ?4, gender = ?5, idCard = ?6," +
            " dateOfBirth = ?7,employeeImg = ?8 ,position = ?9 WHERE employeeId = ?10")
    void updateEmployee(String name, String email, String phone, String address, Integer gender,
                        String idCard, LocalDate dateOfBirth, String avatar, Position position, Long id);

    /**
     * Created by: PhongTD
     * Date created: 12/07/2023
     * @param id
     * @return Employee was found by id
     */
    @Query("SELECT employee FROM Employee employee WHERE employee.employeeId = ?1")
    Employee findAllById(Long id);
}
