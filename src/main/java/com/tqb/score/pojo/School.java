package com.tqb.score.pojo;

public class School {
    private Integer id;

    private String name;

    private String website;

    private String publickeyUrl;

    private String checkScoreUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getPublickeyUrl() {
        return publickeyUrl;
    }

    public void setPublickeyUrl(String publickeyUrl) {
        this.publickeyUrl = publickeyUrl == null ? null : publickeyUrl.trim();
    }

    public String getCheckScoreUrl() {
        return checkScoreUrl;
    }

    public void setCheckScoreUrl(String checkScoreUrl) {
        this.checkScoreUrl = checkScoreUrl == null ? null : checkScoreUrl.trim();
    }
}