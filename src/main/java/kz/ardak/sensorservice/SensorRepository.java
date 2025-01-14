package midarikawa.codes.my_spring_project.code;

import midarikawa.codes.my_spring_project.code.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findByName(String name);
}