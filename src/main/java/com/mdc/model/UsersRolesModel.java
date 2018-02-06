package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="users_roles")
@IdClass(UsersRolesModel.class)
public class UsersRolesModel {

    @Column
    @Id
    private Long uid;

    @Column
    @Id
    private Long rid;
}
