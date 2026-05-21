package com.souq99.useraccountservice.convertor;

import com.souq99.useraccountservice.domain.dto.RegistrationRequest;
import com.souq99.useraccountservice.domain.entity.User;
import com.souq99.useraccountservice.domain.value.AuthMethod;
import org.jspecify.annotations.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RegistrationRequestToUserConvertor implements Converter<RegistrationRequest, User> {

    @Override
    public @Nullable User convert(RegistrationRequest source) {
        return User.builder()
                .email(source.getEmail())
                .name(source.getName())
                .phone(source.getPhone())
                .terms(source.getTerms())
                .emailVerified(false)
                .active(true)
                .provider(AuthMethod.LOCAL)
                .build();
    }
}
