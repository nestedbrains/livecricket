package com.sio.livecricket.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "blogs")
public class Blog extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String description;

    private String guid;

    public Blog(String title, String description, String guid) {
        this.title = title;
        this.description = description;
        this.guid = guid;
    }
}
