package com.example.hireflow.service.impl;

import com.example.hireflow.dto.user.UserCreateRequest;
import com.example.hireflow.dto.user.UserResponse;
import com.example.hireflow.dto.user.UserUpdateRequest;
import com.example.hireflow.entity.User;
import com.example.hireflow.entity.type.AccountStatus;
import com.example.hireflow.mapper.UserMapper;
import com.example.hireflow.repository.UserRepository;
import com.example.hireflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserCreateRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("User already exists with email: " + request.email());
        }

        User user = userMapper.toEntity(request);

        user.setAccountStatus(AccountStatus.ACTIVE);
        user.setEmailVerified(false);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id)
                );

        return userMapper.toResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userMapper.updateEntity(user, request);

        User updatedUser = userRepository.save(user);

        return userMapper.toResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }
}