package com.emerik.carservice.controller;

import com.emerik.carservice.entity.Car;
import com.emerik.carservice.service.ImpCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    ImpCarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> listCar = carService.getAll();
        if (listCar.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id) {
        Car car = carService.getCarById(id);
        if (car == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        Car carNew = carService.save(car);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId) {
        List<Car> list = carService.byUserId(userId);
        if (list.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }


}
