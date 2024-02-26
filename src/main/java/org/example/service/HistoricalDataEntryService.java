package org.example.service;

import org.example.model.HistoricalDataEntry;
import org.example.repository.HistoricalDataEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalDataEntryService {

    private final HistoricalDataEntryRepository historicalDataEntryRepository;

    @Autowired
    public HistoricalDataEntryService(HistoricalDataEntryRepository historicalDataEntryRepository) {
        this.historicalDataEntryRepository = historicalDataEntryRepository;
    }

    public List<HistoricalDataEntry> getAllHistoricalDataEntries() {
        return historicalDataEntryRepository.findAll();
    }

    public HistoricalDataEntry getHistoricalDataEntryById(Long id) {
        return historicalDataEntryRepository.findById(id).orElse(null);
    }

    public HistoricalDataEntry createHistoricalDataEntry(HistoricalDataEntry historicalDataEntry) {
        return historicalDataEntryRepository.save(historicalDataEntry);
    }

    public HistoricalDataEntry updateHistoricalDataEntry(Long id, HistoricalDataEntry historicalDataEntry) {
        if (historicalDataEntryRepository.existsById(id)) {
            historicalDataEntry.setId(id);
            return historicalDataEntryRepository.save(historicalDataEntry);
        }
        return null;
    }

    public boolean deleteHistoricalDataEntry(Long id) {
        if (historicalDataEntryRepository.existsById(id)) {
            historicalDataEntryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
