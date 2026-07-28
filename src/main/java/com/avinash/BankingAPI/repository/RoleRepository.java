package com.avinash.BankingAPI.repository;

import com.avinash.BankingAPI.entity.Role;
import com.avinash.BankingAPI.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> FindByRoleName(RoleName roleName);
}
