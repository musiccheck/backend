package bcy.recommend.controller;

import bcy.recommend.dto.MusicDto;
import bcy.recommend.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/{isbn}/playlist")
    public List<MusicDto> getPlaylist(@PathVariable String isbn) {
        return recommendationService.recommend(isbn);
    }
}