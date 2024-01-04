package com.example.nodeadressingproject.DataLayer.Repositories;

import com.example.nodeadressingproject.DataLayer.Entities.NodeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.Node;

import java.util.UUID;

/**
 * JPA Repository for handling database operations of NodeRecord.
 */
public interface NodeRecordRepository extends JpaRepository<NodeRecord, UUID> {

}
