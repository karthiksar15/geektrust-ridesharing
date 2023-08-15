package com.example.geektrust.repositories;

import java.util.List;


import com.example.geektrust.entities.Driver;

public interface IDriverRepository extends CRUDRepository<Driver,String> {
   public List<Driver> findAll();
}
