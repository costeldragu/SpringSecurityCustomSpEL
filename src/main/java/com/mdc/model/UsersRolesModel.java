package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users_roles")
@IdClass(UsersRolesModel.class)
public class UsersRolesModel implements Serializable {

    private static final long serialVersionUID = -2424576796443428026L;

    @Column(name = "user_id")
    @Id
    private Long uid;

    @Column(name = "role_id")
    @Id
    private Long rid;

    public Long getUid() {
        return uid;
    }

    public UsersRolesModel setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    public Long getRid() {
        return rid;
    }

    public UsersRolesModel setRid(Long rid) {
        this.rid = rid;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRolesModel that = (UsersRolesModel) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(rid, that.rid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, rid);
    }
}
