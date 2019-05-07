package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.documents.Habitacion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {
    Habitacion findFirstByCodigoHabitacion(String codigoHabitacion);

    List<Habitacion> findByUbicacionIgnoreCase(String ubicacion);

}
