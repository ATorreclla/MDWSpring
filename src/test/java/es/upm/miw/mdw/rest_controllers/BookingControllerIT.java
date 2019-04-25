package es.upm.miw.mdw.rest_controllers;

import es.upm.miw.mdw.dtos.ReservaDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
public class BookingControllerIT {
    @Autowired
    private RestService restService;

    @Test
    public void testSaveBooking(){
        System.out.println("Se ejecuta mi prueba");
        ReservaDto input = new ReservaDto();
        ReservaDto output = this.restService.
                restBuilder(new RestBuilder<ReservaDto>()).clazz(ReservaDto.class).
                path(BookingResource.BOOKING)
                .path(BookingResource.SAVE).body(input).post().build();
        assertEquals(input.getCodigoHabitacion(),output.getCodigoHabitacion());
        assertEquals(input.getCorreCliente(),output.getCorreCliente());
        assertEquals(input.getFechaInicio(),output.getFechaInicio());
        assertEquals(input.getFechaFin(),output.getFechaFin());
        assertEquals(input.getNombreCliente(),output.getNombreCliente());
    }
}
