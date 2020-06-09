package com.powersi.material.pojo;

public class Repo {
    private String id;

    private String repoName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName == null ? null : repoName.trim();
    }
}