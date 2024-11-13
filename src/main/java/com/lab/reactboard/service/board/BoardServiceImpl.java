package com.lab.reactboard.service.board;


import com.lab.reactboard.domain.Board;
import com.lab.reactboard.repository.BoardRepository;
import com.lab.reactboard.repository.querydsl.BoardQueryRepository;
import com.lab.reactboard.service.criteria.board.BoardCriteria;
import com.lab.reactboard.service.dto.board.BoardDTO;
import com.lab.reactboard.service.mapper.board.BoardMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    private final BoardRepository boardRepository;

    private final BoardQueryRepository boardQueryRepository;

    @Override
    public BoardDTO create(BoardDTO board) {
        return boardMapper.toDto(boardRepository.save(boardMapper.toEntity(board)));
    }

    @Override
    @Transactional(readOnly = true)
    public BoardDTO read(Long id) {
        return boardRepository.findById(id).map(boardMapper::toDto).orElse(null);
    }

    @Override
    public BoardDTO update(Long id, BoardDTO board) {
        return boardRepository.findById(id).map(boardEntity -> {
            boardMapper.partialUpdate(boardEntity, board);
            return boardMapper.toDto(boardRepository.save(boardEntity));
        }).orElseThrow(() -> new EntityNotFoundException("Board with id " + id + " not found"));
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BoardDTO> list(BoardDTO boardDTO, Pageable pageable) {

      //  return boardQueryRepository.qFindAll(pageable, boardDTO);

        //JPA 사용 리스트 호출
        Specification<Board> spec = BoardCriteria.byCriteria(boardDTO);
        return boardRepository.findAll(spec, pageable).map(boardMapper::toDto);
    }
}
