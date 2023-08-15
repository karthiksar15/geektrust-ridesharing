package com.example.geektrust.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entities.Rider;

public class RiderRepository implements IRiderRepository {

    private static final Map<String, Rider> riderMap = new HashMap<>();

    @Override
    public Rider save(Rider entity) {
        riderMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Rider> findById(String id) {
        return Optional.of(riderMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

}