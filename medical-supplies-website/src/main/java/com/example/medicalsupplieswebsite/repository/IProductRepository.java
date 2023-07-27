package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.dto.shipmentdto.ProductDto;
import com.example.medicalsupplieswebsite.dto.receipt_dto.ProductDTO;
import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    /*PhucND tìm kiếm id product trong shipment*/
    @Query(value = "select product_id,expire_date,is_enable,product_code,product_img,product_name,product_price,\n" +
            "            product_quantity,category_id,customer_id,product_info_id from product\n" +
            "            where product_id = ?", nativeQuery = true)
    Product findByIdProductShipment(Long productId);

//    @Query(value = "select p.product_id,expire_date,is_enable,product_code,product_img,product_name,product_price,product_quantity,category_id,p.customer_id,product_info_id from receipt as r inner join receipt_detail as rd on r.receipt_id = rd.receipt_id inner join product as p on rd.product_id = p.product_id where p.product_id = ?1", nativeQuery = true)

    @Query(value = "select product_id,expire_date,is_enable,product_code,product_img,product_name,product_price,product_quantity,category_id,customer_id,product_info_id from product where product_id = ?1", nativeQuery = true)
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

    @Query(value = "select product_id,product_name,product_quantity,product_price,expire_date  from customer as c inner join product as p on c.customer_id = p.customer_id where c.customer_id = ?1", nativeQuery = true)
    List<ProductDTO> getAllProductByCustomerID(Long customerId);

    @Query(value = "select product_id,product_name,product_quantity,product_price,expire_date from product where product_id = ?1", nativeQuery = true)
    ProductDTO findProductDTOByProductId(Long productId);

    /**
     * VanNT
     *
     * @param pageable
     * @return page product
     */
    @Query(nativeQuery = true,
            value = "SELECT product_id, product_name, product_img, product_price, category_name " +
                    "FROM product " +
                    "JOIN category ON product.category_id = category.category_id",
            countQuery = "SELECT COUNT(product_id) " +
                    "FROM product " +
                    "JOIN category ON product.category_id = category.category_id")
    Page<ProductHomeDto> findAllProduct(Pageable pageable);

    /**
     * VanNT
     *
     * @param productName
     * @param pageable
     * @return search product with productNam and categoryNam and productPrice
     */
    @Query(nativeQuery = true,
            value = "SELECT p.product_id, p.product_name, p.product_img, p.product_price, ct.category_name " +
                    "FROM product p " +
                    "INNER JOIN category ct ON p.category_id = ct.category_id " +
                    "WHERE lower(p.product_name) LIKE lower(concat('%', :productName, '%')) ",
            countQuery = "SELECT COUNT(p.product_id) " +
                    "FROM product p " +
                    "INNER JOIN category ct ON p.category_id = ct.category_id " +
                    "WHERE lower(p.product_name) LIKE lower(concat('%', :productName, '%'))")
    Page<ProductHomeDto> searchProduct(String productName,Pageable pageable);

    /**
     * VanNT
     *
     * @param pageable
     * @return search product with productNam and categoryNam and productPrice
     */
    @Query(nativeQuery = true,
            value = "SELECT p.product_id, p.product_name, p.product_img, p.product_price, ct.category_name " +
                    "FROM product p " +
                    "INNER JOIN category ct ON p.category_id = ct.category_id " +
                    "WHERE lower(p.category_id) LIKE lower(concat('%', :categoryId, '%')) ",
            countQuery = "SELECT COUNT(p.product_id) " +
                    "FROM product p " +
                    "INNER JOIN category ct ON p.category_id = ct.category_id " +
                    "WHERE lower(p.category_id) LIKE lower(concat('%', :categoryId, '%'))")
    Page<ProductHomeDto> searchProductByCategory(@Param("categoryId") Long categoryId, Pageable pageable);

    /**
     * VanNT
     * @return list highest price product
     */
    @Query(nativeQuery = true,
            value = "SELECT product_id, product_img, product_price " +
                    "FROM product " +
                    "ORDER BY product_price DESC " +
                    "LIMIT 3")
    List<ProductPriceDto> getProductPrice();

    /**
     * A0722I1 - ThanhDT
     *
     * @param id
     * @return
     */
    @Query(value = "SELECT p.product_id, p.product_img, p.product_name, p.product_price, p.product_quantity, " +
            "p.is_enable, p.expire_date, p.product_code, p.product_info_id, " +
            "pi.info_id, pi.info_introduction, pi.info_description, pi.trademark, pi.place_of_manufacture, " +
            "p.category_id, p.customer_id " +
            "FROM product p " +
            "inner join product_info pi on p.product_info_id = pi.info_id " +
            "where p.product_id = :id", nativeQuery = true)
    Product findByIdProductDetail(@Param("id") Long id);


    /*PhucND hiển thị thông tin vật tư để xuất kho*/
    @Query(value = "select product_id,product_name,product_quantity,product_price from product", nativeQuery = true)
    List<ProductDto> findAllProductCreateShipment();

    /*PhucND findById productShipment*/
    Product findByProductIdIs(Long productId);
}
