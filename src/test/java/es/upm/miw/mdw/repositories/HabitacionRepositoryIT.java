package es.upm.miw.mdw.repositories;

import es.upm.miw.mdw.TestConfig;
import es.upm.miw.mdw.data_services.DBService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class HabitacionRepositoryIT {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private DBService dbService;

    @BeforeEach
    void setUpTests (){
        dbService.seedDB();
    }

    @Test
    void testReadHabitacion(){
        assertNotNull(habitacionRepository.findFirstByCodigoHabitacion("17"));
    }

    @Test
    void testFindRoomByLocation(){
        assertEquals(2, habitacionRepository.findByUbicacionIgnoreCase("valencia").size());
        assertEquals(1, habitacionRepository.findByUbicacionIgnoreCase("alicante").size());
        assertEquals(0, habitacionRepository.findByUbicacionIgnoreCase("madrid").size());
    }

    @AfterEach
    void clean (){
        dbService.deleteAll();
    }

}
