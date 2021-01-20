package com.hhb.mapper;

import com.hhb.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
@Mapper
public interface CarMapper {
    List<Car>getCar();
}
