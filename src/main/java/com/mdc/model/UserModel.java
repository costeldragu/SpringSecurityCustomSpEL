package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {

    private static final long serialVersionUID = -5756158262889239105L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long uid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "users_profiles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private UserProfileModel userProfileModel;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private Set<RoleModel> roles;

    public Long getUid() {
        return uid;
    }

    public UserModel setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserProfileModel getUserProfileModel() {
        return userProfileModel;
    }

    public UserModel setUserProfileModel(UserProfileModel userProfileModel) {
        this.userProfileModel = userProfileModel;
        return this;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public UserModel setRoles(Set<RoleModel> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(uid, userModel.uid) &&
                Objects.equals(username, userModel.username) &&
                Objects.equals(password, userModel.password) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(userProfileModel, userModel.userProfileModel) &&
                Objects.equals(roles, userModel.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, password, email, userProfileModel, roles);
    }
}
