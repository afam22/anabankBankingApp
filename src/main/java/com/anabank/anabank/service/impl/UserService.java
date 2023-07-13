package com.anabank.anabank.service.impl;

import com.anabank.anabank.dto.BankResponse;
import com.anabank.anabank.dto.EnquiryRequest;
import com.anabank.anabank.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
}
