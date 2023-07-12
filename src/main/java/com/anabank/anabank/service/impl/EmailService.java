package com.anabank.anabank.service.impl;

import com.anabank.anabank.dto.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
