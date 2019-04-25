package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.TestConfig;
import es.upm.miw.mdw.services.DBService;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ReservaRepositoryIT {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private DBService dbService;

    @BeforeEach
    void setUpTests (){
        dbService.seedDB();
    }

    @Test
    void testfindByFechaInicioFechaFin(){
        System.out.println(reservaRepository.findMoreThanFechaInicio(LocalDateTime.now()));
        assertNotNull(reservaRepository.findMoreThanFechaInicio(LocalDateTime.now()));
    }

    @AfterEach
    void clean (){
        dbService.deleteAll();
    }

}