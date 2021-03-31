package com.lambdaschool.watermyplant.controllers;

import com.lambdaschool.watermyplant.models.Plant;
import com.lambdaschool.watermyplant.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController
{

    @Autowired
    PlantService plantService;

//    get list of plants by id
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

//    creating new plant
    @PostMapping(value = "/newplant", consumes = "application/json")
    public ResponseEntity<?> createNewPlant(@Valid @RequestBody Plant newplant) throws URISyntaxException
    {
        newplant.setPlantId(0);
        newplant = plantService.save(newplant);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{plantid}")
            .buildAndExpand(newplant.getPlantId())
            .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(newplant, responseHeaders,
            HttpStatus.OK);
    }

//    edit plant by id
    @PatchMapping(value = "/plant/{plantId}", consumes = "application/json")
    public ResponseEntity<?> editPlantById(@PathVariable long plantId, @RequestBody Plant editPlant)
    {
        plantService.update(editPlant, plantId);
        return new ResponseEntity<>(editPlant,HttpStatus.OK);
    }

//    delete plant by id
    @DeleteMapping("/plant/{plantId}")
    public ResponseEntity<?> deletePlantById(@PathVariable long plantId)
    {
        plantService.delete(plantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
