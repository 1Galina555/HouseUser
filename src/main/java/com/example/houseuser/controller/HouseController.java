package com.example.houseuser.controller;

import com.example.houseuser.model.House;
import com.example.houseuser.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/house")
public class HouseController {
    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/{id}")
    public House getHouseById(@PathVariable Long id) {
        return houseService.getHouseById(id);
    }

    @PostMapping("/")
    public void createHouse(@RequestBody House house) {
        houseService.createHouse(house);
    }

    @PutMapping("/{id}")
    public void updateHouse(@PathVariable Long id, @RequestBody House house) {
        houseService.updateHouse(id, house);
    }

    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
    }

}
