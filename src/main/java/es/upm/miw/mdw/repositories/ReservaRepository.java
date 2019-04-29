package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.documents.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva,String> {

    List<Reserva> findByCodigoHabitacion(String codigoHabitacion);

    @Query("{'fechaHoraReservaInicio' : { '$gt' : ?0 }}")
    List<Reserva> findMoreThanFechaInicio
            (LocalDateTime fechaHoraReservaInicio);

    @Query("{$or:["
            + "?#{ [0] == null ? { $where : 'true'} : { fechaHoraReservaInicio  : {$gte : [0], $lte : [1]} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { fechaHoraReservaFin  : {$gte : [0], $lte : [1]} } }"
            + "] }")
    List<Reserva> findBookingsBetweenDates(Date checkIn, Date checkOut);

    @Query("{$or:["
            + "?#{ [0] == null ? { $where : 'true'} : { codigoHabitacion: [0], fechaHoraReservaInicio  : {$gte : [1], $lte : [2]} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { codigoHabitacion: [0], fechaHoraReservaFin  : {$gte : [1], $lte : [2]} } }"
            + "] }")
    List<Reserva> findBookingsOnRoomBetweenDates(String idRoom, Date checkIn, Date checkOut);
}
