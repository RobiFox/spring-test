package me.robi.springtest;

import me.robi.springtest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "repositoryHolder")
public class RepositoryHolder {
    @Autowired
    public UserRepository users;
}
