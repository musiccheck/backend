package bcy.like;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeDto {
    private Long songId;
    private boolean isLike;
}