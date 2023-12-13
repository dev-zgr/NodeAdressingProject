package com.example.nodeadressingproject.DataLayer.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.engine.jdbc.env.internal.LobTypes;
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

    @Lob
    @Column(name="public_key", columnDefinition="BLOB")
    private byte[] publicKey;


    public NodeRecord(UUID uuid, String ipAdress , boolean isActive , byte[] publicKey){
        this.ipAdress = ipAdress;
        this.uuid = uuid;
        this.isActive = isActive;
        this.publicKey = publicKey;
    }

    public NodeRecord(){
        this.uuid = null;
        this.ipAdress =null;
        this.isActive = false;
        publicKey = new byte[2048];
    }
}

