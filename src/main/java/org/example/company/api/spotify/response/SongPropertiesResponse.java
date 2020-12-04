package org.example.company.api.spotify.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class SongPropertiesResponse {

    String songId;
    List<String> artists;
    String songName;
    String albumName;

}
