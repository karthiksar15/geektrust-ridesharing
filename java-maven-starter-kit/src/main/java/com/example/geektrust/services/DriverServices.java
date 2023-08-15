package com.example.geektrust.services;

import java.util.List;

import com.example.geektrust.entities.Driver;
import com.example.geektrust.entities.Location;
import com.example.geektrust.repositories.IDriverRepository;

public class DriverServices implements IDriverServices {

    private IDriverRepository driverRepository;

    public DriverServices(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void saveDriver(String driverId, String xPoint, String yPoint) {
        Location location = new Location(Integer.parseInt(xPoint), Integer.parseInt(yPoint));
        Driver driver = new Driver(driverId, location);
        driverRepository.save(driver);
    }

    @Override
    public List<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findDriver(String driverId) {
        return driverRepository.findById(driverId).get();
    }

}
