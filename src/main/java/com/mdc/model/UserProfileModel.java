package com.mdc.model;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users_profiles")
public class UserProfileModel implements Serializable {

    private static final long serialVersionUID = 8516524663309069688L;

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

    public Long getUpid() {
        return upid;
    }

    public UserProfileModel setUpid(Long upid) {
        this.upid = upid;
        return this;
    }

    public Long getUid() {
        return uid;
    }

    public UserProfileModel setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserProfileModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserProfileModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileModel that = (UserProfileModel) o;
        return Objects.equals(upid, that.upid) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(upid, uid, firstName, lastName);
    }
}
