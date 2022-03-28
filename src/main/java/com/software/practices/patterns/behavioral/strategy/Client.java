package com.software.practices.patterns.behavioral.strategy;

import com.software.practices.patterns.behavioral.strategy.services.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("kyc")
public class Client {

    @Autowired
    private KycService kycService;

    @PostMapping
    public void doKyc() {
        kycService.doKyc();
    }
}