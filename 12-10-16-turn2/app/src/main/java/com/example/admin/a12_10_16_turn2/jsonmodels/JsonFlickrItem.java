package com.example.admin.a12_10_16_turn2.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 13/10/2016.
 */

public class JsonFlickrItem {
    private String title;
    private String link;
    private JsonFlickrMedia  media;
    @SerializedName("date_taken")
    private String dateTaken;
    private String escription;
    private String published;
    private String author;
    private String author_id;
    private String tags;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public JsonFlickrMedia getMedia() {
        return media;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public String getEscription() {
        return escription;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublished() {
        return published;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getTags() {
        return tags;
    }
}
