package me.robi.springtest.repositories;

import me.robi.springtest.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
    UserEntity findByNameIgnoreCase(String name);
    long findById(long id);
}
