package com.comarch.szkolenia.rest.services;

import com.comarch.szkolenia.rest.model.Car;

import java.util.List;

public interface ICarService {
    Car getRandomCar();
    List<Car> getCars();
}
