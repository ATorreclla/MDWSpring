package es.upm.miw.mdw.rest_controllers;

import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.controllers.HabitacionController;
import es.upm.miw.mdw.dtos.ReservaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@PreAuthorize("permitAll()")
@RestController
@RequestMapping(BookingResource.BOOKING)
public class BookingResource {

    public static final String BOOKING = "/booking";

    public static final String SAVE = "/room";

    public static final String VALIDATION = "/{codigoHabitacion}";

    @Autowired
    HabitacionController habitacionController;

    @PostMapping(value = SAVE)
    public ReservaDto save(@RequestBody ReservaDto dto){
        Reserva reserva = new Reserva();
        return dto;
    }

}
