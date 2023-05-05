package com.driver.Repository;

import com.driver.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class BookingRepository {
    @Autowired
            HotelRepository hotObj;
    HashMap<String,Booking> hm=new HashMap<>();
    public int bookRoom(Booking booking){
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setAmountToBePaid(booking.getNoOfRooms()*hotObj.getPrice(booking.getHotelName()));
        hm.put(booking.getBookingId(),booking);
        return booking.getAmountToBePaid();
    }
    public int numberOfBookings(int aadhar){
        int count=0;
        for(String x: hm.keySet()){
            if(hm.get(x).getBookingAadharCard()==aadhar)count++;
        }
        return count;
    }
}
