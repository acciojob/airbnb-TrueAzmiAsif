package com.driver.Services;

import com.driver.Repository.BookingRepository;
import com.driver.Repository.HotelRepository;
import com.driver.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServices {
    @Autowired
    BookingRepository boObj;
    HotelRepository hotObj;
    public int bookRoom(Booking booking){
        int availableRoom=hotObj.getAvail(booking.getHotelName());
        if(booking.getNoOfRooms()>availableRoom)return -1;
        else{
            return boObj.bookRoom(booking);
        }
    }
    public int numberOfBookings(int aadhar){
        return boObj.numberOfBookings(aadhar);
    }
}
