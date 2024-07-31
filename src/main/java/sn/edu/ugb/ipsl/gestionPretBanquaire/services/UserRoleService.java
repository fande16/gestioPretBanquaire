package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.UserRole;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.UserRoleRepository;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public void deleteUserRole(Long userId, Long roleId) {
        userRoleRepository.deleteById(userId);
    }
}
