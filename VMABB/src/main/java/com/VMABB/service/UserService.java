package com.VMABB.service;

import com.VMABB.dto.*;
import com.VMABB.model.*;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
