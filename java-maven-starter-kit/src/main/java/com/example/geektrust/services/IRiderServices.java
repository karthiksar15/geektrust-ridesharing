package com.example.geektrust.services;

import com.example.geektrust.entities.Rider;

public interface IRiderServices  {

    public void save(String riderId,String xPoint,String yPoint);
    public Rider findRider(String riderId);
    
}
