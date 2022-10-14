package com.myjavablog.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Customer registerCustomer(CustomerRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        Customer c = customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://fraud/api/v1/fraud/fraud-check/{customerId}",
                FraudCheckResponse.class,
                c.getId()
        );

        if(fraudCheckResponse.getFraudster()){
            throw new IllegalStateException("Fraud customer");
        }

        return c;
    }
}
