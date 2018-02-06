package com.mdc.web.controller;

import com.mdc.model.PermissionModel;
import com.mdc.model.RoleModel;
import com.mdc.model.UserModel;
import com.mdc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;




    @GetMapping("/")
    public String indexPage() {


        PermissionModel permission1 = new PermissionModel();
        permission1.setName("read");

        PermissionModel permission2 = new PermissionModel();
        permission2.setName("write");

        Set<PermissionModel> rolePermissions = new HashSet<>();
        rolePermissions.add(permission1);
        rolePermissions.add(permission2);

        RoleModel role = new RoleModel();
        role.setName("admin");
        role.setPermissions(rolePermissions);



        UserModel user = new UserModel();
        user.setUsername("test");
        user.setPassword("test");
        user.setEmail("test@test.ro");

        Set<RoleModel> userRoles = new HashSet<>();
        userRoles.add(role);

        user.setRoles(userRoles);



        userRepository.save(user);


        return "index";
    }
}
