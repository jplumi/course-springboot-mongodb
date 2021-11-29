package com.course.workshopmongo.repository;

import com.course.workshopmongo.domain.Post;
import com.course.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
