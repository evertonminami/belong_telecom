package com.belong.telecom.service;

import com.belong.telecom.domain.PhoneNumber;
import com.belong.telecom.repository.PhoneNumberRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PhoneNumberServiceTest {
    @Mock
    PhoneNumberRepository mockRepository;

    @InjectMocks
    PhoneNumberService service;

    @Test
    public void should_return_all_numbers() {
        // Given
        List<PhoneNumber> phoneList = Arrays.asList(
                PhoneNumber.builder().id(1L).number("123").build(),
                PhoneNumber.builder().id(2L).number("456").build()
        );

        // Expects
        when(mockRepository.findAll()).thenReturn(phoneList);

        // When
        List<String> result = service.getAllNumbers();

        // Then
        verify(mockRepository).findAll();
        assertNotNull(result);
        assertEquals(phoneList.size(), result.size());
    }

    @Test
    public void should_activate_number() {
        // Given
        PhoneNumber phone =  PhoneNumber.builder().id(1L).number("123").active(false).build();

        // Expects
        when(mockRepository.findById(phone.getId())).thenReturn(Optional.of(phone));

        // When
        PhoneNumber result = service.activateNumber(phone.getId());

        // Then
        verify(mockRepository).findById(phone.getId());
        assertNotNull(result);
        assertTrue(result.isActive());
    }

    @Test
    public void should_return_null_if_number_not_found() {
        // Expects
        long id = 1L;
        when(mockRepository.findById(id)).thenReturn(Optional.empty());

        // When
        PhoneNumber result = service.activateNumber(id);

        // Then
        verify(mockRepository).findById(id);
        assertNull(result);
    }
}
