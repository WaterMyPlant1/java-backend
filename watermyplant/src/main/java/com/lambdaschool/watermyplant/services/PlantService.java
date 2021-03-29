package com.lambdaschool.watermyplant.services;

import com.lambdaschool.watermyplant.models.Plant;

import java.util.List;

public interface PlantService
{
    List<Plant> findPlantByUserId(long userid);

    Plant save(Plant plant);

    Plant update(Plant plant, long id);

    void delete(long id);
}
