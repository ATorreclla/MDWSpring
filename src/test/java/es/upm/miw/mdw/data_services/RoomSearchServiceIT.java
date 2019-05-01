package es.upm.miw.mdw.data_services;

import es.upm.miw.mdw.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class RoomSearchServiceIT {

    @Autowired
    private DBService dbService;

    @Autowired
    RoomSearchService roomSearchService;

    @BeforeEach
    void setUpTests (){
        dbService.seedDB();
    }

    @Test
    void testSearchAvailablesRooms(){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date checkIn = null;
        Date checkOut = null;
        try {
            checkIn = sd.parse("2020-01-01 00:00:00");
            checkOut = sd.parse("2020-01-01 02:00:00");
        }catch(Exception ex){}
        assertEquals(2, roomSearchService.findAvailablesRooms("valencia", checkIn, checkOut).size());
        assertEquals(1, roomSearchService.findAvailablesRooms("alicante", checkIn, checkOut).size());
        assertEquals(0, roomSearchService.findAvailablesRooms("madrid", checkIn, checkOut).size());
    }

    @Test
    void testcheckAvailabeRoomOnDates(){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date checkIn = null, checkOut = null;
        try {
            checkIn = sd.parse("2019-05-01 13:00:00");
            checkOut = sd.parse("2020-01-01 15:00:00");
        }catch(Exception ex){}
        assertFalse(roomSearchService.checkAvailabeRoomOnDates("1745645", checkIn, checkOut));
        assertTrue(roomSearchService.checkAvailabeRoomOnDates("17", checkIn, checkOut));
    }

    @AfterEach
    void clean (){
        dbService.deleteAll();
    }
}
