package es.upm.miw.mdw.services;

import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.repositories.HabitacionRepository;
import es.upm.miw.mdw.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
