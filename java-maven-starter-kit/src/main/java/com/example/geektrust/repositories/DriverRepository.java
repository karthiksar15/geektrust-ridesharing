package com.example.geektrust.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entities.Driver;

public class DriverRepository implements IDriverRepository {

    private static final Map<String, Driver> driverMap = new HashMap<>();

    @Override
    public Driver save(Driver entity) {
        driverMap.put(entity.getId(), entity);
        return entity;
    }
      @Override
    public List<Driver> findAll() {
        List<Driver> driverList = new ArrayList<>();
        for (Driver driver : driverMap.values()) {
            driverList.add(driver);
        }
        return driverList;
    }

    @Override
    public Optional<Driver> findById(String id) {
         return Optional.of(driverMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

  

}
