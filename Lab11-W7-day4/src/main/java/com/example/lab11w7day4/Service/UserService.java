package com.example.lab11w7day4.Service;

import com.example.lab11w7day4.Api.ApiException;
import com.example.lab11w7day4.Model.User;
import com.example.lab11w7day4.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user) {
        User updateUser = userRepository.findUserById(id);
        if(updateUser == null) {
            throw new ApiException("user not found");
        }
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
        updateUser.setUsername(user.getUsername());
        userRepository.save(updateUser);
    }
    public void deleteUser(Integer id) {
        User updateUser = userRepository.findUserById(id);
        if(updateUser == null) {
            throw new ApiException("user not found");
        }
        userRepository.delete(updateUser);
    }

    public User getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        if(user == null) {
            throw new ApiException("user not found");
        }
        return user;
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if(user == null) {
            throw new ApiException("user not found");
        }
        return user;
    }

    public List<User> findAllByRegistration_date(LocalDate Registration_date) {
        List<User> users = userRepository.findAllByRegistration_date(Registration_date);
        if (users.isEmpty()) {
            throw new ApiException("user not found");
        }
        return users;
    }
}
