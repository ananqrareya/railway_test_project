package com.Auth.Authorize.servicse;

import com.Auth.Authorize.Dto.UserDTO;
import com.Auth.Authorize.Repo.UserRepo;
import com.Auth.Authorize.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void registerUser(UserDTO userDTO) {
        User user=new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setGender(userDTO.getGender());
        userRepo.save(user);
    }


    public List<User> getAllUser() {
        List<User>users=userRepo.findAll();
        return users;
    }
}
