package com.example.geektrust.services;

import java.util.List;

import com.example.geektrust.entities.Driver;

public interface IDriverServices {

    public void saveDriver(String driverId,String xPoint,String yPoint);

    public List<Driver> findAllDrivers();

    public Driver findDriver(String driverId);
    
}
