package es.upm.miw.mdw.data_services;

import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.repositories.HabitacionRepository;
import es.upm.miw.mdw.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoomSearchService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> findAvailablesRooms(String location, Date checkIn, Date checkOut){
        Set<String> idRooms =
                reservaRepository.findBookingsBetweenDates(checkIn, checkOut).stream()
                        .map(Reserva::getCodigoHabitacion)
                        .collect(Collectors.toSet());
        return idRooms.isEmpty()?habitacionRepository.findByUbicacionIgnoreCase(location):
                habitacionRepository.findByUbicacionIgnoreCase(location).stream()
                        .filter(room -> !idRooms.contains(room.getCodigoHabitacion()))
                        .collect(Collectors.toList());
    }

    public boolean checkAvailabeRoomOnDates(String idRoom, Date checkIn, Date checkOut){
        Optional<Habitacion> room = habitacionRepository.findById(idRoom);
        if(room.isPresent())
            return reservaRepository.findBookingsOnRoomBetweenDates(idRoom, checkIn, checkOut).size()==0;
        return false;
    }
}
