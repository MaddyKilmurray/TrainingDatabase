package com.sparta.trainingdatabase.model.entity.company;

import lombok.Data;

@Data
public class Product {
    public String name;
    public String permalink;

    public Product(String name, String permalink) {
        this.name = name;
        this.permalink = permalink;
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
}
