package com.souq99.useraccountservice.service;

import java.util.Locale;

public interface MessageService {
    String getLocalizedMessage(String messageId, Locale locale);
    String getLocalizedMessage(String messageId, Object[] args, Locale locale);
}
