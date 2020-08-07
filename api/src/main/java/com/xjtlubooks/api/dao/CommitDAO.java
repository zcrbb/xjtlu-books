package com.xjtlubooks.api.dao;

import com.xjtlubooks.api.entity.Commit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

// @RepositoryRestResource(collectionResourceRel = "commit", path="commits")
public interface CommitDAO extends MongoRepository<Commit, String> {

    // @Query("{'likeNumber:?0'}")
    // default Page<Commit> findByLikeNumber(String likeNumber, Pageable pageable);
    // @Query("{ 'likeNumber' : ?0 }")
    public Page<Commit> findByOrderByLikeNumberDesc(Integer likeNumber, Pageable pageable);
}
