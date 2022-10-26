package com.sparta.trainingdatabase.model.entity.company;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "companies")
public class Company {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String permalink;
    @Field("crunchbase_url")
    private String crunchbaseUrl;
    @Field("homepage_url")
    private String homepage;
    @Field("blog_url")
    private String blogUrl;
    @Field("blog_feed_url")
    private String blogFeedUrl;
    @Field("twitter_username")
    private String twitterUsername;
    @Field("category_code")
    private String categoryCode;
    @Field("number_of_employees")
    private int numberOfEmployees;
    @Field("founded_year")
    private int foundedYear;
    @Field("founded_month")
    private int foundedMonth;
    @Field("founded_day")
    private int foundedDay;
    @Field("deadpooled_year")
    private int deadpooledYear;
    @Field("tag_list")
    private String tagList;
    @Field("alias_list")
    private String aliasList;
    @Field("email_address")
    private String email;
    @Field("phone_number")
    private String phone;
    private String description;
    @Field("created_at")
    private String createdAt;
    @Field("updated_at")
    private String updatedAt;
    private String overview;

    public Company(String id, String name, String permalink, String crunchbaseUrl, String homepage, String blogUrl, String blogFeedUrl, String twitterUsername, String categoryCode, int numberOfEmployees, int foundedYear, int foundedMonth, int foundedDay, int deadpooledYear, String tagList, String aliasList, String email, String phone, String description, String createdAt, String updatedAt, String overview) {
        this.id = id;
        this.name = name;
        this.permalink = permalink;
        this.crunchbaseUrl = crunchbaseUrl;
        this.homepage = homepage;
        this.blogUrl = blogUrl;
        this.blogFeedUrl = blogFeedUrl;
        this.twitterUsername = twitterUsername;
        this.categoryCode = categoryCode;
        this.numberOfEmployees = numberOfEmployees;
        this.foundedYear = foundedYear;
        this.foundedMonth = foundedMonth;
        this.foundedDay = foundedDay;
        this.deadpooledYear = deadpooledYear;
        this.tagList = tagList;
        this.aliasList = aliasList;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.overview = overview;
    }

    public Company() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getCrunchbaseUrl() {
        return crunchbaseUrl;
    }

    public void setCrunchbaseUrl(String crunchbaseUrl) {
        this.crunchbaseUrl = crunchbaseUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getBlogFeedUrl() {
        return blogFeedUrl;
    }

    public void setBlogFeedUrl(String blogFeedUrl) {
        this.blogFeedUrl = blogFeedUrl;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public int getFoundedMonth() {
        return foundedMonth;
    }

    public void setFoundedMonth(int foundedMonth) {
        this.foundedMonth = foundedMonth;
    }

    public int getFoundedDay() {
        return foundedDay;
    }

    public void setFoundedDay(int foundedDay) {
        this.foundedDay = foundedDay;
    }

    public int getDeadpooledYear() {
        return deadpooledYear;
    }

    public void setDeadpooledYear(int deadpooledYear) {
        this.deadpooledYear = deadpooledYear;
    }

    public String getTagList() {
        return tagList;
    }

    public void setTagList(String tagList) {
        this.tagList = tagList;
    }

    public String getAliasList() {
        return aliasList;
    }

    public void setAliasList(String aliasList) {
        this.aliasList = aliasList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
