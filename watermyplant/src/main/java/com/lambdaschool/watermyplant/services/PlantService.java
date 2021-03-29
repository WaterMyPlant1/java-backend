package com.lambdaschool.watermyplant.services;

import com.lambdaschool.watermyplant.models.Plant;

import java.util.List;

public interface PlantService
{
    List<Plant> findAll();

    List<Plant> findAllByUserId(long userId);

    Plant findPlantById(long plantId);
}
