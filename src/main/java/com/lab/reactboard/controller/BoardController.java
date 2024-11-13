package com.lab.reactboard.controller;

import com.lab.reactboard.service.board.BoardService;
import com.lab.reactboard.service.dto.board.BoardDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 일기
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.read(id), HttpStatus.OK);
    }
    /**
     * 게시글 목록
     *
     * @param pageable
     * @param board
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<BoardDTO>> getAll(@PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, BoardDTO board) {
        return new ResponseEntity<>(boardService.list(board, pageable), HttpStatus.OK);
    }
    /**
     * 게시글작성
     *
     * @param board
     * @return
     */
    @PostMapping
    public ResponseEntity<BoardDTO> create(@Validated @RequestBody BoardDTO board) {
        return new ResponseEntity<>(boardService.create(board), HttpStatus.OK);
    }
    /**
     * 게시글 삭제
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 게시글 수정
     *
     * @param id
     * @param board
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<BoardDTO> update(@PathVariable Long id, @RequestBody BoardDTO board) {
        return new ResponseEntity<>(boardService.update(id, board), HttpStatus.OK);
    }
}
