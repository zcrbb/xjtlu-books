package com.xjtlubooks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.xjtlubooks.api.dao.CommitDAO;
import com.xjtlubooks.api.entity.Commit;

@RestController
@RequestMapping("/commit")
@CrossOrigin
public class CommitController {

    @Autowired
    private CommitDAO commitDAO;

    @GetMapping("/find/{page}/{size}")
    public Page<Commit> findAllByLikeNumber(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"likeNumber"));
        return commitDAO.findByOrderByLikeNumberDesc(size, pageable);
    }
    
    @GetMapping("/")
    public List<Commit> findAll(){
        return commitDAO.findAll();
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody Commit commit) {
        commitDAO.save(commit);
        return Boolean.TRUE;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteComm(@PathVariable("id") String id) {
        commitDAO.deleteById(id);
        return Boolean.TRUE;
    }

    @PutMapping("/like")
    public Boolean likeCommit(@RequestBody Commit commit) {
        commitDAO.save(commit);
        return Boolean.TRUE;
    }
}
