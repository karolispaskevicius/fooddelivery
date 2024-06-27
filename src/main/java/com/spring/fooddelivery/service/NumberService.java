package com.spring.fooddelivery.service;

import com.spring.fooddelivery.model.Number;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NumberService {

    List<Number> getAll();

    void save(Number number);

    Number getById(int id);

    void update(Number number);

    void delete(int id);
}
