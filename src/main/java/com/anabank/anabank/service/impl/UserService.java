package com.anabank.anabank.service.impl;

import com.anabank.anabank.dto.BankResponse;
import com.anabank.anabank.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
