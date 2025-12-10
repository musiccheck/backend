package bcy.like;

import bcy.song.Song;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeResponseDto {
    private Long songId;
    private String title;
    private String artist;

    public LikeResponseDto(Song song) {
        this.songId = song.getId();
        this.title = song.getTitle();
        this.artist = song.getArtist();
    }
}