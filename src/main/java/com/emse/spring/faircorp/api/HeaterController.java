package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("api/heaters")
@Transactional
public class HeaterController {
    private final HeaterDao heaterdao;
    private final RoomDao roomdao;
    public HeaterController(HeaterDao heaterdao, RoomDao roomdao){
        this.roomdao=roomdao;
        this.heaterdao=heaterdao;
    }
    @GetMapping
    public List<HeaterDto> findAll(){
        return  heaterdao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());

    }
    @GetMapping(path="/{id}")
    public HeaterDto findById(@PathVariable Long id){
        return heaterdao.findById(id).map(HeaterDto::new).orElse(null);

    }
    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterdao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setStatus(heater.getStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        return new HeaterDto(heater);
    }
    @PostMapping(path = "/create")
    public HeaterDto create(@RequestBody HeaterDto dto) {
        Room room = roomdao.getById(dto.getRoomId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterdao.save(new Heater( dto.getName(),room, dto.getStatus(),dto.getPower()));
        }
        else {
            heater = heaterdao.getById(dto.getId());  // (9)
            heater.setStatus(dto.getStatus());
        }
        return new HeaterDto(heater);
    }
    @DeleteMapping(path = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        heaterdao.deleteById(id);
    }
}
