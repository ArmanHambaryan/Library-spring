package am.itspace.libraryspring.service;

import am.itspace.libraryspring.model.User;

import java.util.Optional;

public interface UserService {
    void save(User user);
    Optional<User> findByUsername(String username);

}
