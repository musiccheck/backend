package bcy.song;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "music")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

<<<<<<< HEAD
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "album")
    private String album;

    @Column(name = "lyrics", length = 2000)
    private String lyrics;
=======
    @Column(name = "track_name", nullable = false)
    private String trackName;

    @Column(name = "artist_name", nullable = false)
    private String artistName;

    @Column(name = "album_name")
    private String albumName;
>>>>>>> 816efe96c28a00cac6b1cb9d953f20621ffbd8c6

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "external_url")
    private String externalUrl;

    @Column(name = "embedding_id")
    private Long embeddingId;

    @Column(name = "popularity")
    private Integer popularity;

    @Column(name = "search_keyword")
    private String searchKeyword;
}
