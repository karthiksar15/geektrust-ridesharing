package com.example.geektrust.entities;

public class Driver {

    private String id;
    private Location location;

    public Driver(String id,Location location)
    {
          this.id=id;
          this.location=location;
    }
    public String getId() {
        return id;
    }
    public Location getLocation() {
        return location;
    }
    
}
