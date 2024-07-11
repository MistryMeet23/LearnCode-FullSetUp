package com.example.learncode.Model;

public class LanModel2 {

    String id;
    String lan_id;
    String title;
    String link;

    public LanModel2(String id, String lan_id, String title, String link) {
        this.id = id;
        this.lan_id = lan_id;
        this.title = title;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLan_id() {
        return lan_id;
    }

    public void setLan_id(String lan_id) {
        this.lan_id = lan_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
