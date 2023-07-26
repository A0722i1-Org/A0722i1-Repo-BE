package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    @Transactional
    @Query(value = "select  c.customer_id,c.gender ,c.date_of_birth,c.customer_type_id,c.customer_img,c.customer_address ,c.cart_id,c.account_id, c.name ,c.id_card, c.is_enable, c.phone from customer c\n" +
            "inner join customer_type ct on ct.customer_type_id = c.customer_type_id\n" +
            "where ct.customer_type_id = 2",nativeQuery = true)
    List<Customer> supplierList();
}
