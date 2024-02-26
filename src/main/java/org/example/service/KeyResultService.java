package org.example.service;

import org.example.model.KeyResult;
import org.example.repository.KeyResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyResultService {

    @Autowired
    private KeyResultRepository keyResultRepository;

    public KeyResult getKeyResultById(Long id) {
        return keyResultRepository.findById(id).orElse(null);
    }

    public KeyResult createKeyResult(KeyResult keyResult) {
        return keyResultRepository.save(keyResult);
    }

    public KeyResult updateKeyResult(Long id, KeyResult keyResult) {
        keyResult.setId(id); // Ensure the ID matches the path variable
        return keyResultRepository.save(keyResult);
    }

    public boolean deleteKeyResult(Long id) {
        try {
            keyResultRepository.deleteById(id);
            return true; // Deletion successful
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception
            return false; // Deletion failed
        }
    }


    public List<KeyResult> getAllKeyResults() {
        return keyResultRepository.findAll();
    }
}
