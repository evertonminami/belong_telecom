package com.belong.telecom.web.controller.rest;

import com.belong.telecom.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Telecom")
@RequestMapping(path = "/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @Operation(summary = "get all phone numbers of a single customer")
    @GetMapping(value = "/customer/{id}/phones")
    public List<String> getCustomerPhones(@PathVariable Long id) {
        return customerService.getCustomerPhones(id);
    }
}