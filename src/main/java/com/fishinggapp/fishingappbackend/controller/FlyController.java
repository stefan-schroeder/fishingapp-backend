package com.fishinggapp.fishingappbackend.controller;

import com.fishinggapp.fishingappbackend.repository.FlyRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlyController {
    FlyRepository flyRepository = new FlyRepository();

}
