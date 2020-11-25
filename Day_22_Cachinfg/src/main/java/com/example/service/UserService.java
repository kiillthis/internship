package com.example.service;

import com.example.model.User;

public interface UserService {

    User create(User user);

    User get(Long id);
}
