package com.farm.controller;

import com.farm.entity.Goat;
import com.farm.repository.GoatRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goats")
public class GoatController {
    private final GoatRepository goatRepository;

    public GoatController(GoatRepository goatRepository) {
        this.goatRepository = goatRepository;
    }

    @GetMapping
    @Operation(summary = "List all goats")
    public List<Goat> list() {
        return goatRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create or update a goat")
    public Goat upsert(@RequestBody Goat goat) {
        return goatRepository.save(goat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goat> get(@PathVariable Long id) {
        return goatRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
