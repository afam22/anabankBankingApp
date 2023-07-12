package com.anabank.anabank.service.impl;

import com.anabank.anabank.dto.AccountInfo;
import com.anabank.anabank.dto.BankResponse;
import com.anabank.anabank.dto.EmailDetails;
import com.anabank.anabank.dto.UserRequest;
import com.anabank.anabank.entity.User;
import com.anabank.anabank.repository.UserRepository;
import com.anabank.anabank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;
    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
        * In creating an account: This is saving a new user into the database
        * First, Check if user already has an account
         */

        if (userRepository.existsByEmail(userRequest.getEmail())){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")                       //Assuming the account is active
                .build();

        //save user into the database.
        User savedUser = userRepository.save(newUser);
        //send email alert for account creation to user
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject(AccountUtils.ACCOUNT_CREATION_EMAIL_SUBJECT)
                .messageBody(
                        "Congratulations! Your Account has been Successfully Created. \n " +
                                "Your Account Details: \n" +
                                "Account Name: " + savedUser.getFirstName() + " " + savedUser.getLastName() + " " +
                                savedUser.getOtherName() + " \n " +
                                "Account Number: " + savedUser.getAccountNumber()
                )
                .build();
        emailService.sendEmailAlert(emailDetails);


        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(savedUser.getFirstName() + " " + savedUser.getOtherName() + " " + savedUser.getLastName())
                        .build())
                .build();
    }
}
