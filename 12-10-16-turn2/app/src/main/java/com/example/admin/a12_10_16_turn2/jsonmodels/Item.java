package com.example.admin.a12_10_16_turn2.jsonmodels;

/**
 * Created by admin on 13/10/2016.
 */

public class Item {
    private String title;
    private String body;
    private String userId;

    public Item(String title, String body, String userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
