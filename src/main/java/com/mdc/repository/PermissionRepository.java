package com.mdc.repository;

import com.mdc.model.PermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionModel,Long> {
    PermissionModel findByName(String name);
}
