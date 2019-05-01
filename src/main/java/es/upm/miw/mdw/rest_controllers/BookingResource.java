package es.upm.miw.mdw.rest_controllers;

import es.upm.miw.mdw.data_services.RoomSearchService;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.controllers.HabitacionController;
import es.upm.miw.mdw.dtos.ReservaDto;
import es.upm.miw.mdw.exceptions.ConflictException;
import es.upm.miw.mdw.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("permitAll()")
@RestController
@RequestMapping(BookingResource.BOOKING)
public class BookingResource {

    public static final String BOOKING = "/booking";

    public static final String SAVE = "/room";

    public static final String VALIDATION = "/{codigoHabitacion}";

    @Autowired
    RoomSearchService roomSearchService;

    @Autowired
    ReservaRepository reservaRepository;

    @PostMapping(value = SAVE)
    public ReservaDto save(@RequestBody ReservaDto dto){
        if(roomSearchService.checkAvailabeRoomOnDates(dto.getCodigoHabitacion(),
                ReservaDto.convertToDate(dto.getFechaInicio()), ReservaDto.convertToDate(dto.getFechaFin()))){
            Reserva reserva = reservaRepository.save(dto.toDocument());
            return new ReservaDto(reserva);
        }
        throw new ConflictException("Hotel room unavailable.");
    }

}
