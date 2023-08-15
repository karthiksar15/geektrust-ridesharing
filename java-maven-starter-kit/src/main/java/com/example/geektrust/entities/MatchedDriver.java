package com.example.geektrust.entities;

public class MatchedDriver {

    private Double distance;
    private String driverId;

    public MatchedDriver(Double distance,String driverId)
    {
        this.distance=distance;
        this.driverId=driverId;
    }
    public Double getDistance() {
        return distance;
    }
    public String getDriverId() {
        return driverId;
    }
    
    
}
