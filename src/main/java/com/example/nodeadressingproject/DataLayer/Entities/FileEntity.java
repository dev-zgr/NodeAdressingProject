package com.example.nodeadressingproject.DataLayer.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private UUID fileIdentifier;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileData;
}

