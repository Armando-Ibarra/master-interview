package org.example.company.api.spotify.controller;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.example.company.api.spotify.request.SpotifyRequest;
import org.example.company.api.spotify.response.SongPropertiesResponse;
import org.example.company.api.spotify.service.SpotifyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify")
@AllArgsConstructor
public class SpotifyController {

    @Setter
    private SpotifyService spotifyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SongPropertiesResponse> readProperties(@RequestBody SpotifyRequest spotifyRequest) {
        return spotifyService.filterProperties(spotifyRequest);
    }


}
