package ru.kgogolev.hometask_11.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kgogolev.hometask_11.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
