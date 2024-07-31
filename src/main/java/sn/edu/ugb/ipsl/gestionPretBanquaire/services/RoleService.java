package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Role;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Role not found for id :: " + id);
        }
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role roleDetails) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found for id :: " + id));

        role.setRoleName(roleDetails.getRoleName());

        return roleRepository.save(role);
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}
