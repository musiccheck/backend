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

    @Column(name = "track_name", nullable = false)
    private String trackName;

    @Column(name = "artist_name", nullable = false)
    private String artistName;

    @Column(name = "album_name")
    private String albumName;

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
