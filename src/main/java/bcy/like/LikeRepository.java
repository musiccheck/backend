package bcy.like;

import bcy.song.Song;
import bcy.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndSong(User user, Song song);
}