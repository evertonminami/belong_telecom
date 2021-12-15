package com.belong.telecom.web.controller.rest;

import com.belong.telecom.service.PhoneNumberService;
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
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    @Operation(summary = "get all phone numbers")
    @GetMapping(value = "/phones")
    public List<String> getPhoneNumbers() {
        return phoneNumberService.getAllNumbers();
    }

    @Operation(summary = "activate a phone number")
    @GetMapping(value = "/phone/{id}/activate")
    public void activateNumbers(@PathVariable Long id) {
        phoneNumberService.activateNumber(id);
    }
}