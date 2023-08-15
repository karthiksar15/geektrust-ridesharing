package com.example.geektrust.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entities.Ride;

public class RideRepository implements IRideRepository  {

    private static final Map<String,Ride> rideMap=new HashMap<>();

    @Override
    public Ride save(Ride entity) {
        rideMap.put(entity.getId(), entity);
        return entity;

    }

    @Override
    public Optional<Ride> findById(String id) {
        if(rideMap.size()>0)
            return Optional.of(rideMap.get(id));
        return Optional.empty();
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
    
}
