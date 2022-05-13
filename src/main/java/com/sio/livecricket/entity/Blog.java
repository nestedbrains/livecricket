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
@AllArgsConstructor
@Entity
@Table(name = "blogs")
public class Blog extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String description;

    private String guid;

}
