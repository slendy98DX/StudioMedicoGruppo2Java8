package co.develhope.StudioMedicoGruppo2Java8.repositories;

import co.develhope.StudioMedicoGruppo2Java8.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
