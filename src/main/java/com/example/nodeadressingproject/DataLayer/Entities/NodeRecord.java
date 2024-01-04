package com.example.nodeadressingproject.DataLayer.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.w3c.dom.Node;

import java.util.UUID;

/**
 * Entity class representing a node record in the blockchain.
 * Each node record includes a unique identifier (UUID), IP address, and an activation status.
 */
@Entity
@Data
@Table(name = "NRS")
public class NodeRecord {

    @Column(name = "uuid")
    @Id
    private UUID uuid;

    @Column(name = "ip-adress")
    private String ipAdress;

    @Column(name = "is-active")
    boolean isActive;

    /**
     * Constructor for creating a NodeRecord with a specified UUID, IP address, and activation status.
     *
     * @param uuid      The unique identifier (UUID) of the node.
     * @param ipAdress  The IP address of the node.
     * @param isActive  The activation status of the node.
     */
    public NodeRecord(UUID uuid, String ipAdress , boolean isActive){
        this.ipAdress = ipAdress;
        this.uuid = uuid;
        this.isActive = isActive;
    }

    /**
     * Default constructor for creating a NodeRecord with default values.
     */
    public NodeRecord(){
        this.uuid = null;
        this.ipAdress =null;
        this.isActive = false;
    }
}

