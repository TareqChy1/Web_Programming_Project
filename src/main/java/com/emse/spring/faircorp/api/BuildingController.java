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



@CrossOrigin
@RestController
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao;
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }


    // For getting building list
    @GetMapping
    public List<BuildingCmdDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingCmdDto::new).collect(Collectors.toList());
    }


    //For getting building by using buildingId
    @GetMapping(path = "/{buildingId}")
    public BuildingCmdDto findById(@PathVariable Long buildingId) {
        return buildingDao.findById(buildingId).map(BuildingCmdDto::new).orElse(null);
    }


    //For adding or updating a building
    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {

        Building building = null;

        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName(),dto.getOutsideTemperature()));
        }

        else {
            building = buildingDao.getReferenceById(dto.getId());
            building.setName(dto.getName());
            building.setOutsideTemperature(dto.getOutsideTemperature());

        }

        return new BuildingDto(building);
    }


    //For deleting building
    @DeleteMapping(path = "/{buildingId}")
    public void delete(@PathVariable Long buildingId) {
        buildingDao.deleteById(buildingId);
    }


}
