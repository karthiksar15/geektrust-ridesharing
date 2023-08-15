package com.example.geektrust.entities;

public class Rider {

    private String id;
    private Location location;

    public Rider(String id,Location location)
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
