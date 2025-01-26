package com.sprk.sprk_hotels.repository;

import com.sprk.sprk_hotels.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
    Optional<RoleModel> findByName(String name);
}
