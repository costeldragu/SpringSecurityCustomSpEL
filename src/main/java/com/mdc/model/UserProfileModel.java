package com.mdc.model;

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
    private Long upid;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
