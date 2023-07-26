package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductCreateDTO;
import com.example.medicalsupplieswebsite.dto.ResponseToClient;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.error.NotFoundById;
import com.example.medicalsupplieswebsite.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @PostMapping("")
    public ResponseEntity<ResponseToClient> createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        if (productService.existsProductName(productCreateDTO.getProductName()) != null){
            return ResponseEntity.badRequest().body(new ResponseToClient("Tên vật tư đã được sử đụng"));
        }
        Product product = new Product(productCreateDTO);
        productService.saveProduct(product);
        return new ResponseEntity<>(new ResponseToClient("Thêm mới vật tư thành công"),HttpStatus.CREATED);
    }



    @PutMapping("/update")
    public ResponseEntity<Product> updateEmployee(@Valid @RequestBody ProductCreateDTO productCreateDTO) throws NotFoundById {
        Product product = productService.findById(productCreateDTO.getProductId());
        BeanUtils.copyProperties(productCreateDTO,product);
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @GetMapping("/detail1/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) throws NotFoundById {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("update")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO){
        Product product = productService.findById(productCreateDTO.getProductId());
        productService.updateProductValid(productCreateDTO);
        return new ResponseEntity<>(productService.findByIdNative(productCreateDTO.getProductId()),HttpStatus.OK);
    }

}
