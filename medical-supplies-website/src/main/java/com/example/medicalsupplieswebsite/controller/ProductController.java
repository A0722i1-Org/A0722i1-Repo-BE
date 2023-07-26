package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductDTO;
import com.example.medicalsupplieswebsite.dto.ResponseToClient;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.error.NotFoundById;
import com.example.medicalsupplieswebsite.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @PostMapping("")
    public ResponseEntity<ResponseToClient> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        if (productService.existsProductName(productDTO.getProductName()) != null){
            return ResponseEntity.badRequest().body(new ResponseToClient("Tên vật tư đã được sử đụng"));
        }
        Product product = new Product(productDTO);
        productService.saveProduct(product);
        return new ResponseEntity<>(new ResponseToClient("Thêm mới vật tư thành công"),HttpStatus.CREATED);
    }



    @PutMapping("/update")
    public ResponseEntity<Product> updateEmployee(@Valid @RequestBody ProductDTO productDTO) throws NotFoundById {
        Product product = productService.findById(productDTO.getProductId());
        BeanUtils.copyProperties(productDTO,product);
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) throws NotFoundById {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("update")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDTO productDTO ){
        Product product = productService.findById(productDTO.getProductId());
        productService.updateProductValid(productDTO);
        return new ResponseEntity<>(productService.findByIdNative(productDTO.getProductId()),HttpStatus.OK);
    }

}
