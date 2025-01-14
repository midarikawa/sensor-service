package kz.ardak.sensorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public Sensor registerSensor(String name) {
        Optional<Sensor> existingSensor = sensorRepository.findByName(name);
        if (existingSensor.isPresent()) {
            throw new RuntimeException("Sensor with name " + name + " already exists");
        }
        Sensor sensor = new Sensor();
        sensor.setName(name);
        return sensorRepository.save(sensor);
    }
}