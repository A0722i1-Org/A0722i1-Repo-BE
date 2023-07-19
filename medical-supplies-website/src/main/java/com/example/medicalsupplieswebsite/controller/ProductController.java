package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.ProductDTO;
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
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        if (productService.existsProductName(productDTO.getProductName()) != null){
            return ResponseEntity.badRequest().body("Tên vật tư đã được sử đụng");
        }
        Product product = new Product(productDTO);
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) throws NotFoundById {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateEmployee(@RequestBody ProductDTO productDTO) {
        Product product = productService.findById(productDTO.getId());
        BeanUtils.copyProperties(productDTO,product);
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Map<String,Object> fields, BindingResult bindingResult){
        return new ResponseEntity<>(productService.UpdateProductByFiled(id,fields),HttpStatus.OK);
    }

}
