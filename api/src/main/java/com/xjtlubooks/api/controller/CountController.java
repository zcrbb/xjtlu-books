package com.xjtlubooks.api.controller;

import com.xjtlubooks.api.dao.CountDAO;
import com.xjtlubooks.api.entity.Count;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/count")
@CrossOrigin(allowedHeaders = "*")

public class CountController {
    @Autowired
    private CountDAO countDAO;

    @GetMapping("/")
    public String getCount() {
        return "{\"count\": " + countDAO.count() + "}";
    }

    @PostMapping("/add")
    public Boolean changeCount(@RequestBody Count count) {
        countDAO.save(count);
        return Boolean.TRUE;
    }

}