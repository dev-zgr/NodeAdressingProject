package com.example.nodeadressingproject.Services;

import com.example.nodeadressingproject.DataLayer.Entities.NodeRecord;
import com.example.nodeadressingproject.DataLayer.Repositories.NodeRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeRecordSystemService {

    @Autowired
    private NodeRecordRepository recordRepository;

    public NodeRecordSystemService(NodeRecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }

    public List<NodeRecord> getAllRecords(){
        return  recordRepository.findAll();
    }

    public boolean registerNode(NodeRecord nodeRecord) {
        try {
            recordRepository.save(nodeRecord);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
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

}
