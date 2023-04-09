package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.userDTO;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public void save(userDTO req) {
        repository.save(new User(req));
    }

    public void update(Long id, userDTO req) {
      repository.findById(id).map(user -> {
        user.setUsername(req.username());
        user.setAvatar(req.avatar());
        return repository.save(user);
      });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
