package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.documents.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva,String> {
}
