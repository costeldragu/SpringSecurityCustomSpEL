package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "roles_permissions")
@IdClass(RolesPermissionsModel.class)
public class RolesPermissionsModel {

    @Id
    @Column(name = "permission_id", nullable = false)
    private Long pid;

    @Id
    @Column(name = "role_id", nullable = false)
    private Long rid;
}
