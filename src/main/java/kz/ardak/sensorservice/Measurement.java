package kz.ardak.sensorservice;

import jakarta.persistence.*;
import kz.ardak.sensorservice.Sensor;
import lombok.Data;

@Entity
@Data
public class Measurement {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;

    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}