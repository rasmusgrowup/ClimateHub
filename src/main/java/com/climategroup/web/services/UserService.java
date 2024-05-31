package com.climategroup.web.services;

import com.climategroup.web.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto user);
    Optional<UserDto> getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto userDetails);
    void deleteUser(Long id);
}
