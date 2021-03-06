package com.lambdaschool.watermyplant.repository;

import com.lambdaschool.watermyplant.models.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant, Long>
{
    List<Plant> findPlantByUser_userid(long userid);
}
