package bcy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<html>" +
                "<head><title>MusicCheck</title></head>" +
                "<body>" +
                "<h1>홈페이지입니다</h1>" +
                "<p>MusicCheck 서비스에 오신 것을 환영합니다.</p>" +
                "<br>" +
                "<a href='/loginForm'>로그인 하러 가기</a>" +
                "</body>" +
                "</html>";
    }
}