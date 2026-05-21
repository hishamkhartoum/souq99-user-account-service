package com.souq99.useraccountservice.mapper;


import com.souq99.useraccountservice.domain.dto.UpdateUserRequest;
import com.souq99.useraccountservice.domain.dto.UserDTO;
import com.souq99.useraccountservice.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toUserFromUpdateUserRequest(UpdateUserRequest updateUserRequest);
    User toUser(UserDTO userDTO);
    UserDTO toDTO(User user);
}
