package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.documents.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva,String> {

    @Query("{$or:["
            + "?#{ [0] == null ? { $where : 'true'} : { fechaHoraReservaInicio  : {$gte : [0], $lte : [1]} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { fechaHoraReservaFin  : {$gte : [0], $lte : [1]} } }"
            + "] }")
    List<Reserva> findBookingsBetweenDates(Date checkIn, Date checkOut);

}
