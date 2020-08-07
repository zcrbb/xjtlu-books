package com.xjtlubooks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xjtlubooks.api.dao.CommitDAO;
import com.xjtlubooks.api.entity.Commit;

@RestController
@RequestMapping("/commit")
@CrossOrigin(allowedHeaders = "*")
public class CommitController {

    @Autowired
    private CommitDAO commitDAO;

    @GetMapping("/find/{page}/{size}")
    public Page<Commit> findAllByLikeNumber(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "likeNumber"));
        return commitDAO.findByOrderByLikeNumberDesc(size, pageable);
    }

    @GetMapping("/")
    public List<Commit> findAll() {
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

    @GetMapping("/like/{id}")
    public String likeCommit(@PathVariable("id") String id) throws JsonProcessingException {
        Commit commitUpDate = commitDAO.findById(id).get();
        int like = commitUpDate.getLikeNumber();
        like++;
        commitUpDate.setLikeNumber(like);
        commitDAO.save(commitUpDate);
        return "{\"likeNumber:\" " + like + "}";
    }
}
