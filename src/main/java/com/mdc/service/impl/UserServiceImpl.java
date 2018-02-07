package com.mdc.service.impl;

import com.mdc.model.PermissionModel;
import com.mdc.model.RoleModel;
import com.mdc.model.UserModel;
import com.mdc.security.CustomUserPrincipal;
import com.mdc.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final Map<String, UserModel> users;

    public UserServiceImpl() {
        users = new HashMap<>();
        users.put("admin",getUser1());
        users.put("user",getUser2());
        users.put("manager",getUser3());
    }

    @Override
    public CustomUserPrincipal getUserByName(String userName) {
        UserModel user = users.get(userName);
        if (user != null) {
            return new CustomUserPrincipal(user);
        }
        return null;
    }

    private UserModel getUser1() {
        PermissionModel permission1 = new PermissionModel();
        permission1.setName("read");

        PermissionModel permission2 = new PermissionModel();
        permission2.setName("write");

        PermissionModel permission3 = new PermissionModel();
        permission2.setName("delete");

        Set<PermissionModel> rolePermissions = new HashSet<>();
        rolePermissions.add(permission1);
        rolePermissions.add(permission2);
        rolePermissions.add(permission3);

        RoleModel role = new RoleModel();
        role.setName("ADMIN");
        role.setPermissions(rolePermissions);


        UserModel user = new UserModel();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("admin@admin.ro");

        Set<RoleModel> userRoles = new HashSet<>();
        userRoles.add(role);

        user.setRoles(userRoles);
        return user;
    }

    private UserModel getUser2() {
        PermissionModel permission1 = new PermissionModel();
        permission1.setName("read");

        Set<PermissionModel> rolePermissions = new HashSet<>();
        rolePermissions.add(permission1);

        RoleModel role = new RoleModel();
        role.setName("USER");
        role.setPermissions(rolePermissions);

        UserModel user = new UserModel();
        user.setUsername("user");
        user.setPassword("user");
        user.setEmail("user@user.ro");

        Set<RoleModel> userRoles = new HashSet<>();
        userRoles.add(role);

        user.setRoles(userRoles);
        return user;
    }

    private UserModel getUser3() {
        PermissionModel permission1 = new PermissionModel();
        permission1.setName("read");

        PermissionModel permission2 = new PermissionModel();
        permission2.setName("write");

        Set<PermissionModel> rolePermissions = new HashSet<>();
        rolePermissions.add(permission1);
        rolePermissions.add(permission2);

        RoleModel role = new RoleModel();
        role.setName("MANAGER");
        role.setPermissions(rolePermissions);


        UserModel user = new UserModel();
        user.setUsername("manager");
        user.setPassword("manager");
        user.setEmail("manager@manager.ro");

        Set<RoleModel> userRoles = new HashSet<>();
        userRoles.add(role);

        user.setRoles(userRoles);
        return user;
    }


}
