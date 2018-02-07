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
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleModel implements Serializable {

    private static final long serialVersionUID = -678459308073021475L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long rid;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "roles_id"))
    private Set<PermissionModel> permissions;

    public long getRid() {
        return rid;
    }

    public RoleModel setRid(long rid) {
        this.rid = rid;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<PermissionModel> getPermissions() {
        return permissions;
    }

    public RoleModel setPermissions(Set<PermissionModel> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel roleModel = (RoleModel) o;
        return rid == roleModel.rid &&
                Objects.equals(name, roleModel.name) &&
                Objects.equals(permissions, roleModel.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, name, permissions);
    }
}
