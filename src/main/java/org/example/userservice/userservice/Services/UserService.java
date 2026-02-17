package org.example.userservice.userservice.Services;

import org.example.userservice.userservice.Entity.User;
import org.example.userservice.userservice.Modules.UserName;
import org.example.userservice.userservice.Modules.UserRequest;
import org.example.userservice.userservice.Modules.UserResponse;
import org.example.userservice.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(UserRequest userRequest) {
        User user = new User(userRequest.name(),userRequest.email());
        return userRepository.save(user);
    }

    public User createName(UserName userName) {
        User user = new User(userName.Name());
        return userRepository.save(user);
    }

    public UserResponse getUserById(Long id) {
        User user =null;
        Optional<User> data =userRepository.findById(id);
        if(data.isPresent()) {
            user=data.get();
        }
        UserResponse userResponse=new UserResponse(user.getId(),user.getName(),user.getEmail());
        return userResponse;
    }
}
