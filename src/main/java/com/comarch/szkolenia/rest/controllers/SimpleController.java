package com.comarch.szkolenia.rest.controllers;

import com.comarch.szkolenia.rest.model.Car;
import com.comarch.szkolenia.rest.model.dto.CarsWrapper;
import com.comarch.szkolenia.rest.services.CarService;
import com.comarch.szkolenia.rest.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    ICarService carService;

    //@RequestMapping(path = "/test", method = RequestMethod.GET)
    @GetMapping("/test")
    public void test() {
        System.out.println("Cos dziala !!");
    }

    @GetMapping("/test2")
    public void test2(@RequestParam("name") String name,
                      @RequestParam("surname") String surname,
                      @RequestParam("age") int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
    }

    @GetMapping("/test3/{name}/{surname}/{age}")
    public void test3(@PathVariable("name") String name,
                      @PathVariable("surname") String surname,
                      @PathVariable("age") int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
    }

    @GetMapping("/test4")
    public Car test4() {
        return this.carService.getRandomCar();
    }

    @PostMapping("/test5")
    public void test5(@RequestBody Car car) {
        System.out.println(car.getId());
        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getPlate());
    }

    @GetMapping("/test6")
    public CarsWrapper test6() {
        CarsWrapper wrapper = new CarsWrapper();
        wrapper.setCars(this.carService.getCars());
        return wrapper;
    }

    @GetMapping("/test7")
    public void test7(@RequestHeader("header1") String h1,
                      @RequestHeader("header2") String h2) {
        System.out.println(h1);
        System.out.println(h2);
    }

    @PutMapping("/test8/{age}")
    public Car test8(@RequestParam(name = "name", required = false) String imie,
                     @RequestParam("surname") String nazwisko,
                     @PathVariable(value = "age") int age,
                     @RequestHeader(name = "header1", required = false) String h1,
                     @RequestHeader("header2") String h2,
                     @RequestBody(required = false) Car car) {
        System.out.println(imie);
        System.out.println(nazwisko);
        System.out.println(age);
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(car.getId());
        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getPlate());
        return this.carService.getRandomCar();
    }

    @PutMapping("/test8/77")
    public void cos() {

    }

    @GetMapping("/test9")
    public ResponseEntity<Car> test9() {
        Car car = this.carService.getRandomCar();
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("naglowek", "jakas wartosc naglowka")
                .header("h2", "v2")
                .body(car);
    }

    @PostMapping("/test10")
    public Car test10(@RequestBody Car car) {
        System.out.println("TEST10 !!!!");
        car.setId(car.getId()+5);
        car.setBrand(car.getBrand()+"X");
        car.setModel(car.getModel()+"Y");
        car.setPlate(car.getPlate()+"XYZ");

        return car;
    }
}
