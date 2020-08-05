package com.xjtlubooks.api;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "commit", path="commits")
public interface Comm itDAO extends MongoRepository<Commit,String> {
}
