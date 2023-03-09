package com.emerik.carservice.service;

import com.emerik.carservice.entity.Car;
import com.emerik.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpCarService{

    @Autowired
    CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getCarById(int id) {
        return carRepository.getById(id);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> byUserId(int userId) {
        return carRepository.findByUserId(userId);
    }
}
