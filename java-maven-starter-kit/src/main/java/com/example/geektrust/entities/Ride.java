package com.example.geektrust.entities;

public class Ride {
    private String id;
    private Rider rider;
    private Driver driver;
    private Double billAmount;
    private RideStatus rideStatus;

   public Ride(String id,Driver driver,Rider rider)
    {
        this.id=id;
        this.driver=driver;
        this.rider=rider;
    } 

    public Ride(Ride ride,RideStatus rideStatus,Double billAmount)
    {
        this(ride.getId(),ride.getDriver(),ride.getRider());
        this.rideStatus=rideStatus;
        this.billAmount=billAmount;
    }

    public String getId() {
        return id;
    }
    public Rider getRider() {
        return rider;
    }
    public Driver getDriver() {
        return driver;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }
    
}
