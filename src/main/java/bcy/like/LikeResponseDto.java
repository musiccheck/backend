package bcy.like;

import bcy.song.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeResponseDto {
    private Long musicId;
    private String trackName;
    private String artistName;

    public LikeResponseDto(Song music) {
        this.musicId = music.getId();
        this.trackName = music.getTrackName();
        this.artistName = music.getArtistName();
    }
}