package com.xjtlubooks.api.dao;

import com.xjtlubooks.api.entity.Count;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CountDAO extends MongoRepository<Count, String> {

}