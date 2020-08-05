package com.xjtlubooks.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommitController {

    @Autowired
    private CommitDAO commitDAO;

    @GetMapping("/list")
    public List<Commit> findAll(){
        return commitDAO.findAll();
    }
    @PostMapping("/save")
    public Boolean save(@RequestBody Commit commit){
        commitDAO.save(commit);
        return Boolean.TRUE;
    }
    @PutMapping("update")
    public Boolean updateComm(@RequestBody Commit commit){
        commitDAO.save(commit);
        return Boolean.TRUE;
    }
    @GetMapping("/find/{id}")
    public Commit findById(@PathVariable("id") String id){
        return commitDAO.findById(id).get();
    }
}
