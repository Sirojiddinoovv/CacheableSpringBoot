package uz.nodir.rediscachedemo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.nodir.rediscachedemo.model.dto.status.request.StatusBaseRequestDTO;
import uz.nodir.rediscachedemo.service.business.StatusService;

/**
 * Created by Nodir
 * on Date 10 янв., 2024
 * Java Spring Boot by Davr Coders
 */
@RestController
@RequestMapping("/api/v1/status")
@RequiredArgsConstructor
public class StatusController {
    private final StatusService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid StatusBaseRequestDTO requestDTO) {
        return ResponseEntity.ok(service.create(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid StatusBaseRequestDTO requestDTO) {
        return ResponseEntity.ok(service.update(id, requestDTO));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @PatchMapping("/cacheEvict")
    public ResponseEntity<?> cacheEvict() {
        return ResponseEntity.ok(service.evictCache());
    }
}
