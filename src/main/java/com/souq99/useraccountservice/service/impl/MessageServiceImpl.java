package com.souq99.useraccountservice.service.impl;


import com.souq99.useraccountservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;

    @Override
    public String getLocalizedMessage(String messageId, Locale locale) {
        return messageSource.getMessage(messageId, null, locale);
    }

    @Override
    public String getLocalizedMessage(String messageId, Object[] args, Locale locale) {
        return messageSource.getMessage(messageId, args, locale);
    }
}
