package es.upm.miw.mdw.rest_controllers;

import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.dtos.ReservaDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("permitAll()")
@RestController
@RequestMapping(BookingResource.BOOKING)
public class BookingResource {

    public static final String BOOKING = "/booking";

    public static final String SAVE = "/room";

    @PostMapping(value = SAVE)
    public ReservaDto save(@RequestBody ReservaDto dto){
        Reserva reserva = new Reserva();

        return dto;
    }
}
