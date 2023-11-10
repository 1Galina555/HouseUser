package com.example.houseuser.controller;

import com.example.houseuser.JWT.JWTToken;
import com.example.houseuser.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterController {
    private final JWTToken jwtToken;

    public MasterController(JWTToken jwtToken) {
        this.jwtToken=jwtToken;
    }

    @PostMapping("/master")
    public String master(@RequestBody User user) {
        return jwtToken.generate(user.getId().toString());
    }
}
