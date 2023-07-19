package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    /**
     * VanNT
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
     * @param productName
     * @param categoryName
     * @param minPrice
     * @param maxPrice
     * @param pageable
     * @return search product with productNam and categoryNam and productPrice
     */
    @Query(nativeQuery = true,
            value = "SELECT p.product_id, p.product_name, p.product_img, p.product_price, ct.category_name " +
                    "FROM product p " +
                    "INNER JOIN category ct ON p.category_id = ct.category_id " +
                    "WHERE lower(p.product_name) LIKE lower(concat('%', :productName, '%')) " +
                    "AND lower(ct.category_name) LIKE lower(concat('%', :categoryName, '%')) " +
                    "AND p.product_price BETWEEN :minPrice AND :maxPrice",
            countQuery = "SELECT COUNT(p.product_id) " +
                    "FROM product p " +
                    "INNER JOIN category ct ON p.category_id = ct.category_id " +
                    "WHERE lower(p.product_name) LIKE lower(concat('%', :productName, '%'))" +
                    "AND lower(ct.category_name) LIKE lower(concat('%', :categoryName, '%')) " +
                    "AND p.product_price BETWEEN :minPrice AND :maxPrice")

    Page<ProductHomeDto> searchProduct(String productName,
                                String categoryName, String minPrice, String maxPrice,Pageable pageable);

    /**
     * VanNT
     * @return list highest price product
     */
    @Query(nativeQuery = true,
            value = "SELECT product_id, product_img, product_price " +
                    "FROM product "+
                    "ORDER BY product_price DESC " +
                    "LIMIT 3",
            countQuery = "SELECT COUNT(product_id) " +
                    "FROM product" +
                    "ORDER BY product_price DESC " +
                    "LIMIT 3")
    List<ProductPriceDto> getProductPrice();
}


