package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.TestConfig;
import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.dtos.ReservaDto;
import es.upm.miw.mdw.services.DBService;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ReservaRepositoryIT {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private DBService dbService;

    @BeforeEach
    void setUpTests (){
        dbService.seedDB();
    }

    @Test
    void testfindByFechaInicioFechaFin(){
        System.out.println(reservaRepository.findMoreThanFechaInicio(LocalDateTime.now()));
        assertNotNull(reservaRepository.findMoreThanFechaInicio(LocalDateTime.now()));
    }

    @Test
    void testfindBookingsBetweenDates(){
        String idRoom = "17";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String checkIn = "2019-05-12 20:00:00";
        String checkOut = "2019-05-12 22:00:00";
        Date startSearchFound = null, endSearchFound = null;
        try {
            startSearchFound = sd.parse("2019-05-12 21:59:59");
            endSearchFound = sd.parse("2019-05-12 23:00:00");
        }catch (Exception ex){}
        Optional<Habitacion> habitacion = habitacionRepository.findById(idRoom);
        assertEquals(idRoom,habitacion.orElseThrow(RuntimeException::new).getCodigoHabitacion());
        assertEquals(0, reservaRepository.findBookingsBetweenDates(startSearchFound,endSearchFound).size());
        ReservaDto reservaDto = createReserva(idRoom, checkIn, checkOut);
        assertEquals(1, reservaRepository.findBookingsBetweenDates(startSearchFound,endSearchFound).size());
    }

    @Test
    void testfindBookingsOnRoomBetweenDates(){
        String idRoom = "17";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String checkIn = "2019-05-12 20:00:00";
        String checkOut = "2019-05-12 22:00:00";
        Date startSearchFound = null, endSearchFound = null;
        try {
            startSearchFound = sd.parse("2019-05-12 21:59:59");
            endSearchFound = sd.parse("2019-05-12 23:00:00");
        }catch (Exception ex){}
        Optional<Habitacion> habitacion = habitacionRepository.findById(idRoom);
        assertEquals(idRoom,habitacion.orElseThrow(RuntimeException::new).getCodigoHabitacion());
        assertEquals(0, reservaRepository.findBookingsOnRoomBetweenDates(idRoom,startSearchFound,endSearchFound).size());
        ReservaDto reservaDto = createReserva(idRoom, checkIn, checkOut);
        assertEquals(1, reservaRepository.findBookingsOnRoomBetweenDates(idRoom,startSearchFound,endSearchFound).size());
        assertEquals(0, reservaRepository.findBookingsOnRoomBetweenDates("18",startSearchFound,endSearchFound).size());
    }

    @Test
    void testfindByCodigoHabitacion(){
        String idRoom = "17";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String checkIn = "2019-05-12 20:00:00";
        String checkOut = "2019-05-12 22:00:00";
        Date startSearchFound = null, endSearchFound = null;
        try {
            startSearchFound = sd.parse("2019-05-12 21:59:59");
            endSearchFound = sd.parse("2019-05-12 23:00:00");
        }catch (Exception ex){}
        Optional<Habitacion> habitacion = habitacionRepository.findById(idRoom);
        assertEquals(idRoom,habitacion.orElseThrow(RuntimeException::new).getCodigoHabitacion());
        assertEquals(0, reservaRepository.findByCodigoHabitacion(idRoom).size());
        ReservaDto reservaDto = createReserva(idRoom, checkIn, checkOut);
        assertEquals(1, reservaRepository.findByCodigoHabitacion(idRoom).size());
    }


    @AfterEach
    void clean (){
        dbService.deleteAll();
    }

    private ReservaDto createReserva(String codigoHabitacion, String fechaInicio, String fechaFin){
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setCodigoHabitacion(codigoHabitacion);
        reservaDto.setNombreCliente("Pepe Rodriguez");
        reservaDto.setCorreoCliente("pepe@xyz.es");
        reservaDto.setFechaInicio(fechaInicio);
        reservaDto.setFechaFin(fechaFin);
        reservaRepository.save(reservaDto.toDocument());
        return reservaDto;
    }
}