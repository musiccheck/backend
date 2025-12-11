package bcy.like;

import bcy.song.Song;
import bcy.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "\"like\"")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    private Song song;

    @Column(name = "is_like", nullable = false)
    private boolean isLike; // true: 좋아요, false: 싫어요

    @Builder
    public Like(User user, Song song, boolean isLike) {
        this.user = user;
        this.song = song;
        this.isLike = isLike;
    }

    public void updateLikeStatus(boolean isLike) {
        this.isLike = isLike;
    }
}
