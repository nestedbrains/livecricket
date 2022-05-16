package com.sio.livecricket.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreatedBy
    @Column(name = "logged_user")
    private User user;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant updatedDate;

}
