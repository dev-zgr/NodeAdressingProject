package com.example.nodeadressingproject.Controllers;

import com.example.nodeadressingproject.DataLayer.Entities.NodeRecord;
import com.example.nodeadressingproject.Services.NodeRecordSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/node-service")
public class NodeRecordController {

    @Autowired
    private NodeRecordSystemService nodeRecordSystemService;

    @GetMapping("/get-nodes")
    public List<NodeRecord> getAllNodes(){
        return nodeRecordSystemService.getAllRecords();
    }

    @PostMapping(value = "/register-nodes", consumes = "application/json")
    public ResponseEntity<String> registerNodes(@RequestBody NodeRecord nodeRecord){
        boolean status =  nodeRecordSystemService.registerNode(nodeRecord);
        return new ResponseEntity<String>("true", HttpStatus.OK);
    }

    @PostMapping(value = "/updateNode", consumes = "application/json")
    public ResponseEntity<String> updateNodes(@RequestBody NodeRecord nodeRecord){
        boolean status =  nodeRecordSystemService.registerNode(nodeRecord);
        return new ResponseEntity<String>("true", HttpStatus.OK);
    }



}
