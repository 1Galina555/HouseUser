package com.example.houseuser.service;

import com.example.houseuser.model.House;
import com.example.houseuser.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseService {

        @Autowired
        private HouseRepository houseRepository;

        public List<House> getAllHouses() {
            return houseRepository.findAll();
        }

        public House getHouseById(Long id) {
            return houseRepository.findById(id).orElseThrow(() -> new RuntimeException("house does not exist"));
        }

        public void createHouse(House house) {
            houseRepository.save(house);
        }

        public void updateHouse(Long id, House house) {
            House newHouse = houseRepository.findById(id).orElseThrow(() -> new RuntimeException("house does not exist"));
            newHouse.setAdress(house.getAdress());
           newHouse.setMaster(house.getMaster());
            houseRepository.save(newHouse);
        }

        public void deleteHouse(Long id) {
            houseRepository.deleteById(id);
        }

    }
