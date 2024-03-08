package com.example.nodeadressingproject.DataLayer.Repositories;

import com.example.nodeadressingproject.DataLayer.Entities.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
    Optional<UserAccountEntity> findByEmailAndPassword(String email, String password);
}
