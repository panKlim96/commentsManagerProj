package com.commentsManager.service;

import com.commentsManager.domain.Role;
import com.commentsManager.domain.User;
import com.commentsManager.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null ){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean addUser(User user){
        //,String name, String surname, String passportData
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null){
            return false;
        }

        user.setActive(true);

        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setPassportData(user.getPassportData());
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return true;
    }


    public void saveUser(String username, String name, String surname,
                         String passportData, User user, Map<String, String> form) {
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setPassportData(passportData);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for(String key : form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }

    public void updateProfile(User user, String username, String password, String name, String surname, String passportData){
//       String curUsername = user.getUsername();
//       boolean isUsernameChanged = (username != null && !username.equals(curUsername)) ||
//                (curUsername != null && !curUsername.equals(username));
//
//       if (isUsernameChanged){
//           user.setUsername(username);
//       }
        if (!StringUtils.isEmpty(username)){
            user.setUsername(username);
        }

        if (!StringUtils.isEmpty(password)){
            user.setPassword(password);
        }
        if (!StringUtils.isEmpty(name)){
            user.setName(name);
        }
        if (!StringUtils.isEmpty(surname)){
            user.setSurname(surname);
        }
        if (!StringUtils.isEmpty(passportData)){
            user.setPassportData(passportData);
        }

        userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}
