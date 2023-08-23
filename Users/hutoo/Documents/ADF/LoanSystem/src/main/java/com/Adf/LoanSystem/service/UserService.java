package com.Adf.LoanSystem.service;

import com.Adf.LoanSystem.dto.UserDto;
import com.Adf.LoanSystem.model.User;

public interface UserService {

    User findByNid(Integer nid);
    User save(UserDto userDto);
    //void signU1pUser(User user);
    // Define other methods for user-related operations
}
