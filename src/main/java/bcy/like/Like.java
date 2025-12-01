package bcy.like;

import bcy.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "like") // 테이블 이름 지정
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suer_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    private Song song;

    @Column(nullable = false)
    private boolean isLike; // true: 좋아요, false: 싫어요

    @Builder
    public Like(User user, Long songId, boolean isLike) {
        this.user = user;
        this.song = song;
        this.isLike = isLike;
    }

    // 상태 변경 메서드 (좋아요 <-> 싫어요 바꿀 때 사용)
    public void updateLikeStatus(boolean isLike) {
        this.isLike = isLike;
    }
}
