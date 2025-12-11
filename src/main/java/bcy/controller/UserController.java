package bcy.controller;

import bcy.user.User;
import bcy.user.UserDto;
import bcy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    // 내 정보 조회 API
    @GetMapping("/api/user/me")
<<<<<<< HEAD
    public UserDto getMyProfile(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
=======
    public UserDto getMyProfile(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
>>>>>>> 816efe96c28a00cac6b1cb9d953f20621ffbd8c6
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }

        // JWT 토큰에서 이메일 가져오기
        String email = authentication.getName();

        // DB에서 유저 찾아서 DTO로 변환 후 반환
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

        // 기본값 설정 (OAuth attributes는 로그인 시에만 사용 가능)
        user.setOAuthAttributes("사용자", null, bcy.user.Role.GUEST);

        return new UserDto(user);
    }
}
