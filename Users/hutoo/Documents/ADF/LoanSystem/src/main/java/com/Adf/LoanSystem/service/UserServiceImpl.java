package com.Adf.LoanSystem.service;

import com.Adf.LoanSystem.dto.UserDto;
import com.Adf.LoanSystem.model.User;
import com.Adf.LoanSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByNid(Integer nid) {
        return userRepository.findByNid(nid);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getNid(), userDto.getFname(), userDto.getLname(), userDto.getPhone(), passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }



    // Implement other methods for user-related operations
}
