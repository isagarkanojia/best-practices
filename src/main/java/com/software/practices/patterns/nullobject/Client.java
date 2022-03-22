package com.software.practices.patterns.nullobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Sagar Kanojia
 */
@Component
public class Client {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {

        Client client = new Client();

        Customer customer = client.getCustomerByPhoneNumber("+1002725828357");

        // no need of these null checks by using null object pattern.
        // code becomes simple and has less duplicate code
        String  name = customer != null ? customer.getName() : "Not Found";
        String id = customer != null ? customer.getName() : "Not Found";


    }

    private Customer getCustomerByPhoneNumber(String phoneNumber) {

        Customer customer = customerRepository.findByPhoneNumber(phoneNumber);

        if (Objects.isNull(customer)) {
            return Customer.NotFound;
        }

        return customer;
    }
}
