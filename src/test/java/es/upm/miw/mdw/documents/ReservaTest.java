package es.upm.miw.mdw.documents;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservaTest {

    @Test
    void testGenerarLocalizador() {
        Reserva reserva = new Reserva();
        reserva.setCodigoHabitacion("asdfg1234567890");
        reserva.setCorreoCliente("correodelcliente@xyz.es");
        reserva.setNombreCliente("Pepe Rodriguez");
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = fechaInicio.plusHours(2);
        reserva.setFechaHoraReservaInicio(fechaInicio);
        reserva.setFechaHoraReservaFin(fechaFin);
        reserva.setPrecioReserva(32.17f);
        reserva.generaLocalizador();
        String localizador = reserva.getLocalizador();
        assertNotNull(localizador);
        assertTrue(localizador.startsWith("PR"));
    }

}
