package com.app.two;

import com.app.two.Service.UserService;
import com.app.two.Users.Role;
import com.app.two.Users.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {
          userService.saveRole(new Role(null, "ROLE_USER"));
          userService.saveRole(new Role(null, "ROLE_MANAGER"));
          userService.saveRole(new Role(null, "ROLE_ADMIN"));
          userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

          userService.saveUser(new Users(null, "Artur Melnikov", "artur", "1234", new ArrayList<>()));
          userService.saveUser(new Users(null, "Alisa Melnikova", "alisa", "56789", new ArrayList<>()));
          userService.saveUser(new Users(null, "Funduk Funduk", "funduk", "98765", new ArrayList<>()));
          userService.saveUser(new Users(null, "Privet Privet", "privet", "4321", new ArrayList<>()));

          userService.addRoleToUser("artur", "ROLE_SUPER_ADMIN");
          userService.addRoleToUser("alisa", "ROLE_ADMIN");
          userService.addRoleToUser("funduk", "ROLE_USER");
          userService.addRoleToUser("privet", "ROLE_MANAGER");
        };

    }

}
