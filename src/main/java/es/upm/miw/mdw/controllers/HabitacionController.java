package es.upm.miw.mdw.controllers;

import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.exceptions.BadRequestException;
import es.upm.miw.mdw.exceptions.ConflictException;
import es.upm.miw.mdw.repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public void isValidTimeForHabitacion(String codigoHabitacion, LocalDateTime fechaHoraReservaInicio, LocalDateTime fechaHoraReservaFin) {
        Habitacion habitacion = habitacionRepository.findFirstByCodigoHabitacion(codigoHabitacion);
        if (habitacion == null) {
            throw new BadRequestException("Bad habitacion code supplied");
        }
        for (Reserva reserva : habitacion.getReservas()) {
            LocalDateTime inicio = reserva.getFechaHoraReservaInicio();
            LocalDateTime fin = reserva.getFechaHoraReservaFin();
            if (
                    ((fechaHoraReservaInicio.isAfter(inicio) || fechaHoraReservaInicio.isEqual(inicio)) &&
                            (fechaHoraReservaFin.isBefore(fin) || fechaHoraReservaFin.isEqual(fin))) ||
                            (fechaHoraReservaInicio.isBefore(inicio) && fechaHoraReservaFin.isBefore(fin) &&
                                    fechaHoraReservaFin.isAfter(inicio)) ||
                            (fechaHoraReservaInicio.isAfter(inicio) && fechaHoraReservaFin.isAfter(fin) &&
                                    fechaHoraReservaInicio.isBefore(fin)) ||
                            (fechaHoraReservaInicio.isBefore(inicio) && fechaHoraReservaFin.isAfter(fin))
            ) {
                throw new ConflictException("There is another reservation for that time");
            }
        }
    }

}
