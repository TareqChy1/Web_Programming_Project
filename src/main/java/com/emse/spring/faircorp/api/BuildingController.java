package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingCmdDto;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.model.Building;
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
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao;
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    //logging part
    private static final Logger logging = LoggerFactory.getLogger(BuildingController.class);

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }


    // For getting building list
    @GetMapping
    public List<BuildingCmdDto> findAll() {
        //logging part
        logging.info("Searching all buildings list");
        return buildingDao.findAll().stream().map(BuildingCmdDto::new).collect(Collectors.toList());
    }


    //For getting building by using buildingId
    @GetMapping(path = "/{buildingId}")
    public BuildingCmdDto findById(@PathVariable Long buildingId) {
        //logging part
        logging.info("Searching  room using buildingId");
        return buildingDao.findById(buildingId).map(BuildingCmdDto::new).orElse(null);
    }


    //For adding or updating a building
    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {

        Building building = null;

        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName(),dto.getAddress(),dto.getOutsideTemperature()));
        }

        else {
            building = buildingDao.getReferenceById(dto.getId());
            building.setName(dto.getName());
            building.setAddress(dto.getAddress());
            building.setOutsideTemperature(dto.getOutsideTemperature());

        }

        return new BuildingDto(building);
    }


    //For deleting building
    @DeleteMapping(path = "/{buildingId}")
    public void delete(@PathVariable Long buildingId) {
        //logging part
        logging.warn("Removed building");
        buildingDao.deleteById(buildingId);
    }


}
