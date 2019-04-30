package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.TestConfig;
import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.data_services.DBService;
import es.upm.miw.mdw.dtos.ReservaDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ReservaRepositoryIT {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private DBService dbService;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @BeforeEach
    void setUpTests (){
        dbService.seedDB();
    }

    @Test
    void testfindBookingsBetweenDates(){
        LocalDateTime initialLocalDateTime = LocalDateTime.of(2019, Month.APRIL, 16, 00, 00, 00);
        Instant initialInstant = initialLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date initialDate = Date.from(initialInstant);

        LocalDateTime finaLocalDateTime = LocalDateTime.of(2019, Month.APRIL, 24, 00, 00, 00);
        Instant finalInstant = finaLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date finalDate = Date.from(finalInstant);

        Optional<Habitacion> habitacion = habitacionRepository.findById("17");
        assertEquals("17",habitacion.orElseThrow(RuntimeException::new).getCodigoHabitacion());
        assertEquals(0, reservaRepository.findBookingsBetweenDates(initialDate,finalDate).size());
        /* TODO descomentar al hacer merge con createReserva
        ReservaDto reservaDto = createReserva(idRoom, checkIn, checkOut);
        assertEquals(1, reservaRepository.findBookingsBetweenDates(initialDate,finalDate).size());*/
    }

    @AfterEach
    void clean (){
        dbService.deleteAll();
    }

}