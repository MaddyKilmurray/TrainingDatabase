package com.sparta.trainingdatabase.model.entity.inspection;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "inspections")
public class Inspection {
    @MongoId(FieldType.OBJECT_ID)
    @Field("_id")
    private String id;
    @Field("id")
    private String secondId;
    @Field("certificate_number")
    private String certificateNumber;
    @Field("business_name")
    private String businessName;
    private String date;
    private String result;
    private String sector;
    private Address address;

    public Inspection(String id, String secondId, String certificateNumber, String businessName, String date, String result, String sector, Address address) {
        this.id = id;
        this.secondId = secondId;
        this.certificateNumber = certificateNumber;
        this.businessName = businessName;
        this.date = date;
        this.result = result;
        this.sector = sector;
        this.address = address;
    }

    public Inspection(String secondId, String certificateNumber, String businessName, String date, String result, String sector, Address address) {
        this.secondId = secondId;
        this.certificateNumber = certificateNumber;
        this.businessName = businessName;
        this.date = date;
        this.result = result;
        this.sector = sector;
        this.address = address;
    }

    public Inspection() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
