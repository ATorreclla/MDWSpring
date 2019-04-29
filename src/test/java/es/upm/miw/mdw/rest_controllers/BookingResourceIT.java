package es.upm.miw.mdw.rest_controllers;

import es.upm.miw.mdw.dtos.ReservaDto;
import es.upm.miw.mdw.services.DBService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class BookingResourceIT {
    @Autowired
    private RestService restService;

    @Autowired
    private DBService dbService;

    @BeforeEach
    void setUpTests() {
        dbService.seedDB();
    }

    @Test
    public void testSaveBooking() {
        ReservaDto input = createReserva();
        ReservaDto output = this.restService.
                restBuilder(new RestBuilder<ReservaDto>()).clazz(ReservaDto.class).
                path(BookingResource.BOOKING)
                .path(BookingResource.SAVE).body(input).post().build();
        assertEquals(input.getCodigoHabitacion(), output.getCodigoHabitacion());
        assertEquals(input.getCorreoCliente(), output.getCorreoCliente());
        assertEquals(input.getFechaInicio(), output.getFechaInicio());
        assertEquals(input.getFechaFin(), output.getFechaFin());
        assertEquals(input.getNombreCliente(), output.getNombreCliente());
    }

    @Test
    void testIsValidTimeForHabitacion() {
        assertDoesNotThrow(() ->
                this.restService.restBuilder(new RestBuilder<>()).path(BookingResource.BOOKING).path(BookingResource.SAVE)
                        .path(BookingResource.VALIDATION).expand("17").param("fechaHoraReservaInicio", "2019-04-29 18:00")
                        .param("fechaHoraReservaFin", "2019-04-29 19:00").get().build()
        );
        assertThrows(HttpClientErrorException.BadRequest.class,()->
            this.restService.restBuilder(new RestBuilder<>()).path(BookingResource.BOOKING).path(BookingResource.SAVE)
                    .path(BookingResource.VALIDATION).expand("1").param("fechaHoraReservaInicio", "2019-04-29 18:00")
                    .param("fechaHoraReservaFin", "2019-04-29 19:00").get().build()
        );

        assertThrows(HttpClientErrorException.Conflict.class,()->
                this.restService.restBuilder(new RestBuilder<>()).path(BookingResource.BOOKING).path(BookingResource.SAVE)
                        .path(BookingResource.VALIDATION).expand("1745645").param("fechaHoraReservaInicio", "2019-05-01 12:00")
                        .param("fechaHoraReservaFin", "2019-05-01 14:00").get().build()
        );
    }

    @AfterEach
    void clean() {
        dbService.deleteAll();
    }

    private ReservaDto createReserva(){
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setCodigoHabitacion("17");
        reservaDto.setNombreCliente("Pepe Rodriguez");
        reservaDto.setCorreoCliente("pepe@xyz.es");
        reservaDto.setFechaInicio("2019-05-30 18:00:00");
        reservaDto.setFechaFin("2019-05-30 19:00:00");
        return reservaDto;
    }
}
