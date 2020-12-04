package org.example.company.api.spotify.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.company.api.spotify.model.Album;
import org.example.company.api.spotify.model.Artist;
import org.example.company.api.spotify.model.Track;
import org.example.company.api.spotify.request.SpotifyRequest;
import org.example.company.api.spotify.response.SongPropertiesResponse;
import org.example.company.api.spotify.service.SpotifyService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SpotifyServiceImpl implements SpotifyService {

    @Override
    public List<SongPropertiesResponse> filterProperties(SpotifyRequest spotifyRequest) {
        log.debug("Entering filterProperties() with request={}", spotifyRequest);
        List<SongPropertiesResponse> response = new ArrayList<>();
        if (!CollectionUtils.isEmpty(spotifyRequest.getItems())) {
            response = spotifyRequest
                    .getItems()
                    .stream()
                    .filter(item -> item.getTrack() != null)
                    .map(item -> {
                        return mapRequestPropertiesToResponse(item.getTrack());
                    })
                    .collect(Collectors.toList());
        }
        return response;
    }

    private static SongPropertiesResponse mapRequestPropertiesToResponse(Track track) {
        Album album = track.getAlbum() != null ? track.getAlbum() : null;
        String albumName = album.getName() != null ? album.getName() : null;
        return SongPropertiesResponse
                .builder()
                .songId(track.getId())
                .artists(getArtistsNames(track))
                .songName(track.getName())
                .albumName(albumName)
                .build();

    }

    private static List<String> getArtistsNames(Track track) {
        List<String> artistNames = new ArrayList<>();
        if (!CollectionUtils.isEmpty(track.getArtists())) {
            artistNames = track
                    .getArtists()
                    .stream()
                    .map(Artist::getName)
                    .collect(Collectors.toList());
        }
        return artistNames;
    }
}
