package com.software.practices.patterns.nullobject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Sagar Kanojia
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findByPhoneNumber(String phoneNumber);
}
