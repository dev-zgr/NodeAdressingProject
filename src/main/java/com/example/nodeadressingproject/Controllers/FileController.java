package com.example.nodeadressingproject.Controllers;

import com.example.nodeadressingproject.DataLayer.Entities.FileEntity;
import com.example.nodeadressingproject.Services.implementations.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(path = "/file", produces = "application/json")
    public ResponseEntity<String> saveFile(@RequestBody FileEntity fileEntity) {
        try {
            fileService.saveFile(fileEntity);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("File saved successfully");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving file");
        }
    }

    @GetMapping(path = "/file")
    public ResponseEntity<byte[]> getFileByUUID(@RequestParam(name = "uuid") UUID uuid){
        try {
            FileEntity file = fileService.getFileByUUID(uuid);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "filename.pdf");
            if(file == null){
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body(null);
            }else {
                return ResponseEntity.ok()
                        .headers(headers)
                        .body(file.getFileData());
            }
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
