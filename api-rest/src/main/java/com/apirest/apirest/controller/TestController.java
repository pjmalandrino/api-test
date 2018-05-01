package com.apirest.apirest.controller;


import com.apirest.apirest.service.WalletGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("/sign")
    public String testControllerMethod(){

        WalletGenerator walletGenerator = new WalletGenerator();
        return walletGenerator.testWalletCreation();


    }

}
