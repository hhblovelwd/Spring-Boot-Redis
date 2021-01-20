package com.hhb.service.impl;

import com.alibaba.fastjson.JSON;
import com.hhb.entity.Car;
import com.hhb.mapper.CarMapper;
import com.hhb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.alibaba.*;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private  CarMapper carMapper;

    @Autowired(required = false)
    private StringRedisTemplate redisTemplate;

    public List<Car> getCar() {
        String key = "car";
        List<Car> list = null;
        if (redisTemplate.hasKey(key)) {
            System.out.println("redis");
            String json = redisTemplate.boundValueOps(key).get();
            list = JSON.parseArray(json, Car.class);
        } else {
            System.out.println("DBsdas");
            list = carMapper.getCar();
            redisTemplate.boundValueOps(key).set(JSON.toJSONString(list));
        }
        return list;
    }
}
