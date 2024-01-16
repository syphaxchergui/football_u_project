package com.univ.playerms.Models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Details about a football player")
public class Player {

    @ApiModelProperty(notes = "Unique identifier for the player")
    private String id;

    @ApiModelProperty(notes = "Name of the player")
    private String name;

    @ApiModelProperty(notes = "Age of the player")
    private int age;

    @ApiModelProperty(notes = "Position of the player")
    private Position position;

    @ApiModelProperty(notes = "Team of the player")
    private String team; // team id

    // Constructors

    public Player() {
    }

    public Player(String name, int age, Position position, String team) {
        this.id = generateUniqueId();
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    // Helper method to generate a unique ID (for simplicity, you can use a counter)
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    // toString method for debugging or logging

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
