package bcy.controller;

import bcy.like.LikeDto;
import bcy.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    // API 주소: POST http://172.20.10.3:8080/api/likes
    @PostMapping("/api/likes")
    public String toggleLike(@RequestBody LikeDto likeDto, Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return "로그인이 필요합니다.";
        }

        // JWT 토큰에서 이메일 가져오기
        String email = authentication.getName();

        return likeService.saveReaction(email, likeDto.getMusicId(), likeDto.isLike());
    }
}