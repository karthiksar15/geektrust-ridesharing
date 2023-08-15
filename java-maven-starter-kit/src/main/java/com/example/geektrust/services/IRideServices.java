package com.example.geektrust.services;

import java.util.List;

import com.example.geektrust.entities.Location;
import com.example.geektrust.entities.MatchedDriver;
import com.example.geektrust.entities.Ride;

public interface IRideServices {

    public void findMatch(String riderId);

    public Double getLocationRadius(Location location1, Location location2);

    public List<MatchedDriver> fetchNearestDriver(Location location);

    public void startRide(String rideId, Integer driverNos, String riderId);

    public void stopRide(String rideId, Location location, Integer timeTaken);

    public void updateBill(Ride ride, Double totalKm, Integer timeTaken);

    public void printBill(String rideId) ;

}
