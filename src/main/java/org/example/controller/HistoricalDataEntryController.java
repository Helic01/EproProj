package org.example.controller;

import org.example.model.HistoricalDataEntry;
import org.example.service.HistoricalDataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historical-data-entries")
public class HistoricalDataEntryController {

    private final HistoricalDataEntryService historicalDataEntryService;

    @Autowired
    public HistoricalDataEntryController(HistoricalDataEntryService historicalDataEntryService) {
        this.historicalDataEntryService = historicalDataEntryService;
    }

    @GetMapping
    public ResponseEntity<List<HistoricalDataEntry>> getAllHistoricalDataEntries() {
        List<HistoricalDataEntry> historicalDataEntries = historicalDataEntryService.getAllHistoricalDataEntries();
        return ResponseEntity.ok(historicalDataEntries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricalDataEntry> getHistoricalDataEntryById(@PathVariable Long id) {
        HistoricalDataEntry historicalDataEntry = historicalDataEntryService.getHistoricalDataEntryById(id);
        if (historicalDataEntry != null) {
            return ResponseEntity.ok(historicalDataEntry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HistoricalDataEntry> createHistoricalDataEntry(@RequestBody HistoricalDataEntry historicalDataEntry) {
        HistoricalDataEntry createdHistoricalDataEntry = historicalDataEntryService.createHistoricalDataEntry(historicalDataEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHistoricalDataEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricalDataEntry> updateHistoricalDataEntry(@PathVariable Long id, @RequestBody HistoricalDataEntry historicalDataEntry) {
        HistoricalDataEntry updatedHistoricalDataEntry = historicalDataEntryService.updateHistoricalDataEntry(id, historicalDataEntry);
        if (updatedHistoricalDataEntry != null) {
            return ResponseEntity.ok(updatedHistoricalDataEntry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoricalDataEntry(@PathVariable Long id) {
        boolean deleted = historicalDataEntryService.deleteHistoricalDataEntry(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
