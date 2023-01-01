package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

// For logging portion:
// https://stackabuse.com/guide-to-logging-in-spring-boot/
// https://www.quickprogrammingtips.com/spring-boot/using-log4j2-with-spring-boot.html
// https://www.slf4j.org/manual.html#typical_usage

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@CrossOrigin
@RestController
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {
    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    //logging part
    private static final Logger logging = LoggerFactory.getLogger(HeaterController.class);
    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }


    //For getting heater all list
    @GetMapping
    public List<HeaterDto> findAll() {
        //logging part
        logging.info("Searching all heaters list");
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }


    ////For getting heater by using heaterId
    @GetMapping(path = "/{heaterId}")
    public HeaterDto findById(@PathVariable Long heaterId) {
        //logging part
        logging.info("Searching  heater using heaterId");
        return heaterDao.findById(heaterId).map(HeaterDto::new).orElse(null);
    }


    //For getting heater list by using roomId
    @GetMapping(path = "/room/{roomId}")
    public List<HeaterDto> findHeatersByRoomId(@PathVariable Long roomId) {
        return heaterDao.findHeaterByRoomId(roomId).stream().map(HeaterDto::new).collect(Collectors.toList());
    }


    // For switching the heaters
    @PutMapping(path = "/{heaterId}/switch")
    public HeaterDto switchStatus(@PathVariable Long heaterId) {
        Heater heater = heaterDao.findById(heaterId).orElseThrow(IllegalArgumentException::new);
        //logging part
        logging.info("Switched heater status");
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        return new HeaterDto(heater);
    }


    //For adding or updating a heater
    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {

        Room room = roomDao.getReferenceById(dto.getRoomId());
        Heater heater = null;

        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater( dto.getName(), dto.getHeaterStatus(),dto.getPower(),room));
        }

        else {
            heater = heaterDao.getReferenceById(dto.getId());
            heater.setHeaterStatus(dto.getHeaterStatus());
            heater.setPower(dto.getPower());
            heater.setName(dto.getName());
            heater.setRoom(room);

        }

        return new HeaterDto(heater);
    }


    //For deleting heater
    @DeleteMapping(path = "/{heaterId}")
    public void delete(@PathVariable Long heaterId) {
        //logging part
        logging.warn("Removed heater");
        heaterDao.deleteById(heaterId);
    }


}
