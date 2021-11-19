package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("api/rooms")
@Transactional
public class RoomController {
    private final RoomDao roomdao;
    private final BuildingDao buildingDao;
    private final WindowDao windowdao;
    private final HeaterDao heaterdao;
    public RoomController(RoomDao roomdao, WindowDao windowdao, HeaterDao heaterdao, BuildingDao buildingDao){
        this.roomdao=roomdao;
        this.windowdao=windowdao;
        this.heaterdao=heaterdao;
        this.buildingDao=buildingDao;
    }
    @GetMapping
    public List<RoomDto> findAll(){
        return roomdao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }
    @GetMapping(path="/{id}")
    public RoomDto findById(@PathVariable Long id){
        return roomdao.findById(id).map(RoomDto::new).orElse(null);

    }
    @PostMapping // (8)
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        Building building = buildingDao.getById(dto.getBuildingId());

        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomdao.save(new Room(dto.getFloor(),dto.getName(),building));
        }
        else {
            room = roomdao.getById(dto.getId());  // (9)
        }
        return new RoomDto(room);
    }
    @PutMapping(path="{id}/switch_Windows")
    public List<WindowDto> switchWindowsStatus(@PathVariable Long id){
        List<Window> windows = windowdao.findByRoom(id);
        for (Window window : windows){
            window.setWindowStatus(window.getWindowStatus() == WindowsStatus.OPEN ? WindowsStatus.CLOSED: WindowsStatus.OPEN);
        }
        return windows.stream().map(WindowDto::new).collect(Collectors.toList());
    }
    @PutMapping(path="{id}/switch_Heaters")
    public List<HeaterDto> switchHeatersStatus(@PathVariable Long id){
        List<Heater> heaters = heaterdao.findByRoom(id);
        for (Heater heater : heaters){
            heater.setStatus(heater.getStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        }
        return heaters.stream().map(HeaterDto::new).collect(Collectors.toList());
    }
    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable Long id) {
        windowdao.deleteByRoom(id);
        heaterdao.deleteByRoom(id);
        roomdao.deleteById(id);
    }
}
