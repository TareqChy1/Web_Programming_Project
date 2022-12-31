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


/**
 * Controllers are the link between the web http clients (browsers, mobiles) and application.
 * Controllers lightweight and call other components in application to perform actual work .
 * WindowController is also a Controller. Behaves as a Controller.
 * @CrossOrigin enables cross-origin resource sharing only for this specific method.
 * @RestController used to create RESTful web services using Spring MVC
 * @RequestMapping used to map web requests onto specific handler classes and/or handler methods.
 * @Transactional used to specify the semantics of the transactions on a method.
 *
 */
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

    /**
     * This method used for getting all window list.
     * @GetMapping used for indicating that the following method will respond to a GET request.
     * This method will return a window list.
     * @return returns all window list.
     */

    //For getting all window list
    @GetMapping
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());
    }

    /**
     * This method used for getting window by using windowId.
     * @param windowId used for getting window.
     * @return returns window.
     */

    //For getting window by using windowId
    @GetMapping(path = "/{windowId}")
    public WindowDto findById(@PathVariable Long windowId) {
        return windowDao.findById(windowId).map(WindowDto::new).orElse(null);
    }

    /**
     * This method is used for getting window by using roomId.
     * <p>
     * @GetMapping indicates that the following method will respond to a GET request.
     * This method will return a window list.
     * Transform entities Window in WindowDto.
     * </p>
     * @param roomId used for getting window list.
     * @return returns window list.
     */

    //For getting window by using roomId
    @GetMapping(path = "/room/{roomId}")
    public List<WindowDto> findWindowsByRoomId(@PathVariable Long roomId) {
        return windowDao.findWindowByRoomId(roomId).stream().map(WindowDto::new).collect(Collectors.toList());
    }

    /**
     * This method used for switching the windows.
     * @PutMapping used for handling the incoming put request from the client side.
     * @param windowId used for switching the windows.
     * @return returns the status of the windows
     */

    // For switching the windows
    @PutMapping(path = "/{windowId}/switch")
    public WindowDto switchStatus(@PathVariable Long windowId) {
        Window window = windowDao.findById(windowId).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new WindowDto(window);
    }

    /**
     * This method is used for adding or updating a window.
     * @PostMapping used for mapping HTTP POST requests onto specific handler methods.
     * @RequestBody allows us to retrieve the request's body.
     * @return returns created or updated  window.
     */
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

    /**
     * This method is used for deleting the window using windowId.
     * @DeleteMapping specifies that HTTP DELETE requests to  /windows/{windowId} are mapped to delete() method.
     *  @PathVariable used to bind the path variable “windowId” to the method parameter Long windowId.
     */
    //For deleting the window
    @DeleteMapping(path = "/{windowId}")
    public void delete(@PathVariable Long windowId) {
        windowDao.deleteById(windowId);
    }


}