package es.upm.miw.mdw.services;

import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.repositories.HabitacionRepository;
import es.upm.miw.mdw.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;

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
        habitacion.setUbicacion("Alicante");

        Habitacion habitacion2 = new Habitacion();
        habitacion.setCodigoHabitacion("1745645");
        habitacion.setNombreHotel("TestNombre");
        habitacion.setUbicacion("Valencia");

        Habitacion habitacion3 = new Habitacion();
        habitacion.setCodigoHabitacion("1734563456");
        habitacion.setNombreHotel("TestNombre");
        habitacion.setUbicacion("Valencia");

        Reserva reserva1 = new Reserva();
        reserva1.setFechaHoraReservaInicio(LocalDateTime.of(2019, Month.APRIL, 15, 00, 00, 00));
        reserva1.setFechaHoraReservaFin(LocalDateTime.of(2019, Month.APRIL, 25, 00, 00, 00));

        Reserva reserva2 = new Reserva();
        reserva1.setFechaHoraReservaInicio(LocalDateTime.of(2019, Month.APRIL, 25, 00, 00, 00));
        reserva1.setFechaHoraReservaFin(LocalDateTime.of(2019, Month.MAY, 1, 00, 00, 00));

        Reserva reserva3 = new Reserva();
        reserva1.setFechaHoraReservaInicio(LocalDateTime.of(2019, Month.MAY, 1, 00, 00, 00));
        reserva1.setFechaHoraReservaFin(LocalDateTime.of(2019, Month.MAY, 2, 00, 00, 00));


        habitacion.addReserva(reserva1);
        habitacion.addReserva(reserva2);
        habitacion.addReserva(reserva3);
        habitacion2.addReserva(reserva1);
        habitacion2.addReserva(reserva2);
        habitacion2.addReserva(reserva3);
        habitacion3.addReserva(reserva1);
        habitacion3.addReserva(reserva2);
        habitacion3.addReserva(reserva3);

        reservaRepository.save(reserva1);
        reservaRepository.save(reserva2);
        reservaRepository.save(reserva3);

        habitacionRepository.save(habitacion);
        habitacionRepository.save(habitacion2);
        habitacionRepository.save(habitacion3);
    }

    public void deleteAll(){
        habitacionRepository.deleteAll();
        reservaRepository.deleteAll();
    }

}
