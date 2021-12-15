package com.belong.telecom.service;

import com.belong.telecom.domain.Customer;
import com.belong.telecom.domain.PhoneNumber;
import com.belong.telecom.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepository mockRepository;

    @InjectMocks
    CustomerService service;

    @Test
    public void should_return_phone_list() {
        // Given
        Long id = Long.valueOf(1);
        List<PhoneNumber> phoneList = Arrays.asList(
                PhoneNumber.builder().id(1L).number("123").build(),
                PhoneNumber.builder().id(2L).number("456").build()
        );
        Customer customer = Customer.builder()
                .id(id)
                .phoneNumbers(phoneList)
                .build();

        // Expects
        when(mockRepository.findById(id)).thenReturn(Optional.of(customer));

        // When
        List<String> phones = service.getCustomerPhones(id);

        //Then
        verify(mockRepository).findById(id);
        assertNotNull(phones);
        assertEquals(phones.size(), phoneList.size());
    }

    @Test
    public void should_return_empty_list() {
        // Given
        Long id = Long.valueOf(1);
        Customer customer = Customer.builder()
                .id(id)
                .phoneNumbers(Collections.emptyList())
                .build();

        // Expects
        when(mockRepository.findById(id)).thenReturn(Optional.of(customer));

        // When
        List<String> phones = service.getCustomerPhones(id);

        //Then
        verify(mockRepository).findById(id);
        assertNotNull(phones);
        assertEquals(0, phones.size());
    }

    @Test
    public void should_return_empty_list_when_customer_doesnt_exist() {
        // Given
        Long id = Long.valueOf(1);

        // Expects
        when(mockRepository.findById(id)).thenReturn(Optional.empty());

        // When
        List<String> phones = service.getCustomerPhones(id);

        //Then
        verify(mockRepository).findById(id);
        assertNotNull(phones);
        assertEquals(0, phones.size());
    }
}
