package es.upm.miw.mdw.controllers;
import es.upm.miw.mdw.TestConfig;
import es.upm.miw.mdw.data_services.DBService;
import es.upm.miw.mdw.dtos.HabitacionDTO;
import es.upm.miw.mdw.dtos.HabitacionQueryDTO;
import es.upm.miw.mdw.exceptions.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class HabitacionControllerIT {

    @Autowired
    private DBService dbService;

    private DateTimeFormatter formatter;

    @Autowired
    private HabitacionController habitacionController;

    @BeforeEach
    void setUpTests (){
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        dbService.seedDB();
    }

    @Test
    void testQueryHabitacionesFechaInicioNull (){
        LocalDateTime fechaHoraReservaInicio = null;
        LocalDateTime fechaHoraReservaFin = LocalDateTime.parse("2019-04-15 21:00",formatter);
        BadRequestException thrown = assertThrows(BadRequestException.class, () ->
                habitacionController.queryHabitaciones(new HabitacionQueryDTO(fechaHoraReservaInicio, fechaHoraReservaFin, "Alicante")));
        assertTrue(thrown.getMessage().contains("Bad Request Exception (400)"));
    }

    @Test
    void testQueryHabitacionesFechaFinNull(){
        LocalDateTime fechaHoraReservaInicio = LocalDateTime.parse("2019-04-15 18:00", formatter);
        LocalDateTime fechaHoraReservaFin = null;
        BadRequestException thrown = assertThrows(BadRequestException.class, () ->
                habitacionController.queryHabitaciones(new HabitacionQueryDTO(fechaHoraReservaInicio, fechaHoraReservaFin, "Alicante")));
        assertTrue(thrown.getMessage().contains("Bad Request Exception (400)"));
    }

    @Test
    void testQueryHabitacionesUbicacionNull (){
        LocalDateTime fechaHoraReservaInicio = LocalDateTime.parse("2019-04-15 18:00", formatter);
        LocalDateTime fechaHoraReservaFin = LocalDateTime.parse("2019-04-15 21:00",formatter);
        BadRequestException thrown = assertThrows(BadRequestException.class, () ->
                habitacionController.queryHabitaciones(new HabitacionQueryDTO(fechaHoraReservaInicio, fechaHoraReservaFin, null)));
        assertTrue(thrown.getMessage().contains("Bad Request Exception (400)"));
    }

    @Test
    void testQueryHabitaciones() {
            LocalDateTime fechaHoraReservaInicio = LocalDateTime.parse("2019-04-15 18:00", formatter);
            LocalDateTime fechaHoraReservaFin = LocalDateTime.parse("2019-04-15 21:00", formatter);
            List<HabitacionDTO> habitacionList = habitacionController.queryHabitaciones(new HabitacionQueryDTO(fechaHoraReservaInicio, fechaHoraReservaFin, "Alicante"));
            assertNotNull(habitacionList);
            assertEquals(1, habitacionList.size());
    }


    @AfterEach
    void clean() {
        dbService.deleteAll();
    }

}
