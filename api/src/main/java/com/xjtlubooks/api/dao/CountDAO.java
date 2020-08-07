package com.xjtlubooks.api.dao;

import com.xjtlubooks.api.entity.Count;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountDAO extends MongoRepository<Count, String> {

}