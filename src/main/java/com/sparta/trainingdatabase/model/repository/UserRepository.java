package com.sparta.trainingdatabase.model.repository;


import com.sparta.trainingdatabase.model.entity.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{ 'email' : '?0' }")
    Optional<User> findByEmail (String email);
}
