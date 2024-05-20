package com.comarch.szkolenia.rest.controllers;

import com.comarch.szkolenia.rest.model.Car;
import com.comarch.szkolenia.rest.model.dto.CarsWrapper;
import com.comarch.szkolenia.rest.services.CarService;
import com.comarch.szkolenia.rest.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
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

    }

    @GetMapping("/test6")
    public CarsWrapper test6() {
        CarsWrapper wrapper = new CarsWrapper();
        wrapper.setCars(this.carService.getCars());
        return wrapper;
    }
}
