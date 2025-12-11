package bcy.controller;

import bcy.user.User;
import bcy.user.UserDto;
import bcy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    // 내 정보 조회 API
    @GetMapping("/api/user/me")
    public UserDto getMyProfile(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }

        // 로그인 세션에서 이메일 꺼내기
        String email = (String) principal.getAttributes().get("email");

        // DB에서 유저 찾아서 DTO로 변환 후 반환
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

        return new UserDto(user);
    }
}
