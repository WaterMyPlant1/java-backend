package com.lambdaschool.watermyplant.services;

import com.lambdaschool.watermyplant.exceptions.ResourceNotFoundException;
import com.lambdaschool.watermyplant.models.Plant;
import com.lambdaschool.watermyplant.models.User;
import com.lambdaschool.watermyplant.repository.PlantRepository;
import com.lambdaschool.watermyplant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "plantservice")
public class PlantServiceImpl implements PlantService
{
    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Plant> findPlantByUserId(long userid)
    {
        List<Plant> plantList = plantRepository.findPlantByUser_userid(userid);

        return plantList;
    }

    @Transactional
    @Override
    public Plant save(Plant plant)
    {
        Plant newPlant = new Plant();

        if(plant.getPlantId() != 0)
        {
            plantRepository.findById(plant.getPlantId())
                .orElseThrow(() -> new ResourceNotFoundException("Plant id " + plant.getPlantId() + " not found"));
            newPlant.setPlantId(plant.getPlantId());
        }

        newPlant.setNickname(plant.getNickname());
        newPlant.setSpecies(plant.getSpecies());
        newPlant.setH2oFrequency(plant.getH2oFrequency());
        newPlant.setImg(plant.getImg());
        newPlant.setBaseDate(plant.getBaseDate());

        User newUser = userRepository.findById(plant.getUser().getUserid())
            .orElseThrow(() -> new ResourceNotFoundException("User id " + plant.getUser().getUserid() + " not found"));
        newPlant.setUser(newUser);

        return plantRepository.save(newPlant);
    }

    @Transactional
    @Override
    public Plant update(
        Plant plant,
        long id)
    {
        Plant currentPlant = plantRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Plant " + id + " not found!"));

        if(plant.getNickname() != null)
        {
            currentPlant.setNickname(plant.getNickname());
        }

        if(plant.getSpecies() != null)
        {
            currentPlant.setSpecies(plant.getSpecies());
        }

        if(plant.getH2oFrequency() != null)
        {
            currentPlant.setH2oFrequency(plant.getH2oFrequency());
        }

        if(plant.getImg() != null)
        {
            currentPlant.setImg(plant.getImg());
        }

        if(plant.getBaseDate() != 0)
        {
            currentPlant.setBaseDate(plant.getBaseDate());
        }

        return plantRepository.save(currentPlant);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if(plantRepository.findById(id).isPresent())
        {
            plantRepository.deleteById(id);
        }
        else
        {
            throw new ResourceNotFoundException("Plant id " + id + " not found");
        }
    }
}
