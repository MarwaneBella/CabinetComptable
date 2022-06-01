package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.*;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.PagePermissionRepository;
import com.example.cabinetcomptable.repositories.RoleRepository;
import com.example.cabinetcomptable.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PagePermissionRepository pagePermissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static User currentUser  =null;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        Set<PagePermission> ListPagePermissions = new HashSet<>();
        String[] permissions = {"Dashboard","User","Fournisseur","Produit","Categorie", "BonAchat", "BonHonoraire","ReglementFournisseur","ReglementUser","Facture"};

        for(int i=0;i<permissions.length;i++){
            PagePermission pagePermission = new PagePermission();
            pagePermission.setNamePermission(permissions[i]);
            ListPagePermissions.add(pagePermission);

        }
        pagePermissionRepository.saveAll(ListPagePermissions);




        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("123456"));


        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setPagePermissions(ListPagePermissions);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);
        /// user
        User user = new User();
        user.setUserName("marwane");
        user.setUserPassword(getEncodedPassword("1234"));

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);


        Set<PagePermission> pagePermissions = new HashSet<>();
        PagePermission pagePermission = new PagePermission();
        pagePermission.setNamePermission("Dashboard");
        pagePermissions.add(pagePermission);

        user.setPagePermissions(pagePermissions);
        user.setRole(userRoles);
        userRepository.save(user);
    }

    public User addUser(User user) {
        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepository.save(user);
    }
    
    
    
    public User getUser(String id) {
        currentUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return currentUser;
    }

    
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    
    public User updateUser(String id, User user ) {
        currentUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        user.setUserName(id);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        currentUser = userRepository.save(user);
        return currentUser;
    }


    
    public void deleteUser(String id) {
        currentUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        userRepository.deleteById(id);
    }
     
    

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
