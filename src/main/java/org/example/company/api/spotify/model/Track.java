package org.example.company.api.spotify.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {

    @JsonProperty("album")
    private Album album;

    @JsonProperty("artists")
    private List<Artist> artists;

    @JsonProperty("explicit")
    private boolean explicit;

    @JsonProperty("id")
    private String id;

    @JsonProperty("is_playable")
    private boolean isPlayable;

    @JsonProperty("name")
    private String name;

    @JsonProperty("popularity")
    private int popularity;

}
