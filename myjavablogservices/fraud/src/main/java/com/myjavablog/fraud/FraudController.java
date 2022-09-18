package com.myjavablog.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/fraud")
@Slf4j
public class FraudController {

    @Autowired
    private FraudCheckService fraudCheckService;

    @GetMapping("/fraud-check/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){

        boolean isFraudster = fraudCheckService.isFraudster(customerId);

        log.info("Customer fraud staus check for "+ customerId +" is "+ isFraudster);

        return new FraudCheckResponse(isFraudster);
    }
}
