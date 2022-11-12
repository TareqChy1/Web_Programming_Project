package com.emse.spring.faircorp.api;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;



@CrossOrigin
@RestController
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;


    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }


    //For getting all window list
    @GetMapping
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());
    }


    //For getting window by using windowId
    @GetMapping(path = "/{windowId}")
    public WindowDto findById(@PathVariable Long windowId) {
        return windowDao.findById(windowId).map(WindowDto::new).orElse(null);
    }


    //For getting window by using roomId
    @GetMapping(path = "/room/{roomId}")
    public List<WindowDto> findWindowsByRoomId(@PathVariable Long roomId) {
        return windowDao.findWindowByRoomId(roomId).stream().map(WindowDto::new).collect(Collectors.toList());
    }


    // For switching the windows
    @PutMapping(path = "/{windowId}/switch")
    public WindowDto switchStatus(@PathVariable Long windowId) {
        Window window = windowDao.findById(windowId).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new WindowDto(window);
    }


    //For adding or updating a window
    @PostMapping
    public WindowDto create(@RequestBody WindowDto dto) {

        Room room = roomDao.getReferenceById(dto.getRoomId());
        Window window = null;

        if (dto.getId() == null) {
            window = windowDao.save(new Window( dto.getName(), dto.getWindowStatus(), room));
        }

        else {
            window = windowDao.getReferenceById(dto.getId());
            window.setWindowStatus(dto.getWindowStatus());
            window.setName(dto.getName());
            window.setRoom(room);
        }

        return new WindowDto(window);
    }


    //For deleting the window
    @DeleteMapping(path = "/{windowId}")
    public void delete(@PathVariable Long windowId) {
        windowDao.deleteById(windowId);
    }


}