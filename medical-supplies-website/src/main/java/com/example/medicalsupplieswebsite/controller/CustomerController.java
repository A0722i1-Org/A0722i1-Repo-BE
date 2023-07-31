package com.example.medicalsupplieswebsite.controller;
import com.example.medicalsupplieswebsite.dto.CustomerInfo;
import com.example.medicalsupplieswebsite.dto.CustomerUserDetailDto;
import com.example.medicalsupplieswebsite.entity.Customer;
import com.example.medicalsupplieswebsite.entity.CustomerType;
import com.example.medicalsupplieswebsite.service.impl.CustomerService;
import com.example.medicalsupplieswebsite.service.impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService iCustomerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public ResponseEntity<Page<Customer>> findAllCustomer(@RequestParam(value = "keyword", required = false) Optional<String> keyword,
                                                          @RequestParam("page") Optional<Integer> page,
                                                          @RequestParam("size") Optional<Integer> size) {
        String keywordSearch = keyword.orElse("");
        int pages = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Customer> searchName = this.iCustomerService.searchCustomers(keywordSearch, PageRequest.of(pages - 1, pageSize));
        if (searchName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(searchName, HttpStatus.OK);
        }
    }

    /**
     *
     * A0722I1-HieuLD
     */
    @PostMapping("/create")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerInfo customerInfo, BindingResult bindingResult) {
        new CustomerInfo().validate(customerInfo, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    error -> {
                        String fieldName = error.getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                    });
            return ResponseEntity.badRequest().body(errors);
        } else {
            iCustomerService.saveCustomer(customerInfo);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     *
     * A0722I1-HieuLD
     */
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(iCustomerService.findById(id),HttpStatus.OK);
    }


    /**
     *
     * A0722I1-HieuLD
     */
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateCustomer(@Valid @PathVariable Long id, @RequestBody CustomerInfo employeeInfo, BindingResult bindingResult) {
    new CustomerInfo().validate(employeeInfo, bindingResult);
    if (bindingResult.hasErrors()) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(
                error -> {
                    String fieldName = error.getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return ResponseEntity.badRequest().body(errors);
    } else {
        iCustomerService.update(employeeInfo, id);

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * A0722I1-KhanhNL
     */
    @GetMapping("/detail")
    public ResponseEntity<CustomerUserDetailDto> getDetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        CustomerUserDetailDto customerUserDetailDto = iCustomerService.findUserDetailByUsername(username);

        if (customerUserDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerUserDetailDto, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        iCustomerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customertype")
    public ResponseEntity<List<CustomerType>> findAllCustomerType() {
        List<CustomerType> customerTypes = this.customerTypeService.findAllCustomerType();
        if (customerTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerTypes, HttpStatus.OK);
        }
    }
}

