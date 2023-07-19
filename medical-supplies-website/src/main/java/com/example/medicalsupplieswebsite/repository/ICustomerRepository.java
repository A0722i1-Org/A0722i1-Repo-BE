package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.dto.shipmentdto.CustomerDto;
import com.example.medicalsupplieswebsite.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select c.customer_id, c.name, c.phone, c.gender, c.date_of_birth, c.id_card, c.customer_address, " +
            "c.customer_img, c.is_enable, ct.customer_type_id, cart.cart_id, a.account_id " + "from customer c " +
            "inner join customer_type ct on c.customer_type_id = ct.customer_type_id " +
            "inner join account a on c.account_id = a.account_id " +
            "left join cart on c.cart_id = cart.cart_id " +
            "where (c.is_enable = true) and (a.is_enable = true) and (a.username = :username)",
            nativeQuery = true)
    Optional<Customer> findByUsername(@Param("username") String username);

    /**
     * A0722I1-KhanhNL
     */
    @Query(value = "select c.customer_id, c.name, c.phone, c.gender, c.date_of_birth, " +
            "c.id_card, c.customer_address, c.customer_img,  ct.customer_type_name, a.username, a.email " +
            "from customer c " +
            "inner join customer_type ct on c.customer_type_id = ct.customer_type_id " +
            "inner join account a on c.account_id = a.account_id " +
            "where (c.is_enable = true) and (a.is_enable = true) and (a.username = :username)",
            nativeQuery = true)
    Optional<Tuple> findUserDetailByUsername(@Param("username") String username);


    /*PhucND*/
    @Query(value = "select customer_id, name,phone, customer_address from customer where phone = ?1", nativeQuery = true)
    Optional<CustomerDto> findByPhoneCustomer(String phone);

    @Query(value = "select customer_address from customer where customer_id = ?1", nativeQuery = true)
    String findAddressByCustomerId(Long customerId );
}
