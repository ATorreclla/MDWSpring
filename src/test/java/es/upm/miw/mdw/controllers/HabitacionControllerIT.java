package es.upm.miw.mdw.controllers;

import es.upm.miw.mdw.TestConfig;
import es.upm.miw.mdw.services.DBService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class HabitacionControllerIT {

    @Autowired
    private DBService dbService;

    @Autowired
    private HabitacionController habitacionController;

    @BeforeEach
    void setUpTests (){
        dbService.seedDB();
    }

    @Test
    void testValidateHabitacion (){

    }

    @AfterEach
    void clean (){
        dbService.deleteAll();
    }

}
