package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.documents.Habitacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {
    Habitacion findFirstByCodigoHabitacion(String codigoHabitacion);
}
