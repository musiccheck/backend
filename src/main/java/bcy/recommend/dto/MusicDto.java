package bcy.recommend.dto;

public record MusicDto(
        String trackId,
        String trackName,
        String artistName,
        String imageUrl,
        String externalUrl
) {}