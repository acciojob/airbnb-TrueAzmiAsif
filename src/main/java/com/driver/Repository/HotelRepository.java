package com.driver.Repository;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class HotelRepository {
    HashMap<String, Hotel> hm=new HashMap<>();
    public boolean hasHotel(Hotel hotel){
        return hm.containsKey(hotel.getHotelName());
    }
    public void addHotel(Hotel hotel){
        hm.put(hotel.getHotelName(),hotel);
    }
    public String checkFacilities(){
        int maxfaci=0,count=0,flag=0;
        String ans="";
        for(String x: hm.keySet()){
            int size=hm.get(x).getFacilities().size();
            if(size>maxfaci)maxfaci=size;
        }
        if(maxfaci==0)return "";
        else{
            for(String x: hm.keySet()){
                int size=hm.get(x).getFacilities().size();
                if(size==maxfaci){
                    count++;
                    if(flag==0){
                        ans=x;
                        flag=1;
                    }
                    else{
                        ans=lexsmall(ans,x);
                    }
                }
            }
            return ans;
        }
    }
    public String lexsmall(String ans, String x){
        int length1=ans.length(), length2=x.length();
        int minlen=Math.min(length1,length2);
        for(int i=0;i<minlen;i++){
            if(ans.charAt(i)<x.charAt(i))return ans;
            else if(ans.charAt(i)>x.charAt(i))return x;
        }
        if(length1==minlen)return ans;
        else return x;
    }
    public int getAvail(String name){
        return hm.get(name).getAvailableRooms();
    }
    public int getPrice(String name){
        return hm.get(name).getPricePerNight();
    }
    public Hotel updateFacility(List<Facility> facility, String name){
        for(Facility x: facility){
            if(!hm.get(name).getFacilities().contains(x))hm.get(name).getFacilities().add(x);
        }
        return hm.get(name);
    }
}
