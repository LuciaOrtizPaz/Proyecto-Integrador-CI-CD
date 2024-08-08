package com.api.school.service;

import com.api.school.User;
import com.api.school.dto.UserDto;
import com.api.school.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServ {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getById(String id) {
        User user = userRepository.findById(id).orElse(null);
        return convertToDto(user);
    }

    @Override
    public UserDto save(UserDto userDto) {
        validateUserDto(userDto);
        User user = convertToEntity(userDto);
        user = userRepository.save(user);
        return convertToDto(user);
    }

    @Override
    public UserDto update(UserDto userDto, String id) {
        validateUserDto(userDto);
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            updateUserDetails(existingUser, userDto);
            User updatedUser = userRepository.save(existingUser);
            return convertToDto(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public UserDto getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(this::convertToDto).orElse(null);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    private void validateUserDto(UserDto userDto) {
        if (userDto == null || userDto.getName() == null || userDto.getEmail() == null) {
            throw new IllegalArgumentException("User name and email cannot be null");
        }
    }

    private void updateUserDetails(User existingUser, UserDto userDto) {
        existingUser.setName(userDto.getName());
        existingUser.setAge(userDto.getAge());
        existingUser.setTell(userDto.getTell());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setRole(userDto.getRole());
        // Assuming there is a method to set updatedAt
    }

    private User convertToEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getAge(),
                userDto.getTell(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRole()
        );
    }

    private UserDto convertToDto(User user) {
        if (user == null) return null;
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getTell(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }
}

