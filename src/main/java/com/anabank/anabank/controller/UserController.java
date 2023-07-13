package com.anabank.anabank.controller;

import com.anabank.anabank.dto.BankResponse;
import com.anabank.anabank.dto.EnquiryRequest;
import com.anabank.anabank.dto.UserRequest;
import com.anabank.anabank.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }

    @RequestMapping(value = "/balanceEnquiry", method = { RequestMethod.GET, RequestMethod.POST })
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }

    @RequestMapping(value = "/nameEnquiry", method = { RequestMethod.GET, RequestMethod.POST })
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }

}