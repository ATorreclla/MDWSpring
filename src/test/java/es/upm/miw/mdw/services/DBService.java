package es.upm.miw.mdw.services;

import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.repositories.HabitacionRepository;
import es.upm.miw.mdw.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DBService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public void seedDB (){
        Habitacion habitacion = new Habitacion();
        habitacion.setCodigoHabitacion("17");
        habitacion.setNombreHotel("TestNombre");
        Reserva reserva1 = new Reserva();
        Reserva reserva2 = new Reserva();
        String inicio = "2019-04-30 18:00";
        String fin = "2019-04-30 21:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        reserva1.setFechaHoraReservaInicio(LocalDateTime.parse(inicio, formatter));
        reserva1.setFechaHoraReservaFin(LocalDateTime.parse(fin,formatter));
        habitacion.addReserva(reserva1);
        habitacion.addReserva(reserva2);
        reservaRepository.save(reserva1);
        reservaRepository.save(reserva2);
        habitacionRepository.save(habitacion);
    }

    public void deleteAll(){
        habitacionRepository.deleteAll();
        reservaRepository.deleteAll();
    }

}
