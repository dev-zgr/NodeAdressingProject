package com.example.nodeadressingproject.DataLayer.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.w3c.dom.Node;

import java.util.UUID;

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

    public NodeRecord(UUID uuid, String ipAdress , boolean isActive){
        this.ipAdress = ipAdress;
        this.uuid = uuid;
        this.isActive = isActive;
    }

    public NodeRecord(){
        this.uuid = null;
        this.ipAdress =null;
        this.isActive = false;
    }
}

