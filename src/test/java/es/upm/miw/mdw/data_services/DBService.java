package es.upm.miw.mdw.data_services;

import es.upm.miw.mdw.documents.Habitacion;
import es.upm.miw.mdw.documents.Reserva;
import es.upm.miw.mdw.repositories.HabitacionRepository;
import es.upm.miw.mdw.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        habitacion2.setCodigoHabitacion("1745645");
        habitacion2.setNombreHotel("TestNombre");
        habitacion2.setUbicacion("Valencia");

        Habitacion habitacion3 = new Habitacion();
        habitacion3.setCodigoHabitacion("1734563456");
        habitacion3.setNombreHotel("TestNombre");
        habitacion3.setUbicacion("Valencia");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Reserva reserva1 = new Reserva();
        String inicio = "2019-05-01 12:00";
        String fin = "2019-05-01 14:00";
        reserva1.setCodigoHabitacion(habitacion2.getCodigoHabitacion());
        reserva1.setFechaHoraReservaInicio(LocalDateTime.parse(inicio, formatter));
        reserva1.setFechaHoraReservaFin(LocalDateTime.parse(fin,formatter));

        Reserva reserva2 = new Reserva();
        inicio = "2019-04-15 18:00";
        fin = "2019-04-15 21:00";
        reserva2.setFechaHoraReservaInicio(LocalDateTime.parse(inicio, formatter));
        reserva2.setFechaHoraReservaFin(LocalDateTime.parse(fin,formatter));

        Reserva reserva3 = new Reserva();
        reserva3.setFechaHoraReservaInicio(LocalDateTime.of(2019, Month.MAY, 1, 00, 00, 00));
        reserva3.setFechaHoraReservaFin(LocalDateTime.of(2019, Month.MAY, 2, 00, 00, 00));

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