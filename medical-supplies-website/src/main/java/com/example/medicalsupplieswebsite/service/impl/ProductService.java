package com.example.medicalsupplieswebsite.service.impl;

import com.example.medicalsupplieswebsite.dto.Supply;
import com.example.medicalsupplieswebsite.dto.receipt_dto.ProductDTO;
import com.example.medicalsupplieswebsite.dto.ProductHomeDto;
import com.example.medicalsupplieswebsite.dto.ProductPriceDto;
import com.example.medicalsupplieswebsite.dto.shipmentdto.ProductDto;
import com.example.medicalsupplieswebsite.entity.Product;
import com.example.medicalsupplieswebsite.repository.IProductRepository;
import com.example.medicalsupplieswebsite.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Product findByIdProductShipment(Long productId) {
        return iProductRepository.findByIdProductShipment(productId);
    }

    @Override
    public Product findByProductId(Long productId) {
        return iProductRepository.findByProductId(productId);
    }

    @Override
    public Page<Supply> findAllSuppliesForAdmin(Pageable pageable) {
        return iProductRepository.findAllSuppliesForAdmin(pageable);
    }

    @Override
    public Page<Supply> searchSupplies(String productCode, String productName, String categoryName,
                                       String customerName, String expireDateStart, String expireDateEnd,
                                       Pageable pageable) {
        return iProductRepository.searchSupplies(productCode, productName, categoryName, customerName, expireDateStart, expireDateEnd, pageable);
    }

    @Override
    public List<ProductDTO> getAllProductByCustomerID(Long customerId) {
        return iProductRepository.getAllProductByCustomerID(customerId);
    }

    @Override
    public ProductDTO findProductDTOByProductId(Long productId) {
        return iProductRepository.findProductDTOByProductId(productId);
    }

    @Override
    public Page<ProductHomeDto> findAllProducts(Pageable pageable) {
        return iProductRepository.findAllProduct(pageable);
    }

    @Override
    public Page<ProductHomeDto> searchProduct(String productName, Pageable pageable) {
        return iProductRepository.searchProduct(productName, pageable);
    }

    @Override
    public Page<ProductHomeDto> searchProductByCategory(Long categoryId, Pageable pageable) {
        return iProductRepository.searchProductByCategory(categoryId, pageable);
    }

    @Override
    public List<ProductPriceDto> getProductListPrice() {
        return iProductRepository.getProductPrice();
    }


    @Override
    public List<ProductDto> findAllProductCreateShipment() {
        return iProductRepository.findAllProductCreateShipment();
    }

    @Override
    public Product findByProductIdIs(Long productId) {
        return iProductRepository.findByProductIdIs(productId);
    }
    @Override
    public Product findByIdProductDetail(Long id) {
        return iProductRepository.findByIdProductDetail(id);
    }
}
