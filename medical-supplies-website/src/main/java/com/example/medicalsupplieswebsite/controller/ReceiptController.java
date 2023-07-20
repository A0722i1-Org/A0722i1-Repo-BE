package com.example.medicalsupplieswebsite.controller;

import com.example.medicalsupplieswebsite.dto.receipt_dto.ReceiptDTO;
import com.example.medicalsupplieswebsite.dto.receipt_dto.ReceiptDetailDTO;
import com.example.medicalsupplieswebsite.service.ICustomerService;
import com.example.medicalsupplieswebsite.service.IProductService;
import com.example.medicalsupplieswebsite.service.IReceiptDetailService;
import com.example.medicalsupplieswebsite.service.IReceiptService;
import com.example.medicalsupplieswebsite.validate.ReceiptValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/receipt")
public class ReceiptController {
    @Autowired
    IReceiptDetailService iReceiptDetailService;
    @Autowired
    IReceiptService iReceiptService;
    @Autowired
    IProductService iProductService;
    @Autowired
    ReceiptValidate receiptValidate;
    @Autowired
    ICustomerService iCustomerService;
//    ThanhVK code lưu phiếu nhập kho
    @PostMapping(value = "/create")
    public ResponseEntity<?> createReceipt(@Valid @RequestBody ReceiptDTO receiptDTO, BindingResult bindingResult){
        receiptValidate.validate(receiptDTO,bindingResult);
        if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        iReceiptService.addNewReceipt(receiptDTO.getDateOfCreate(),receiptDTO.getInvoiceCode(),receiptDTO.getCustomerId(),receiptDTO.getCustomerId(),receiptDTO.getReceiptTypeId());
        Long receiptId = iReceiptService.findByReceiptIdByInvoiceCode(receiptDTO.getInvoiceCode());
        for(ReceiptDetailDTO listReceiptDetailDTO: receiptDTO.getReceiptDetailDTOS()){
            if(iProductService.findByProductId(listReceiptDetailDTO.getProductId()) != null){
                iProductService.findByProductId(listReceiptDetailDTO.getProductId()).setProductQuantity(iProductService.findByProductId(listReceiptDetailDTO.getProductId()).getProductQuantity()+ listReceiptDetailDTO.getQuantity());
            }
            iReceiptDetailService.addNewReceiptDetail(listReceiptDetailDTO.getQuantity(), listReceiptDetailDTO.getProductId(),receiptId);
        }
        return new ResponseEntity<>(receiptDTO, HttpStatus.CREATED);
    }
    //    ThanhVK code tìm kiếm địa chỉ theo mã khách hàng
    @GetMapping(value = "/address/{customerId}")
    public ResponseEntity<?> getAddress(@PathVariable("customerId") Long customerId){
        String address = iCustomerService.findAddressByCustomerId(customerId);
        if(address==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
