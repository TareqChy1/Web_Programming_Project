package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Window;
import java.util.List;


public interface WindowDaoCustom {

    void deleteAllWindowsByRoom(Long id);
    List<Window> findWindowByRoomId(Long Id);
    List<Window> findRoomOpenWindows(Long id);

}