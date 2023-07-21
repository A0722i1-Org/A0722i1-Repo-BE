package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c.customer_id, c.customer_address, c.customer_img, " +
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
    @Query(value = "update from Customer set is_enable = false where customer_id = :id ", nativeQuery = true)
    void deleteCustomerId(@Param("id") Long id);


    @Query(value = "select c.customer_id, c.customer_address, c.customer_img, c.date_of_birth, c.gender, c.id_card, c.is_enable, c.name, c.phone,ct.customer_type_id,a.account_id, r.cart_id" +
            " from customer c  join customer_type ct on c.customer_type_id = ct.customer_type_id  join account a " +
            " on c.account_id = a.account_id  join cart r on c.cart_id = r.cart_id" +
            " where ct.customer_type_name like %:type% and c.name like %:name% and c.customer_address like %:address% and c.phone like %:phone%  and is_enable= true", nativeQuery = true)
    List<Customer> searchCustomer(@Param("type") String type,
                                  @Param("name") String name,
                                  @Param("address") String address,
                                  @Param("phone") String phone);
}