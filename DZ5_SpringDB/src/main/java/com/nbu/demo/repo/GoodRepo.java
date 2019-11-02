package com.nbu.demo.repo;

import com.nbu.demo.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepo extends JpaRepository <Good, Long> {
}
