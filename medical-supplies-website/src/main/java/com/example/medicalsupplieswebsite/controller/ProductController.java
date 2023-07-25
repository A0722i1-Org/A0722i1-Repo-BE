package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * VanNT
     * @param
     * @return list all product and paging
     */
    @GetMapping("/home")
    public ResponseEntity<Page<ProductHomeDto>> getAllProduct(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);
        Page<ProductHomeDto> productPage = productService.findAllProducts(
                PageRequest.of(currentPage - 1, pageSize));
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    /**
     * VanNT
     * @param productName
     * @return search list product with productNam or range price or category
     */
    @GetMapping("/home/search-name")
    public ResponseEntity<Page<ProductHomeDto>> searchProducts(
            @RequestParam("productName") String productName,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);
        Page<ProductHomeDto> productPage = productService.searchProduct(productName, PageRequest.of(currentPage - 1, pageSize));
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    /**
     * VanNT
     * @param categoryId
     * @return search list product with productNam or range price or category
     */
    @GetMapping("/home/search-cate")
    public ResponseEntity<Page<ProductHomeDto>> searchProductByCategory(
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);
        Page<ProductHomeDto> productPage = productService.searchProductByCategory(categoryId, PageRequest.of(currentPage - 1, pageSize));
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    /**
     * VanNT
     * @return highest price list product
     */
    @GetMapping("/home/highest")
    public ResponseEntity<List<ProductPriceDto>> getProductPrice() {
        List<ProductPriceDto> productPriceList = productService.getProductListPrice();
        if (productPriceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPriceList, HttpStatus.OK);
    }

}
