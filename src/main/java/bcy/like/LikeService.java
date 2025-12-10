package bcy.like;

import bcy.song.Song;
import bcy.user.User;
import bcy.song.SongRepository;
import bcy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final SongRepository songRepository;

    @Transactional
    public String saveReaction(String email, Long songId, boolean isLike) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));

        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new IllegalArgumentException("해당 노래가 없습니다."));

        Like existingLike = likeRepository.findByUserAndSong(user, song)
                .orElse(null);

        if (existingLike == null) {
            Like newLike = Like.builder()
                    .user(user)
                    .song(song)
                    .isLike(isLike)
                    .build();
            likeRepository.save(newLike);
            return isLike ? "좋아요 완료" : "싫어요 완료";
        }

        else {
            if (existingLike.isLike() == isLike) {
                likeRepository.delete(existingLike);
                return "반응 취소됨";
            }
            else {
                existingLike.updateLikeStatus(isLike);
                return "상태 변경됨 (" + (isLike ? "좋아요" : "싫어요") + ")";
            }
        }
    }
    @Transactional(readOnly = true)
    public List<LikeResponseDto> getMyDislikes(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        List<Like> dislikes = likeRepository.findAllByUserAndIsLikeFalse(user);

        return dislikes.stream()
                .map(like -> new LikeResponseDto(like.getSong()))
                .collect(Collectors.toList());

    }
}