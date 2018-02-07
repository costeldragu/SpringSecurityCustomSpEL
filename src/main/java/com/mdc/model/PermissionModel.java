package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="permissions")
public class PermissionModel  implements Serializable {

    private static final long serialVersionUID = -7553411066054737499L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id")
    private long pid;

    @Column(nullable = false)
    private String name;

    public long getPid() {
        return pid;
    }

    public PermissionModel setPid(long pid) {
        this.pid = pid;
        return this;
    }

    public String getName() {
        return name;
    }

    public PermissionModel setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionModel that = (PermissionModel) o;
        return pid == that.pid &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, name);
    }
}
