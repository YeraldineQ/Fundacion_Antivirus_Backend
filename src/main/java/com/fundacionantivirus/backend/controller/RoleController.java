package com.fundacionantivirus.backend.controller;

import com.fundacionantivirus.backend.model.Role;
import com.fundacionantivirus.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @PostMapping()
    public Role createRole (@RequestBody Role role){
        return roleService.createRole(role);
    }

}
