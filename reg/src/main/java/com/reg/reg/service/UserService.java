package com.reg.reg.service;

import com.reg.reg.model.User;
import com.reg.reg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User login(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public void deleteUser(long id) {
        
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    public User updateUser(long id, User updatedUser) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                updatedUser.setId(id);
                return userRepository.save(updatedUser);
            }
        } catch (Exception e) {
           
            e.printStackTrace();
        }
        return null;
    }
}
