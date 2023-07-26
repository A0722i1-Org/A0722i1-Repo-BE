package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductCreateDTO;
import com.example.medicalsupplieswebsite.dto.ResponseToClient;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.error.NotFoundById;
import com.example.medicalsupplieswebsite.service.IProductService;
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

    /**
     * A0722I1 - ThanhDT
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    private ResponseEntity<Product> findByIdProductDetail(@PathVariable Long id) {
        Product product = productService.findByIdProductDetail(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


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
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
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
