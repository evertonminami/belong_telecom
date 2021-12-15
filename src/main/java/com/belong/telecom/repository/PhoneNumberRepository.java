package com.belong.telecom.repository;

import com.belong.telecom.domain.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {
}