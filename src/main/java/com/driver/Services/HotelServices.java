package com.driver.Services;

import com.driver.Repository.HotelRepository;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServices {
//    @Autowired
//    HotelRepository hotObj;
HotelRepository hotObj =new HotelRepository();
    public String addHotel(Hotel hotel){
        try{
            if(hotel==null || hotel.getHotelName().equals("") || hotel.getHotelName()==null)return "FAILURE";
            else if(hotObj.hasHotel(hotel)) return "FAILURE";
            else{
                hotObj.addHotel(hotel);
                return "SUCCESS";
            }
        }
        catch(NullPointerException e){
            return "FAILURE";
        }
    }
    public String checkFacilities(){
        //HotelRepository hotObj =new HotelRepository();
        return hotObj.checkFacilities();
    }
    public Hotel updateFacility(List<Facility> facility, String name){
        //HotelRepository hotObj =new HotelRepository();
        if(name.equals(""))return null;
        return hotObj.updateFacility(facility,name);
    }
}
