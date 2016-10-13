package com.example.admin.a12_10_16_turn2.jsonmodels;

import java.util.List;

/**
 * Created by admin on 13/10/2016.
 */

public class JsonFlickrFeed {
    private String title;
    private String link;
    private String description;
    private String modified;
    private String generator;
    private List<JsonFlickrItem> items;

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getGenerator() {
        return generator;
    }

    public String getTitle() {
        return title;
    }

    public List<JsonFlickrItem> getItems() {
        return items;
    }
}
