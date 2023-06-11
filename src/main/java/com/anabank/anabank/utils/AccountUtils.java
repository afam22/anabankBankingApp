package com.anabank.anabank.utils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account created!!!";
    public static final String ACCOUNT_CREATION_SUCCESS_CODE = "002";
    public static final String ACCOUNT_CREATION_SUCCESS_MESSAGE = "Account successfully created";


    /*
    For my account number builder assuming i have a 10-digit account number
    I want to build an account stating with 2023 + randomSixDigits
     */

    public static String generateAccountNumber(){
        Year currentYear = Year.now();
        int min = 100000;           //minimum 6-digit number starting with 1
        int max = 999999;           //maximum 6-digit number ending in 999999

        //generating a random number between min and max
        int randNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);

        //convert the current and randomNumber to Strings, then concatenate them

        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);

        StringBuilder accountNumber = new StringBuilder();

        return accountNumber.append(year).append(randomNumber).toString();

    }

}
