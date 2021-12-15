package com.belong.telecom.service;

import com.belong.telecom.domain.PhoneNumber;
import com.belong.telecom.repository.PhoneNumberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;

    public List<String> getAllNumbers() {
        List<PhoneNumber> numberList = (List<PhoneNumber>) phoneNumberRepository.findAll();
        log.info("{} phone numbers found", numberList.size());
        return numberList.stream().map(p -> p.getNumber()).collect(Collectors.toList());
    }

    @Transactional
    public PhoneNumber activateNumber(Long id) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id).orElse(null);
        if (phoneNumber != null) {
            phoneNumber.setActive(true);
            log.info("Phone number {} was activated", phoneNumber.getNumber());
            return phoneNumber;
        } else {
            log.warn("Could not find phone number with id {}", id);
            return null;
        }
    }
}
