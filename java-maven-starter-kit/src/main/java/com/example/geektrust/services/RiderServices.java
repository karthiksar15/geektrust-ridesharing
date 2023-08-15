package com.example.geektrust.services;

import com.example.geektrust.entities.Location;
import com.example.geektrust.entities.Rider;
import com.example.geektrust.repositories.IRiderRepository;

public class RiderServices implements IRiderServices {

    private IRiderRepository riderRepository;

    public RiderServices(IRiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public void save(String riderId, String xPoint, String yPoint) {
        Location location = new Location(Integer.parseInt(xPoint), Integer.parseInt(yPoint));
        Rider rider = new Rider(riderId, location);
        riderRepository.save(rider);
    }

    public Rider findRider(String riderId) {
        return riderRepository.findById(riderId).get();
    }

}
