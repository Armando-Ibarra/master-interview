package org.example.company.api.spotify.service;

import org.example.company.api.spotify.request.SpotifyRequest;
import org.example.company.api.spotify.response.SongPropertiesResponse;

import java.util.List;

public interface SpotifyService {

    List<SongPropertiesResponse> filterProperties(SpotifyRequest spotifyRequest);

}
