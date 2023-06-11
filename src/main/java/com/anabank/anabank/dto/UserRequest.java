package com.anabank.anabank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

/*
It used to restrict exposure of certain fields to the user available via user entity.

It also helps to separate object creations from the entity by
creating a Data Transfer Object Dto class that will be used to
collect data from user and upsert into the database.
 */
public class UserRequest {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String status;
}
