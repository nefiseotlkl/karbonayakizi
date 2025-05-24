package com.carbon.karbonayakizi.service;

import java.util.List;
import com.carbon.karbonayakizi.model.User;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer id);
    User getUserByEmail(String email);
    void deleteUser(Integer id);
}
