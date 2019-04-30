package es.upm.miw.mdw.rest_controllers;

import es.upm.miw.mdw.controllers.HabitacionController;
import es.upm.miw.mdw.dtos.HabitacionDTO;
import es.upm.miw.mdw.dtos.HabitacionQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HabitacionResource.HABITACIONES)
public class HabitacionResource {

    public static final String HABITACIONES = "/habitaciones";

    @Autowired
    private HabitacionController habitacionController;

    @PostMapping
    public List<HabitacionDTO> queryHabitaciones(@RequestBody HabitacionQueryDTO habitacionQueryDTO) {
        return this.habitacionController.queryHabitaciones(habitacionQueryDTO);
    }

}
