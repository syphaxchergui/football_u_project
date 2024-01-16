package com.univ.teamms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Service
public class PlayerService {

    @Autowired
    RestTemplate restTemplate;

    public List<?> getPlayersForTeam(String team) {
        return restTemplate.getForObject(
                "http://localhost:8080/players/team/{teamName}", List.class, team);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
