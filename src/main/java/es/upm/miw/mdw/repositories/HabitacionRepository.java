package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.documents.Habitacion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {
    List<Habitacion> findByCodigoHabitacion(String codigoHabitacion);
}
