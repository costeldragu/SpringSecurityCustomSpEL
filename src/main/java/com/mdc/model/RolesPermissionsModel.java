package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "roles_permissions")
@IdClass(RolesPermissionsModel.class)
public class RolesPermissionsModel implements Serializable{

    private static final long serialVersionUID = 5957585284022861477L;

    @Id
    @Column(name = "permission_id", nullable = false)
    private Long pid;

    @Id
    @Column(name = "role_id", nullable = false)
    private Long rid;

    public Long getPid() {
        return pid;
    }

    public RolesPermissionsModel setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public Long getRid() {
        return rid;
    }

    public RolesPermissionsModel setRid(Long rid) {
        this.rid = rid;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesPermissionsModel that = (RolesPermissionsModel) o;
        return Objects.equals(pid, that.pid) &&
                Objects.equals(rid, that.rid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pid, rid);
    }
}
