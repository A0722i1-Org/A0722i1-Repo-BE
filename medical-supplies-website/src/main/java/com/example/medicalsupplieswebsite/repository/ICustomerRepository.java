package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Cart;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {



    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `medical_supplies`.`customer` (`customer_address`,`customer_code`,`customer_img`,`customer_type_id`," +
            "`date_of_birth`,`email`,`gender`,`id_card`,`is_enable`,`name`,`phone`) VALUES (:customer_address,:customer_code,:customer_img,:customer_type_id,:date_of_birth,:email,:gender,:id_card,:is_enable," +
            ":name,:phone)", nativeQuery = true)
    void insertCustomer(@Param("name")String name,
                        @Param("email")String email,
                        @Param("phone")String phone,
                        @Param("gender")Boolean gender,
                        @Param("date_of_birth") Date date_of_birth,
                        @Param("id_card")String id_card,
                        @Param("customer_address")String address,
                        @Param("customer_img")String img,
                        @Param("customer_type_id") CustomerType customer_type_id,
                        @Param("customer_code")String customer_code,
                        @Param("is_enable")Boolean is_enable);





    @Modifying
    @Transactional
    @Query(value = "UPDATE `medical_supplies`.`customer` SET `account_id`=:account_id,`cart_id`=:cart_id,`customer_address`=:customer_address," +
            "`customer_code`=:customer_code,`customer_img`=:customer_img,`customer_type_id`=:customer_type_id," +
            "`date_of_birth`=:date_of_birth,`email`=:email,`gender`=:gender,`id_card`=:id_card,`is_enable`=:is_enable," +
            "`name`=:name,`phone`=:phone WHERE `customer_id`=:customer_id", nativeQuery = true)
    void updateCustomer(@Param("customer_id")Long id,
                        @Param("name")String name,
                        @Param("email")String email,
                        @Param("phone")String phone,
                        @Param("gender")Boolean gender,
                        @Param("date_of_birth") Date date_of_birth,
                        @Param("id_card")String id_card,
                        @Param("customer_address")String address,
                        @Param("customer_img")String img,
                        @Param("customer_type_id") CustomerType customer_type_id,
                        @Param("cart_id")Cart cart,
                        @Param("account_id")Account account,
                        @Param("customer_code")String customer_code,
                        @Param("is_enable")Boolean is_enable);

    @Query("SELECT customer FROM Customer customer WHERE customer.customerId = ?1")
    Customer findAllById(Long id);



}
