package es.upm.miw.mdw.dtos;

import es.upm.miw.mdw.documents.Reserva;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaDtoTest {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testDtoToDocumentObject(){
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setCodigoHabitacion("asdfg1234567890");
        reservaDto.setCorreCliente("correodelcliente@xyz.es");
        reservaDto.setNombreCliente("Pepe Rodriguez");
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = fechaInicio.plusHours(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        reservaDto.setFechaInicio(formatter.format(fechaInicio));
        reservaDto.setFechaFin(formatter.format(fechaFin));
        reservaDto.setPrecio(32.17f);
        Reserva reserva = reservaDto.toDocument();
        assertEquals(reservaDto.getCodigoHabitacion(),reserva.getCodigoHabitacion());
        assertEquals(reservaDto.getCorreCliente(),reserva.getCorreCliente());
        assertEquals(reservaDto.getFechaInicio(),formatter.format(reserva.getFechaHoraReservaInicio()));
        assertEquals(reservaDto.getFechaFin(),formatter.format(reserva.getFechaHoraReservaFin()));
        assertEquals(reservaDto.getNombreCliente(),reserva.getNombreCliente());
    }
}
