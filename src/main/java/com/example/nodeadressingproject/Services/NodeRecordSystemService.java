package com.example.nodeadressingproject.Services;

import com.example.nodeadressingproject.DataLayer.Entities.NodeRecord;
import com.example.nodeadressingproject.DataLayer.Repositories.NodeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service class for managing node records in the blockchain.
 * It provides methods for retrieving, registering, and updating node records.
 */
@Service
public class NodeRecordSystemService {

    @Autowired
    private NodeRecordRepository recordRepository;

    /**
     * Constructor for creating an instance of NodeRecordSystemService with a NodeRecordRepository.
     *
     * @param recordRepository The repository for accessing and managing node records.
     */
    public NodeRecordSystemService(NodeRecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }

    /**
     * Retrieves all node records from the repository.
     *
     * @return A list of all node records in the blockchain.
     */
    public List<NodeRecord> getAllRecords(){
        return  recordRepository.findAll();
    }

    /**
     * Registers a new node record in the blockchain.
     *
     * @param nodeRecord The node record to be registered.
     * @return True if the registration is successful, false otherwise.
     */
    public boolean registerNode(NodeRecord nodeRecord) {
        try {
            recordRepository.save(nodeRecord);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Updates the activation status of an existing node record in the blockchain.
     *
     * @param nodeRecord The updated node record with a new activation status.
     * @return True if the update is successful, false otherwise.
     */
    public boolean updateNode(NodeRecord nodeRecord) {
        try {
            var node = recordRepository.findById(nodeRecord.getUuid()).get();
            node.setActive(nodeRecord.isActive());
            recordRepository.save(node);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public byte[] getPublicKeyByUUID(UUID uuid){
        try{
            var node = recordRepository.findById(uuid);
            return node.get().getPublicKey();
        }catch (Exception e){
            return null;
        }
    }



}
