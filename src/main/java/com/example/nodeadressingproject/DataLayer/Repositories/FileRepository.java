package com.example.nodeadressingproject.DataLayer.Repositories;

import com.example.nodeadressingproject.DataLayer.Entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileRepository extends JpaRepository<FileEntity, Long>{
    Optional<FileEntity> findByFileIdentifier(UUID fileIdentifier);
}
