package es.upm.miw.mdw.controllers;

import es.upm.miw.mdw.data_services.DBService;
import es.upm.miw.mdw.dtos.ReservaDto;
import es.upm.miw.mdw.rest_controllers.ApiTestConfig;
import es.upm.miw.mdw.rest_controllers.BookingResource;
import es.upm.miw.mdw.rest_controllers.RestBuilder;
import es.upm.miw.mdw.rest_controllers.RestService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class BookingControllerIT {
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
        System.out.println("Se ejecuta mi prueba");
        ReservaDto input = new ReservaDto();
        ReservaDto output = this.restService.
                restBuilder(new RestBuilder<ReservaDto>()).clazz(ReservaDto.class).
                path(BookingResource.BOOKING)
                .path(BookingResource.SAVE).body(input).post().build();
        assertEquals(input.getCodigoHabitacion(), output.getCodigoHabitacion());
        assertEquals(input.getCorreCliente(), output.getCorreCliente());
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
                        .path(BookingResource.VALIDATION).expand("17").param("fechaHoraReservaInicio", "2019-04-30 18:00")
                        .param("fechaHoraReservaFin", "2019-04-30 19:00").get().build()
        );
    }

    @AfterEach
    void clean() {
        dbService.deleteAll();
    }

}
