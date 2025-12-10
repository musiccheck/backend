package bcy.controller;

import bcy.like.LikeDto;
import bcy.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    // API 주소: POST http://localhost:8080/api/likes
    @PostMapping("/api/likes")
    public String toggleLike(@RequestBody LikeDto likeDto, @AuthenticationPrincipal OAuth2User principal) {

        if (principal == null) {
            return "로그인이 필요합니다.";
        }

        String email = (String) principal.getAttributes().get("email");

        return likeService.saveReaction(email, likeDto.getSongId(), likeDto.isLike());
    }
}