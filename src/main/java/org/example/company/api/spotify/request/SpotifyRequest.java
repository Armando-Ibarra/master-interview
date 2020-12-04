package org.example.company.api.spotify.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.company.api.spotify.model.Item;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpotifyRequest {

    @JsonProperty("items")
    private List<Item> items;
}
