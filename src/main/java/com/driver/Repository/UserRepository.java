package com.driver.Repository;

import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    HashMap<Integer, User> hm=new HashMap<>();
    public int addus(User user){
        try{
            int aadhar=user.getaadharCardNo();
            hm.put(aadhar,user);
            return aadhar;
        }
        catch(NullPointerException e){
            return -1;
        }

    }
}
