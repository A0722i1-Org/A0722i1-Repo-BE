package com.example.medicalsupplieswebsite.repository;


import com.example.medicalsupplieswebsite.dto.receipt_dto.SupplierDTO;
import com.example.medicalsupplieswebsite.entity.Account;
import com.example.medicalsupplieswebsite.entity.Cart;
import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;
import javax.transaction.Transactional;

import java.sql.Date;
import java.util.Optional;


public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c.customer_id, c.customer_address ,c.customer_code,c.email, c.customer_img, " +
            "c.date_of_birth, c.gender, c.id_card, c.is_enable," +
            " c.name, c.phone, ct.customer_type_id ," +
            " a.account_id, r.cart_id " +
            "from customer c inner join customer_type ct on c.customer_type_id = ct.customer_type_id inner join account a" +
            " on c.account_id = a.account_id inner join cart r on c.cart_id = r.cart_id where c.is_enable= true",
            countQuery = "select count(c.customer_id)" +
                    " from customer c" +
                    " inner join customer_type ct on c.customer_type_id = ct.customer_type_id inner join account a" +
                    " on c.account_id = a.account_id inner join cart r on c.cart_id = r.cart_id ",
            nativeQuery = true)
    Page<Customer> findAllCustomers(Pageable pageable);


    @Modifying
    @Transactional
    @Query(value = "update customer set is_enable = false where customer_id = :id", nativeQuery = true)
    void deleteCustomerId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `medical_supplies`.`customer` (`customer_address`,`customer_code`,`customer_img`,`customer_type_id`," +
            "`date_of_birth`,`email`,`gender`,`id_card`,`is_enable`,`name`,`phone`) VALUES (:customer_address,:customer_code,:customer_img,:customer_type_id,:date_of_birth,:email,:gender,:id_card,:is_enable," +
            ":name,:phone)", nativeQuery = true)
    void insertCustomer(@Param("name") String name,
                        @Param("email") String email,
                        @Param("phone") String phone,
                        @Param("gender") Boolean gender,
                        @Param("date_of_birth") Date date_of_birth,
                        @Param("id_card") String id_card,
                        @Param("customer_address") String address,
                        @Param("customer_img") String img,
                        @Param("customer_type_id") CustomerType customer_type_id,
                        @Param("customer_code") String customer_code,
                        @Param("is_enable") Boolean is_enable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `medical_supplies`.`customer` SET `account_id`=:account_id,`cart_id`=:cart_id,`customer_address`=:customer_address," +
            "`customer_code`=:customer_code,`customer_img`=:customer_img,`customer_type_id`=:customer_type_id," +
            "`date_of_birth`=:date_of_birth,`email`=:email,`gender`=:gender,`id_card`=:id_card,`is_enable`=:is_enable," +
            "`name`=:name,`phone`=:phone WHERE `customer_id`=:customer_id", nativeQuery = true)
    void updateCustomer(@Param("customer_id") Long id,
                        @Param("name") String name,
                        @Param("email") String email,
                        @Param("phone") String phone,
                        @Param("gender") Boolean gender,
                        @Param("date_of_birth") Date date_of_birth,
                        @Param("id_card") String id_card,
                        @Param("customer_address") String address,
                        @Param("customer_img") String img,
                        @Param("customer_type_id") CustomerType customer_type_id,
                        @Param("cart_id") Cart cart,
                        @Param("account_id") Account account,
                        @Param("customer_code") String customer_code,
                        @Param("is_enable") Boolean is_enable);

    @Query("SELECT customer FROM Customer customer WHERE customer.customerId = ?1")
    Customer findAllById(Long id);


    @Query(value = "select c.customer_id, c.name, c.phone, c.gender, c.date_of_birth, c.id_card, c.customer_address, " +
            "c.customer_img, c.is_enable, ct.customer_type_id, cart.cart_id, a.account_id " + "from customer c " +
            "inner join customer_type ct on c.customer_type_id = ct.customer_type_id " +
            "inner join account a on c.account_id = a.account_id " +
            "left join cart on c.cart_id = cart.cart_id " +
            "where (c.is_enable = true) and (a.is_enable = true) and (a.username = :username)",
            nativeQuery = true)
    Optional<Customer> findByUsername(@Param("username") String username);

    @Transactional
    @Query(value = "select  c.customer_id,c.gender ,c.date_of_birth,c.customer_type_id,c.customer_img,c.customer_address ,c.cart_id,c.account_id, c.name ,c.id_card, c.is_enable, c.phone from customer c\n" +
            "inner join customer_type ct on ct.customer_type_id = c.customer_type_id\n" +
            "where ct.customer_type_id = 2",nativeQuery = true)
    List<Customer> supplierList();
}
