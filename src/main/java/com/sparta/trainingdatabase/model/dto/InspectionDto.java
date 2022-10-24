package com.sparta.trainingdatabase.model.dto;

import com.sparta.trainingdatabase.model.entity.inspection.Address;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class InspectionDto {
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

    public InspectionDto(String id, String secondId, String certificateNumber, String businessName, String date, String result, String sector, Address address) {
        this.id = id;
        this.secondId = secondId;
        this.certificateNumber = certificateNumber;
        this.businessName = businessName;
        this.date = date;
        this.result = result;
        this.sector = sector;
        this.address = address;
    }

    public InspectionDto(String secondId, String certificateNumber, String businessName, String date, String result, String sector, Address address) {
        this.secondId = secondId;
        this.certificateNumber = certificateNumber;
        this.businessName = businessName;
        this.date = date;
        this.result = result;
        this.sector = sector;
        this.address = address;
    }

    public InspectionDto() {
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
