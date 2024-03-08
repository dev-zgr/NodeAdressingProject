package com.example.nodeadressingproject.Controllers;

import com.example.nodeadressingproject.DataLayer.Entities.NodeRecord;
import com.example.nodeadressingproject.Services.NodeRecordSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the REST Controller for the nodes in the blockchain.
 * It handles the HTTP requests and responses for the nodes.
 */
@RestController
@RequestMapping("/node-service")
public class NodeRecordController {

    @Autowired
    private NodeRecordSystemService nodeRecordSystemService;

    /**
     * Handles the HTTP GET request to retrieve all nodes (/get-nodes endpoint).
     *
     * @return List of all node records.
     */
    @GetMapping("/get-nodes")
    public List<NodeRecord> getAllNodes(){
        return nodeRecordSystemService.getAllRecords();
    }

    /**
     * Handles the HTTP POST request to register nodes (/register-nodes endpoint).
     *
     * @param nodeRecord The node record to be registered.
     * @return ResponseEntity indicating the registration status.
     */
    @PostMapping(value = "/register-nodes")
    public ResponseEntity<String> registerNodes(@RequestBody NodeRecord nodeRecord){
        boolean status =  nodeRecordSystemService.registerNode(nodeRecord);
        return new ResponseEntity<String>("true", HttpStatus.OK);
    }

    /**
     * Handles the HTTP POST request to update nodes (/updateNode endpoint).
     *
     * @param nodeRecord The node record to be updated.
     * @return ResponseEntity indicating the update status.
     */
    @PostMapping(value = "/updateNode", consumes = "application/json")
    public ResponseEntity<String> updateNodes(@RequestBody NodeRecord nodeRecord){
        boolean status =  nodeRecordSystemService.updateNode(nodeRecord);
        return new ResponseEntity<String>("true", HttpStatus.OK);
    }



}
