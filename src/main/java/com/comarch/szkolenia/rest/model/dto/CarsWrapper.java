package com.comarch.szkolenia.rest.model.dto;

import com.comarch.szkolenia.rest.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsWrapper {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
