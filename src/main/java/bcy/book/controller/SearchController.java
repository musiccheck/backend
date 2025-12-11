package bcy.book.controller;

import bcy.book.dto.BookDto;
import bcy.book.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public Page<BookDto> search(
            @RequestParam String keyword,                 // 검색어
            @RequestParam(defaultValue = "0") int page   // 페이지 번호
    ) {
        int size = 12; // 3x4 그리드 → 12개
        return searchService.search(keyword, page, size);
    }
}
