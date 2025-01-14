package kz.ardak.sensorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public Measurement addMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public long getRainyDaysCount() {
        return measurementRepository.countByRainingTrue();
    }
}