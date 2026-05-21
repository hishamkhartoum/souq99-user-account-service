package com.souq99.useraccountservice.mapper;

import com.souq99.useraccountservice.domain.dto.CreateRoleDTO;
import com.souq99.useraccountservice.domain.dto.RoleDTO;
import com.souq99.useraccountservice.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    Role toRole(RoleDTO roleDTO);
    RoleDTO toDTO(Role role);
    Role toRoleFromCreateRoleDTO(CreateRoleDTO createRoleDTO);
}
