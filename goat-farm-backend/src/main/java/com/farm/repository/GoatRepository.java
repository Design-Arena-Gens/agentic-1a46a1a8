package com.farm.repository;

import com.farm.entity.Goat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoatRepository extends JpaRepository<Goat, Long> {
    Optional<Goat> findByTagId(String tagId);
}
