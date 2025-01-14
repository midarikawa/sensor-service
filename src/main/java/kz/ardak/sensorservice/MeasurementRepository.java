package midarikawa.codes.my_spring_project.code;

import midarikawa.codes.my_spring_project.code.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    long countByRainingTrue();
}
