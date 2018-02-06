package com.mdc.model;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_profiles")
public class UserProfileModel {
    @Id
    @GeneratedValue
    @Column(name = "user_profile_id")
    private Long upid;

    @Column(name = "user_id",nullable = false)
    private Long uid;

    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
