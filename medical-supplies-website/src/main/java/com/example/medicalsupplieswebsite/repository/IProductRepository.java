package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select p.product_id,expire_date,is_enable,product_code,product_img,product_name,product_price," +
            "product_quantity,category_id,p.customer_id,\n" + "product_info_id from shipment as s inner join shipment_detail " +
            "as sd on \n" + "s.shipment_id = sd.shipment_id inner join product as p on sd.product_id = p.product_id " +
            "where p.product_id = ?1", nativeQuery = true)
    Product findByIdProductShipment(Long productId);
}
