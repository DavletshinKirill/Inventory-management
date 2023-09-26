package com.inventory_management.db.repositories;

import com.inventory_management.db.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends CrudRepository<RolesEntity, Long> {
}
