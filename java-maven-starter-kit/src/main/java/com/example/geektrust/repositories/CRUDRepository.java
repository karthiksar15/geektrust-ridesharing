package com.example.geektrust.repositories;

import java.util.Optional;

public interface CRUDRepository<T,ID>  {

    public T save(T entity);
    public Optional<T> findById(ID id);
    public boolean existsById(ID id);
  
    
}
