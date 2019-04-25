package es.upm.miw.mdw.controllers;

import es.upm.miw.mdw.repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public void isValidTimeForHabitacion(String codigoHabitacion, LocalDateTime fechaHoraReservaInicio, LocalDateTime fechaHoraReservaFin) {

    }

}
