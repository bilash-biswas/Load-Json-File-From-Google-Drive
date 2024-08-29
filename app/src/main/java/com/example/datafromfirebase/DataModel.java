package com.example.datafromfirebase;

public class DataModel {
    private String name;
    private String language;
    private String id;
    private String bio;
    private String version;

    public DataModel(String name, String language, String id, String bio, String version) {
        this.name = name;
        this.language = language;
        this.id = id;
        this.bio = bio;
        this.version = version;
    }

    public DataModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
