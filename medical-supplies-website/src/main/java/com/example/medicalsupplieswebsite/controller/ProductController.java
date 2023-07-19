package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * VanNT
     * @param pageable (8 item/page)
     * @return list all product and paging
     */
    @GetMapping("")
    public ResponseEntity<Page<ProductHomeDto>> getAllProduct(
            @PageableDefault(value = 8) Pageable pageable) {
        Page<ProductHomeDto> productPage  = productService.findAllProducts(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    /**
     * VanNT
     * @param productName
     * @param categoryName
     * @param minPrice
     * @param maxPrice
     * @param pageable
     * @return search list product with productNam or range price or category
     */
    @GetMapping("/search")
    public ResponseEntity<Page<ProductHomeDto>> searchProducts(
            @RequestParam("productName") Optional<String> productName ,
            @RequestParam("categoryName") Optional<String> categoryName,
            @RequestParam("minPrice") Optional<String> minPrice,
            @RequestParam("maxPrice") Optional<String> maxPrice,
            @PageableDefault(size = 8) Pageable pageable) {
        Page<ProductHomeDto> check = productService.findAllProducts(Pageable.unpaged());
        String productNameSearch,categoryNameSearch, minPriceSearch, maxPriceSearch;
        productNameSearch = productName.orElse("");
        categoryNameSearch = categoryName.orElse("");
        minPriceSearch = minPrice.orElse("0");
        maxPriceSearch = maxPrice.orElse("99999999999");
        Page<ProductHomeDto> productPage = productService.searchProduct(productNameSearch, categoryNameSearch, minPriceSearch, maxPriceSearch, pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    /**
     * VanNT
     * @return  highest price list product
     */
    @GetMapping("/highest")
    public ResponseEntity<List<ProductPriceDto>> getProductPrice(){
        List<ProductPriceDto> productPriceList  = productService.getProductListPrice();
        if (productPriceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPriceList, HttpStatus.OK);
    }



}
