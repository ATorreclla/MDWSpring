package es.upm.miw.mdw.rest_controllers;

import es.upm.miw.mdw.data_services.DBService;
import es.upm.miw.mdw.dtos.HabitacionDTO;
import es.upm.miw.mdw.dtos.HabitacionQueryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ApiTestConfig
public class HabitacionResourceIT {

    @Autowired
    private RestService restService;

    @Autowired
    private DBService dbService;

    @BeforeEach
    void setUpTests (){
        dbService.seedDB();
    }

    @Test
    void testQueryHabitaciones() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime fechaHoraReservaInicio = LocalDateTime.parse("2019-04-15 18:00", formatter);
        LocalDateTime fechaHoraReservaFin = LocalDateTime.parse("2019-04-15 21:00",formatter);

        List<HabitacionDTO> habitaciones = Arrays.asList(this.restService.restBuilder(new RestBuilder<HabitacionDTO[]>())
                .clazz(HabitacionDTO[].class).path(HabitacionResource.HABITACIONES).path(HabitacionResource.QUERY)
                .body(new HabitacionQueryDTO(fechaHoraReservaInicio, fechaHoraReservaFin, "Alicante")).post().build());
        System.out.println(habitaciones);
        assertNotNull(habitaciones);
        assertEquals(1, habitaciones.size());
    }

    @Test
    void testQueryHabitacionesNullQuery() {
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () ->
            this.restService.restBuilder(new RestBuilder<HabitacionDTO[]>())
                .clazz(HabitacionDTO[].class).path(HabitacionResource.HABITACIONES)
                .body(null).post().build());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

}
