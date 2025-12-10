package bcy.like;

import bcy.song.Song;
import bcy.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndSong(User user, Song song);
    // 좋아요 목록 조회
    List<Like> findAllByUserAndIsLikeTrue(User user);

    // 싫어요 목록 조회 (False인 것만 찾기)
    List<Like> findAllByUserAndIsLikeFalse(User user);
}