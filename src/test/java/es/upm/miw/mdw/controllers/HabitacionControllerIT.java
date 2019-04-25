package es.upm.miw.mdw.controllers;

import es.upm.miw.mdw.TestConfig;
import es.upm.miw.mdw.exceptions.BadRequestException;
import es.upm.miw.mdw.exceptions.ConflictException;
import es.upm.miw.mdw.services.DBService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class HabitacionControllerIT {

    @Autowired
    private DBService dbService;

    @Autowired
    private HabitacionController habitacionController;

    @BeforeEach
    void setUpTests() {
        dbService.seedDB();
    }

    @Test
    void testValidateHabitacion() {
        String inicio = "2019-04-30 18:00";
        String fin = "2019-04-30 19:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        assertDoesNotThrow(() -> habitacionController.isValidTimeForHabitacion("17",
                LocalDateTime.parse("2019-04-29 18:00", formatter), LocalDateTime.parse("2019-04-29 19:00", formatter)));
        assertThrows(BadRequestException.class, () -> habitacionController.isValidTimeForHabitacion("1",
                LocalDateTime.parse("2019-04-29 18:00", formatter), LocalDateTime.parse("2019-04-29 19:00", formatter)));
        assertThrows(ConflictException.class, () -> habitacionController.isValidTimeForHabitacion("17",
                LocalDateTime.parse("2019-04-30 18:00", formatter), LocalDateTime.parse("2019-04-30 19:00", formatter)));
        assertThrows(ConflictException.class, () -> habitacionController.isValidTimeForHabitacion("17",
                LocalDateTime.parse("2019-04-30 15:00", formatter), LocalDateTime.parse("2019-04-30 19:00", formatter)));
        assertThrows(BadRequestException.class, () -> habitacionController.isValidTimeForHabitacion("1",
                LocalDateTime.parse("2019-04-30 17:00", formatter), LocalDateTime.parse("2019-04-30 22:00", formatter)));
        assertThrows(BadRequestException.class, () -> habitacionController.isValidTimeForHabitacion("1",
                LocalDateTime.parse("2019-04-30 20:00", formatter), LocalDateTime.parse("2019-04-30 22:00", formatter)));
    }

    @AfterEach
    void clean() {
        dbService.deleteAll();
    }

}
