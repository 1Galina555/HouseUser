package com.example.houseuser.service;

import com.example.houseuser.model.User;
import com.example.houseuser.repository.UserRepository;
import com.example.houseuser.service.master.MasterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user does not exist "));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        User newUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user does not exist"));
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return new MasterUser(userRepository
                .findById(Long.valueOf(userId))
                .orElseThrow(() -> new UsernameNotFoundException("user does not exist")));
    }
}
