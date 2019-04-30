package es.upm.miw.mdw.controllers;

import es.upm.miw.mdw.dtos.HabitacionDTO;
import es.upm.miw.mdw.dtos.HabitacionQueryDTO;
import es.upm.miw.mdw.exceptions.BadRequestException;
import es.upm.miw.mdw.repositories.ReservaRepository;
import es.upm.miw.mdw.data_services.RoomSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HabitacionController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RoomSearchService roomSearchService;


    public List<HabitacionDTO> queryHabitaciones(HabitacionQueryDTO query) {
        if (query.getFechaHoraReservaInicio() == null || query.getFechaHoraReservaFin() == null || query.getUbicacion() == null) {
            throw new BadRequestException("Query fields cannot be null");
        }
        Date checkIn = Date.from(query.getFechaHoraReservaInicio().atZone(ZoneId.systemDefault()).toInstant());
        Date checkOut = Date.from(query.getFechaHoraReservaFin().atZone(ZoneId.systemDefault()).toInstant());
        return this.roomSearchService.findAvailablesRooms(query.getUbicacion(), checkIn, checkOut).stream()
                .map(habitacion -> new HabitacionDTO(habitacion))
                .collect(Collectors.toList());
    }
}
