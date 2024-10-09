package br.com.xuitter.xuitter_api.dtos;

import br.com.xuitter.xuitter_api.entities.Xuit;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class XuitResponse {

    @JsonProperty
    private final Long id;

    @JsonProperty
    private final String content;

    @JsonProperty
    private final String authorUsername;

    @JsonProperty
    private final Xuit.XuitType type;

    @JsonProperty
    private final Long originalXuitId;

    @JsonProperty
    private final LocalDateTime createdAt;

    public XuitResponse(Xuit xuit) {
        id = xuit.getId();
        content = xuit.getContent();
        authorUsername = xuit.getAuthor().getUsername();
        type = xuit.getType();
        originalXuitId = xuit.getOriginalXuit().map(Xuit::getId).orElse(null);
        createdAt = xuit.getCreatedAt();
    }
}
