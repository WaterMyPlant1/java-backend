package com.lambdaschool.watermyplant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plants")
public class Plant extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantId;
    private String nickname;
    private String species;
    private String h2oFrequency;

    /**
     * The user to which this plant item is associated
     */
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "plants", allowSetters = true)
    private User user;

    public Plant()
    {
    }


    public Plant(
        String nickname,
        String species,
        String h2oFrequency,
        User user)
    {
        this.nickname = nickname;
        this.species = species;
        this.h2oFrequency = h2oFrequency;
        this.user = user;
    }

    public long getPlantId()
    {
        return plantId;
    }

    public void setPlantId(long plantId)
    {
        this.plantId = plantId;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getSpecies()
    {
        return species;
    }

    public void setSpecies(String species)
    {
        this.species = species;
    }

    public String getH2oFrequency()
    {
        return h2oFrequency;
    }

    public void setH2oFrequency(String h2oFrequency)
    {
        this.h2oFrequency = h2oFrequency;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
