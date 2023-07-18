package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductDTO;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.error.NotFoundById;
import com.example.medicalsupplieswebsite.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product product = new Product(productDTO);
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }



//    @PutMapping("update")
//    public ResponseEntity<?> updateEmployee(@RequestBody ProductDTO productDTO) throws NotFoundById {
//        Product product = productService.findById(productDTO.getId());
//        Product product1 = new Product(
//                productDTO.getProductName(),
//                productDTO.getProductPrice(),
//                productDTO.getProductQuantity(),
//                productDTO.getProductImg(),
//                productDTO.getProductCode(),
//                productDTO.getExpireDate(),
//                false,
//                productDTO.getCategory(),
//                productDTO.getProductInfo(),
//                productDTO.getCustomer()
//        );
//        return new ResponseEntity<>(productService.save(product1), HttpStatus.OK);
//    }

//        Product product = new Product(
//                productDTO.getProductName(),
//                productDTO.getProductPrice(),
//                productDTO.getProductQuantity(),
//                productDTO.getProductImg(),
//                productDTO.getProductCode(),
//                productDTO.getExpireDate(),
//                false,
//                productDTO.getCategory(),
//                productDTO.getProductInfo(),
//                productDTO.getCustomer()
//        );

}
