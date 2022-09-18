package com.myjavablog.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/register")
    public Customer resgisterCustomer(@RequestBody CustomerRequest customerRequest){

        Customer customer = customerService.registerCustomer(customerRequest);

        CustomerResponse customerResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud/fraud-check/{customerId}",
                CustomerResponse.class,
                customer.getId()
        );

        if(customerResponse.getFraudster()){
            throw new IllegalStateException("Fraud customer");
        }
        return customer;
    }
}
