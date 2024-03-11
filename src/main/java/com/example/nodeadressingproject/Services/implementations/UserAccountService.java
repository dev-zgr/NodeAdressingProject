package com.example.nodeadressingproject.Services.implementations;

import com.example.nodeadressingproject.Controllers.UserAccountDTO;
import com.example.nodeadressingproject.DataLayer.Entities.UserAccountEntity;
import com.example.nodeadressingproject.DataLayer.Repositories.UserAccountRepository;
import com.example.nodeadressingproject.Services.mappers.UserAccountMapper;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public void saveUserAccount(UserAccountDTO userAccountDTO) {
        UserAccountEntity userAccount = UserAccountMapper.mapDTOToEntity(userAccountDTO, new UserAccountEntity());
        userAccountRepository.save(userAccount);
    }

    public UserAccountDTO login(String email, String password) {
        UserAccountEntity userAccount = userAccountRepository.findByEmailAndPassword(email, password).orElse(null);
        if(userAccount == null){
            return null;
        }else {
            return UserAccountMapper.mapEntityToDTO(new UserAccountDTO(),userAccount);
        }
    }
}
