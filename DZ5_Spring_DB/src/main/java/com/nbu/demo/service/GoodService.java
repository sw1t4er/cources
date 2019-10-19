package com.nbu.demo.service;

import com.nbu.demo.model.Good;
import com.nbu.demo.repo.GoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodService {

    GoodRepo goodRepo;

    @Autowired
    public GoodService (GoodRepo goodRepo) {
        this.goodRepo = goodRepo;
    }

    public Optional<Good> findById(Long id) {
        return goodRepo.findById(id);
    }

    public void save(Good good) { goodRepo.save(good); }

    public void update(Good good) {
        goodRepo.save(good);
    }

    public void delete(Good good) {
        goodRepo.delete(good);
    }

    public List<Good> findAll() {
        return goodRepo.findAll();
    }
}