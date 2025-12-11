package bcy.book.service;

import bcy.book.dto.BookDto;
import bcy.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final BookRepository bookRepository;

    // 검색 메서드
    public Page<BookDto> search(String keyword, int page, int size) {

        // page: 0부터 시작
        var pageable = PageRequest.of(page, size);

        return bookRepository
                .findByTitleContainingIgnoreCase(keyword, pageable)
                .map(BookDto::from);  // Entity → DTO 변환
    }
}