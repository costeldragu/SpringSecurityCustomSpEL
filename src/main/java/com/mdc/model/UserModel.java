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
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel {

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
    @JoinTable(name ="users_profiles" , joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"))
    private UserProfileModel userProfileModel;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles" , joinColumns = @JoinColumn(name = "user_id" ,referencedColumnName = "user_id"))
    private Set<RoleModel> roles;


}
