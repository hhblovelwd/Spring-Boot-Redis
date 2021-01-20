package com.hhb.controller;

import com.alibaba.fastjson.JSON;
import com.hhb.entity.Car;
import com.hhb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "/alll",produces="application/json;charset=UTF-8")
    public String all(){
        return JSON.toJSONString(carService.getCar());
    }
}
