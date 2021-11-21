package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.model.*;
import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("api/buildings")
@Transactional
public class BuildingController {
    private final BuildingDao buildingdao;
    private final RoomDao roomDao;
    private final WindowDao windowdao;
    private final HeaterDao heaterdao;
    public BuildingController(BuildingDao buildingdao, WindowDao windowdao, HeaterDao heaterdao, RoomDao roomDao){
        this.buildingdao=buildingdao;
        this.windowdao=windowdao;
        this.heaterdao=heaterdao;
        this.roomDao=roomDao;
    }
    @GetMapping
    public List<BuildingDto> findAll(){
        return buildingdao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }
    @GetMapping(path="/{id}")
    public BuildingDto findById(@PathVariable Long id){
        return buildingdao.findById(id).map(BuildingDto::new).orElse(null);

    }
    @PostMapping(path = "/create")
    public BuildingDto create(@RequestBody BuildingDto dto) {

        Building building = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            building = buildingdao.save(new Building(dto.getName(), dto.getOutsideTemperature()));
        }
        else {
            building = buildingdao.getById(dto.getId());  // (9)

        }
        return new BuildingDto(building);
    }

    @DeleteMapping(path="/{id}/delete")
    public void delete(@PathVariable Long id) {
        List<Long> idRooms = roomDao.findIdByBuilding(id);
        for (Long idRoom:idRooms){
            windowdao.deleteByRoom(idRoom);
            heaterdao.deleteByRoom(idRoom);
        }
        roomDao.deleteByBuilding(id);
        buildingdao.deleteById(id);
    }
}
