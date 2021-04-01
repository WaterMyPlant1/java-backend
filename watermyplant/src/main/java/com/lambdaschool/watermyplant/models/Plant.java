package com.lambdaschool.watermyplant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "plants")
public class Plant extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantId;

    @NotNull
    @Column(unique = false)
    private String nickname;

    @NotNull
    @Column(unique = false)
    private String species;

    private Integer h2oFrequency;

    private String img;

    private long baseDate;

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
        Integer h2oFrequency,
        String img,
        long baseDate,
        User user)
    {
        this.nickname = nickname;
        this.species = species;
        this.h2oFrequency = h2oFrequency;
        this.img = img;
        this.baseDate = baseDate;
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

    public Integer getH2oFrequency()
    {
        return h2oFrequency;
    }

    public void setH2oFrequency(Integer h2oFrequency)
    {
        this.h2oFrequency = h2oFrequency;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getBaseDate()
    {
        return baseDate;
    }

    public void setBaseDate(long baseDate)
    {
        this.baseDate = baseDate;
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
