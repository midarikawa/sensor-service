package kz.ardak.sensorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<?> registerSensor(@RequestBody String name) {
        try {
            Sensor sensor = sensorService.registerSensor(name);
            return ResponseEntity.ok(sensor);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}