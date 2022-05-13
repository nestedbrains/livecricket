package com.sio.livecricket.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blog extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String description;

    private String guid;

}
