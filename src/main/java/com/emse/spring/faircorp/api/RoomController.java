package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.RoomCmdDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;



@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final BuildingDao buildingDao;
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;


    public RoomController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }


    //For getting all room list
    @GetMapping
    public List<RoomCmdDto> findAll() {
        return roomDao.findAll().stream().map(RoomCmdDto::new).collect(Collectors.toList());
    }


    //For getting room by using roomId
    @GetMapping(path = "/{roomId}")
    public RoomCmdDto findById(@PathVariable Long roomId) {
        return roomDao.findById(roomId).map(RoomCmdDto::new).orElse(null);
    }


    //For getting room list by using buildingId
    @GetMapping(path = "/building/{buildingId}")
    public List<RoomDto> findByBuildingId(@PathVariable Long buildingId) {
        return roomDao.findByBuildingId(buildingId).stream().map(RoomDto::new).collect(Collectors.toList());
    }


    // For switching the windows
    @PutMapping(path = "/{roomId}/switchWindows")
    public RoomDto switchWindows(@PathVariable Long roomId) {
        Room room = roomDao.getReferenceById(roomId);
        room.getWindows().forEach(window ->window.
                setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN));
        return new RoomDto(room);
    }


    // For switching the heaters
    @PutMapping(path = "/{roomId}/switchHeaters")
    public RoomDto switchHeaters(@PathVariable Long roomId) {
        Room room = roomDao.getReferenceById(roomId);
        room.getHeaters().forEach(heater ->heater.
                setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON));
        return new RoomDto(room);
    }


    //add or update a room
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {

        Building building = buildingDao.getReferenceById(dto.getBuildingId());
        Room room = null;

        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(),dto.getName(),dto.getCurrentTemperature(),dto.getTargetTemperature(),building));
        }

        else {
            room = roomDao.getReferenceById(dto.getId());
            room.setFloor(dto.getFloor());
            room.setName(dto.getName());
            room.setCurrentTemperature(dto.getCurrentTemperature());
            room.setTargetTemperature(dto.getTargetTemperature());
        }

        return new RoomDto(room);

    }


    //For deleting the room
    @DeleteMapping(path = "/{roomId}")
    public void delete(@PathVariable Long roomId) {
        roomDao.deleteById(roomId);
    }


}
