package com.app.two.Service;

import com.app.two.Users.Role;
import com.app.two.Users.Users;
import com.app.two.Users.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Users getUser(String username);
    List<Users>getUsers();
}
