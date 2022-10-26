package com.sparta.trainingdatabase.model.repository;

import com.sparta.trainingdatabase.model.entity.inspection.Inspection;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InspectionRepository extends MongoRepository<Inspection, String> {
}
