package com.univ.teamms.Models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;


@ApiModel(description = "Details about a football team")
public class Team {

    @ApiModelProperty(notes = "Unique identifier for the team")
    private String id;

    @ApiModelProperty(notes = "Name of the team")
    private String name;



    // Constructors

    public Team() {
        this.id = generateUniqueId();
    }

    public Team(String name) {
        this.id = generateUniqueId();
        this.name = name;
    }

    // Getter and Setter methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Helper method to generate a unique ID (for simplicity, you can use a counter)
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    // toString method for debugging or logging

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
