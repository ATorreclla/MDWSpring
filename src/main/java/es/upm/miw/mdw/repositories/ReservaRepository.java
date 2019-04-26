package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.documents.Reserva;
import org.apache.tomcat.jni.Local;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva,String> {

    @Query("{'fechaHoraReservaInicio' : { '$gt' : ?0 }}")
    List<Reserva> findMoreThanFechaInicio
            (LocalDateTime fechaHoraReservaInicio);
}
