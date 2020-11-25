package com.example.dao;

import com.example.model.Driver;

import java.util.List;

public interface DriverDao {
    void addDriver(Driver driver);
    void deleteDriver(int id);
    void getDriver(int id);
    List<Driver> getListOfDrivers();
}
