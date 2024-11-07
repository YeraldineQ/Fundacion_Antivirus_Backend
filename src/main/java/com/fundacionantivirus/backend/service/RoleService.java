package com.fundacionantivirus.backend.service;


import com.fundacionantivirus.backend.model.Role;
import com.fundacionantivirus.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> roleList () {
        return roleRepository.findAll();
    }
}
