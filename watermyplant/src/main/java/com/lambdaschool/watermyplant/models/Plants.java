package com.lambdaschool.watermyplant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plants")
public class Plants extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantId;
    private String nickname;
    private String species;
    private Date h2oFrequency;

    /**
     * The user to which this plant item is associated
     */
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "plant", allowSetters = true)
    private User user;

    public Plants()
    {
    }

    public Plants(
        String nickname,
        String species,
        Date h2oFrequency)
    {
        this.nickname = nickname;
        this.species = species;
        this.h2oFrequency = h2oFrequency;
    }

    public Plants(
        long plantId,
        String nickname,
        String species,
        Date h2oFrequency,
        User user)
    {
        this.plantId = plantId;
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

    public Date getH2oFrequency()
    {
        return h2oFrequency;
    }

    public void setH2oFrequency(Date h2oFrequency)
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
