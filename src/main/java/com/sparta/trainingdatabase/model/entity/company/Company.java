package com.sparta.trainingdatabase.model.entity.company;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "companies")
public class Company {

    @MongoId
    public String id;
    public String name;
    public String permalink;
    public String crunchbaseUrl;
    public String homepage;
    public String blogUrl;
    public String blogFeedUrl;
    public String twitterUsername;
    public String categoryCode;
    public int numberOfEmployees;
    public int foundedYear;
    public int foundedMonth;
    public int foundedDay;
    public int deadpooledYear;
    public String tagList;
    public String aliasList;
    public String email;
    public String phone;
    public String description;
    public Instant createdAt;
    public String updatedAt;
    public String overview;
    public List<Image> image;
    public List<Product> products;
    public List<Relationship> relationships;


}
