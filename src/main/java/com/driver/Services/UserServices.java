package com.driver.Services;

import com.driver.Repository.UserRepository;
import com.driver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    UserRepository usObj;
    public int add(User user){
        return usObj.add(user);
    }
}
