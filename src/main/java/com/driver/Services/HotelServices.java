package com.driver.Services;

import com.driver.Repository.HotelRepository;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServices {
    @Autowired
    HotelRepository hotObj;
    public String addHotel(Hotel hotel){
        if(hotel==null || hotel.getHotelName()==null)return "FAILURE";
        else if(hotObj.hasHotel(hotel)) return "Failure";
        else{
            hotObj.addHotel(hotel);
            return "SUCCESS";
        }
    }
    public String checkFacilities(){
        return hotObj.checkFacilities();
    }
    public List<Facility> updateFacility(List<Facility> facility, String name){
        return hotObj.updateFacility(facility,name);
    }
}
