package com.spring.fooddelivery.service.impl;

import com.spring.fooddelivery.model.Number;
import com.spring.fooddelivery.repository.NumberRepository;
import com.spring.fooddelivery.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberServiceImpl implements NumberService {

    private final NumberRepository numberRepository;

    @Autowired
    public NumberServiceImpl(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Override
    public List<Number> getAll() {
        return numberRepository.findAll();
    }

    @Override
    public void save(Number number) {
        numberRepository.save(number);
    }

    @Override
    public Number getById(int id) {
        return numberRepository.findById(id);
    }

    @Override
    public void update(Number number) {
        numberRepository.save(number);
    }

    @Override
    public void delete(int id) {
        numberRepository.deleteById(id);
    }
}
