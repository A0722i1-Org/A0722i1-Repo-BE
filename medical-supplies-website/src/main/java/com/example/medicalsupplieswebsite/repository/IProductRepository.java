package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.dto.shipmentdto.ProductDto;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product,Long> {
    /*PhucND tìm kiếm id product trong shipment*/
    @Query(value = "select product_id,expire_date,is_enable,product_code,product_img,product_name,product_price,\n" +
            "            product_quantity,category_id,customer_id,product_info_id from product\n" +
            "            where product_id = ?", nativeQuery = true)
    Product findByIdProductShipment(Long productId);
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

    /*PhucND hiển thị thông tin vật tư để xuất kho*/
    @Query(value = "select product_id,product_name,product_quantity,product_price from product", nativeQuery = true)
    List<ProductDto> findAllProductCreateShipment();

    /*PhucND findById productShipment*/
    Product findByProductIdIs(Long productId);

}
