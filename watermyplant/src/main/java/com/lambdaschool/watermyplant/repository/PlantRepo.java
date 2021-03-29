package com.lambdaschool.watermyplant.repository;

import com.lambdaschool.watermyplant.models.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PlantRepo extends CrudRepository<Plant, Long>
{
    Plant findByNickname(String nickname);

    /*
    find all plants with similar h2o frequency
     */
    List<Plant> findByH2oFrequency(Date h2ofrequency);

    /*
    find all plants with the same species
     */
    List<Plant> findBySpecies(String species);
}
