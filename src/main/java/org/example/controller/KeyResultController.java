package org.example.controller;

import org.example.model.KeyResult;
import org.example.service.KeyResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/key-results")
public class KeyResultController {

    private final KeyResultService keyResultService;

    @Autowired
    public KeyResultController(KeyResultService keyResultService) {
        this.keyResultService = keyResultService;
    }

    @GetMapping
    public ResponseEntity<List<KeyResult>> getAllKeyResults() {
        List<KeyResult> keyResults = keyResultService.getAllKeyResults();
        return ResponseEntity.ok(keyResults);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeyResult> getKeyResultById(@PathVariable Long id) {
        KeyResult keyResult = keyResultService.getKeyResultById(id);
        if (keyResult != null) {
            return ResponseEntity.ok(keyResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<KeyResult> createKeyResult(@RequestBody KeyResult keyResult) {
        KeyResult createdKeyResult = keyResultService.createKeyResult(keyResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKeyResult);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeyResult> updateKeyResult(@PathVariable Long id, @RequestBody KeyResult keyResult, @RequestParam String comment) {
        KeyResult updatedKeyResult = keyResultService.updateKeyResult(id, keyResult, comment);
        if (updatedKeyResult != null) {
            return ResponseEntity.ok(updatedKeyResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKeyResult(@PathVariable Long id) {
        boolean deleted = keyResultService.deleteKeyResult(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
