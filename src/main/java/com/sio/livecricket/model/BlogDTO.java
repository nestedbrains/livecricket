package com.sio.livecricket.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.beans.Transient;


public class BlogDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    private String description;

    private String guid;

    private String imageUrl;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Transient
    public String getPhotosImagePath() {
        if (imageUrl == null || id == null) return null;

        return "/user-photos/" + id + "/" + imageUrl;
    }
}
