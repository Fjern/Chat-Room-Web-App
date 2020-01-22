package com.github.fjern.ChatRoom.service;

import com.github.fjern.ChatRoom.model.User;
import com.github.fjern.ChatRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository repository){
        this.userRepository=repository;
    }

    public User addUser(String username, String password) {
        List<User> userList = userRepository.findByUserName(username);
        if(userList.isEmpty()){
            User newUser = new User(username,password);
            userRepository.save(newUser);
            return newUser;
        }
        return null;
    }

    public User verifyUser(String username, String password) {
        List<User> userList = userRepository.findByUserName(username);
        for(User user:userList){
            if(password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
