package com.lambdaschool.watermyplant.controllers;

import com.lambdaschool.watermyplant.models.Plant;
import com.lambdaschool.watermyplant.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController
{

    @Autowired
    PlantService plantService;

    @GetMapping(value = "/{userId}",
        produces = {"application/json"})
    public ResponseEntity<?> getAllPlantsByUserId(
        @PathVariable long userId
    )
    {
        List<Plant> plantList = plantService.findPlantByUserId(userId);
        return new ResponseEntity<>(plantList,
            HttpStatus.OK);
    }

    @PatchMapping(value = "/plant/{plantId}")
    public ResponseEntity<?> editPlantById(@PathVariable long plantId, @RequestBody Plant editPlant)
    {
        plantService.update(editPlant, plantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/plant/{plantId}")
    public ResponseEntity<?> deletePlantById(@PathVariable long plantId)
    {
        plantService.delete(plantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
