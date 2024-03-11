package com.example.nodeadressingproject.Services.implementations;

import com.example.nodeadressingproject.DataLayer.Entities.FileEntity;
import com.example.nodeadressingproject.DataLayer.Repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }



    public void saveFile(FileEntity fileEntity) {
        fileRepository.save(fileEntity);
    }

    public FileEntity getFileByUUID(UUID uuid){
        if (fileRepository.findByFileIdentifier(uuid).isPresent()){
            return fileRepository.findByFileIdentifier(uuid).get();
        }else {
            return null;
        }
    }
}
