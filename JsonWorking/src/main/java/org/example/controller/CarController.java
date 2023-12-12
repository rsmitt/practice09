package org.example.controller;

import org.example.model.Car;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    @GetMapping("/")
    public List<Car> getCarsDetails() {
        Car lada = new Car(1, "LADA", getLadaOptions());
        Car opel = new Car(2, "OPEL", getOpelOptions());

        return Arrays.asList(lada, opel);
    }


    private Map<String, String> getLadaOptions() {
        Map<String, String> options = new HashMap<>();
        options.put("color", "black");
        options.put("age", "2000");

        return options;
    }

    private Map<String, String> getOpelOptions() {
        Map<String, String> options = new HashMap<>();
        options.put("color", "white");
        options.put("age", "2010");

        return options;
    }
}
