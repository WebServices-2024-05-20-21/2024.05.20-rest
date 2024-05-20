package com.comarch.szkolenia.rest.services;

import com.comarch.szkolenia.rest.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CarService implements ICarService {
    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        this.cars.add(new Car(1, "BMW", "5", "KR11"));
        this.cars.add(new Car(2, "Toyota", "Corolla", "KR22"));
        this.cars.add(new Car(3, "Kia", "Ceed", "KR33"));
        this.cars.add(new Car(4, "Audi", "A5", "KR44"));
        this.cars.add(new Car(5, "Fiat", "Multipla", "KR55"));
    }

    public Car getRandomCar() {
        return this.cars.get(new Random().nextInt(cars.size()));
    }

    @Override
    public List<Car> getCars() {
        return this.cars;
    }
}
