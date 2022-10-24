package com.sparta.trainingdatabase.model.entity.company;

import lombok.Data;

import java.util.List;

@Data
public class Image {
    public List<Integer> sizes;
    public String url;

    public Image(List<Integer> sizes, String url) {
        this.sizes = sizes;
        this.url = url;
    }

    public List<Integer> getSizes() {
        return sizes;
    }

    public void setSizes(List<Integer> sizes) {
        this.sizes = sizes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
