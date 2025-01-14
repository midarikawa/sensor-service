package kz.ardak.sensorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private SensorRepository sensorRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addMeasurement(@RequestBody Measurement measurement) {
        Optional<Sensor> sensorOptional;
        sensorOptional = sensorRepository.findByName(measurement.getSensor().getName());
        if (!sensorOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Sensor not found");
        }

        measurement.setSensor(sensorOptional.get());
        measurementService.addMeasurement(measurement);
        return ResponseEntity.ok("Measurement added successfully");
    }

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/rainyDaysCount")
    public long getRainyDaysCount() {
        return measurementService.getRainyDaysCount();
    }
}