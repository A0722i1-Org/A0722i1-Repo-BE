package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select p.product_id,expire_date,is_enable,product_code,product_img,product_name,product_price,product_quantity,category_id,p.customer_id,product_info_id from receipt as r inner join receipt_detail as rd on r.receipt_id = rd.receipt_id inner join product as p on rd.product_id = p.product_id where p.product_id = ?1", nativeQuery = true)
    Product findByProductId(Long productId);
    @Query(nativeQuery = true,
            value = "select p.product_code, p.product_name, ct.category_name, p.product_price, p.expire_date, c.name " +
                    "from product p " +
                    "inner join category ct on p.category_id = ct.category_id " +
                    "inner join customer c on p.customer_id = c.customer_id",
            countQuery = "select count(p.product_code) " +
                    "from product p " +
                    "inner join category ct on p.category_id = ct.category_id " +
                    "inner join customer c on p.customer_id = c.customer_id")
    Page<Supply> findAllSuppliesForAdmin(Pageable pageable);

    @Query(nativeQuery = true,
            value = "select p.product_code, p.product_name, ct.category_name, p.product_price, p.expire_date, c.name " +
                    "from product p " +
                    "inner join category ct on p.category_id = ct.category_id " +
                    "inner join customer c on p.customer_id = c.customer_id " +
                    "where lower(p.product_code) like lower(concat('%', :productCode, '%')) " +
                    "and lower(p.product_name) like lower(concat('%', :productName, '%')) " +
                    "and lower(ct.category_name) like lower(concat('%', :categoryName, '%')) " +
                    "and lower(c.name) like lower(concat('%', :customerName, '%')) " +
                    "and p.expire_date between :expireDateStart and :expireDateEnd ",
            countQuery = "select count(p.product_code) " +
                    "from product p " +
                    "inner join category ct on p.category_id = ct.category_id " +
                    "inner join customer c on p.customer_id = c.customer_id " +
                    "where lower(p.product_code) like lower(concat('%', :productCode, '%')) " +
                    "and lower(p.product_name) like lower(concat('%', :productName, '%')) " +
                    "and lower(ct.category_name) like lower(concat('%', :categoryName, '%')) " +
                    "and lower(c.name) like lower(concat('%', :customerName, '%')) " +
                    "and p.expire_date between :expireDateStart and :expireDateEnd ")
    Page<Supply> searchSupplies(String productCode, String productName,
                                String categoryName, String customerName,
                                String expireDateStart, String expireDateEnd, Pageable pageable);


//    Pham Anh Tài
    @Modifying
    @Transactional
    @Query(value = "insert into product(product_id, productName, productPrice, productQuantity, productImg, productCode, expireDate,isEnable, category, productInfo) values " +
            "(:productName,:productPrice,:productQuantity,:productImg,:productCode,:expireDate,:isEnable,:category,:productInfo)",
            nativeQuery = true)
    Integer saveProduct(@Param("productName") String productName,
                          @Param("productPrice") String productPrice,
                          @Param("productQuantity") String productQuantity,
                          @Param("productImg") String productImg,
                          @Param("productCode") String productCode,
                          @Param("expireDate") String expireDate,
                          @Param("isEnable") String isEnable,
                          @Param("category") Double category,
                          @Param("productInfo") String productInfo
    );

    //    Pham Anh Tài
    @Transactional
    @Query(value = "SELECT * FROM product WHERE id = :id", nativeQuery = true)
    Optional<Product> findByIdNative(@Param("id") Long id);


    //    Pham Anh Tài
    @Transactional
    @Query(value = "select  product_name from product where product_name = ?1", nativeQuery = true)
    String existsProductName(String product_name);
}
