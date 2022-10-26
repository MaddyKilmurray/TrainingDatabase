package com.sparta.trainingdatabase.model.repository;

import com.sparta.trainingdatabase.model.entity.company.Company;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
