package org.example.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.company.api.spotify.request.SpotifyRequest;
import org.example.company.api.spotify.response.SongPropertiesResponse;
import org.example.company.api.spotify.service.SpotifyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringBootTest
class SpotifyServiceTest {

    @Autowired
    private SpotifyService spotifyService;

    @Value("classpath:data/playlist.json")
    private Resource resources;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void filterPropertiesTest() throws IOException {
        log.info("---------------- Reading properties file ----------------");
        assertNotNull("File is not found", resources);

        log.info("----------------  Mapping File into Request Object --------------");
        SpotifyRequest spotifyRequest = mapper.readValue(resources.getInputStream(), new TypeReference<SpotifyRequest>() {
        });
        assertNotNull("No object data was parsed from file", spotifyRequest);

        List<SongPropertiesResponse> songPropertiesResponses = spotifyService.filterProperties(spotifyRequest);
        assertNotNull(songPropertiesResponses);
        songPropertiesResponses.stream().forEach(songPropertiesResponse -> log.info(songPropertiesResponse.toString()));
    }

}
