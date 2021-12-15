package com.belong.telecom.service;

import com.belong.telecom.domain.Customer;
import com.belong.telecom.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<String> getCustomerPhones(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null && customer.getPhoneNumbers() != null) {
            return customer.getPhoneNumbers().stream()
                    .map(p -> p.getNumber())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
