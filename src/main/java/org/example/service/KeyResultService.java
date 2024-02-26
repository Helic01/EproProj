package org.example.service;

import org.example.model.KeyResult;
import org.example.model.HistoricalDataEntry;
import org.example.repository.KeyResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import java.time.LocalDateTime;

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

    public KeyResult updateKeyResult(Long id, KeyResult newKeyResult, String comment) {
        Optional<KeyResult> optionalKeyResult = keyResultRepository.findById(id);
        if (optionalKeyResult.isPresent()) {
            KeyResult existingKeyResult = optionalKeyResult.get();

            List<HistoricalDataEntry> historicalDataEntries = createHistoricalDataEntries(existingKeyResult, newKeyResult, comment);
            if (!historicalDataEntries.isEmpty()) {
                existingKeyResult.getHistoricalData().addAll(historicalDataEntries);
            }

            existingKeyResult.setName(newKeyResult.getName());
            //existingKeyResult.setProgress(newKeyResult.getProgress());
            //existingKeyResult.setObjective(newKeyResult.getObjective());

            return keyResultRepository.save(existingKeyResult);
        } else {
            throw new RuntimeException("Key Result with ID " + id + " not found");
        }
    }

    private List<HistoricalDataEntry> createHistoricalDataEntries(KeyResult existingKeyResult, KeyResult newKeyResult, String comment) {
        List<HistoricalDataEntry> historicalDataEntries = new ArrayList<>();

        if (existingKeyResult.getProgress() != newKeyResult.getProgress()) {
            HistoricalDataEntry historicalDataEntry = new HistoricalDataEntry();
            historicalDataEntry.setDate(String.valueOf(LocalDateTime.now()));
            historicalDataEntry.setValue(existingKeyResult.getProgress());
            historicalDataEntry.setComment(comment);
            //historicalDataEntry.setKeyResult(existingKeyResult);
            historicalDataEntries.add(historicalDataEntry);
        }

        return historicalDataEntries;
    }

    public boolean deleteKeyResult(Long id) {
        try {
            keyResultRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<KeyResult> getAllKeyResults() {
        return keyResultRepository.findAll();
    }

}
