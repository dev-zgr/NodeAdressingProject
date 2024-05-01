package com.example.nodeadressingproject.DataLayer.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Entity class representing a node record in the blockchain.
 * Each node record includes a unique identifier (UUID), IP address, an activation status, and a public key in byte array format.
 */
@Entity
@Data
@Table(name = "NRS")
public class NodeRecord {

    @Column(name = "uuid")
    @Id
    private UUID uuid;

    @Column(name = "ip-adress")
    private String ipAddress;

    @Column(name = "is-active")
    boolean isActive;

    @Lob
    @Column(name = "public-key", columnDefinition="BLOB")
    private byte[] publicKey;

    /**
     * Constructor for creating a NodeRecord with a specified UUID, IP address, activation status, and a public key.
     *
     * @param uuid      The unique identifier (UUID) of the node.
     * @param ipAddress The IP address of the node.
     * @param isActive  The activation status of the node.
     * @param publicKey The public key of the node.
     */
    public NodeRecord(UUID uuid, String ipAddress, boolean isActive, byte[] publicKey){
        this.ipAddress = ipAddress;
        this.uuid = uuid;
        this.isActive = isActive;
        this.publicKey = publicKey;
    }

    /**
     * Default constructor for creating a NodeRecord with default values.
     */
    public NodeRecord(){
        this.uuid = null;
        this.ipAddress = null;
        this.isActive = false;
        this.publicKey = null;
    }
}

