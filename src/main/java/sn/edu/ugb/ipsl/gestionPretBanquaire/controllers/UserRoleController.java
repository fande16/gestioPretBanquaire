package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.UserRole;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        return userRoleService.saveUserRole(userRole);
    }

    @DeleteMapping("/{userId}/{roleId}")
    public void deleteUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
        userRoleService.deleteUserRole(userId, roleId);
    }
}