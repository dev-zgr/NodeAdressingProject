package com.example.nodeadressingproject.Services.mappers;

import com.example.nodeadressingproject.Controllers.UserAccountDTO;
import com.example.nodeadressingproject.DataLayer.Entities.UserAccountEntity;

public class UserAccountMapper {
    public static UserAccountEntity mapDTOToEntity(UserAccountDTO userAccountDTO, UserAccountEntity user) {
        user.setName(userAccountDTO.getName());
        user.setEmail(userAccountDTO.getEmail());
        user.setPassword(userAccountDTO.getPassword());
        user.setResearchField(userAccountDTO.getResearchField());
        return user;
    }

    public static UserAccountDTO mapEntityToDTO(UserAccountDTO userAccountDTO,UserAccountEntity user) {
        userAccountDTO.setName(user.getName());
        userAccountDTO.setEmail(user.getEmail());
        userAccountDTO.setPassword(user.getPassword());
        userAccountDTO.setResearchField(user.getResearchField());
        return userAccountDTO;
    }
}
