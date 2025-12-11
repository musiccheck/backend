package bcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuthController {
    @GetMapping("/loginForm")
    public String home() {
        return "loginForm";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "privatePage";
    }

    // OAuth 로그인 시작 엔드포인트 (앱에서 사용)
    @GetMapping("/oauth2/authorization/kakao")
    public String kakaoLogin() {
        return "redirect:/oauth2/authorization/kakao";
    }
}


