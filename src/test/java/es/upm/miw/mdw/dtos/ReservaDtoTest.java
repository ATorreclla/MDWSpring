package es.upm.miw.mdw.dtos;

import es.upm.miw.mdw.documents.Reserva;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaDtoTest {

    @Test
    public void testDtoToDocumentObject(){
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setCodigoHabitacion("asdfg1234567890");
        reservaDto.setCorreoCliente("correodelcliente@xyz.es");
        reservaDto.setNombreCliente("Pepe Rodriguez");
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = fechaInicio.plusHours(2);
        reservaDto.setFechaInicio(fechaInicio);
        reservaDto.setFechaFin(fechaFin);
        reservaDto.setPrecio(32.17f);
        Reserva reserva = reservaDto.toDocument();
        assertEquals(reservaDto.getCodigoHabitacion(),reserva.getCodigoHabitacion());
        assertEquals(reservaDto.getCorreoCliente(),reserva.getCorreoCliente());
        assertEquals(reservaDto.getFechaInicio(),ReservaDto.convertLocalDateTimeToString(reserva.getFechaHoraReservaInicio()));
        assertEquals(reservaDto.getFechaFin(),ReservaDto.convertLocalDateTimeToString(reserva.getFechaHoraReservaFin()));
        assertEquals(reservaDto.getNombreCliente(),reserva.getNombreCliente());
    }
}
