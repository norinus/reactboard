package com.lab.reactboard.service.board;


import com.lab.reactboard.service.dto.board.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.border.Border;
import java.util.Map;

public interface BoardService {

    BoardDTO create(BoardDTO board);

    BoardDTO read(Long id);

    BoardDTO update(Long id,BoardDTO board);

    void delete(Long id);

    Page<BoardDTO> list( BoardDTO board,Pageable pageable);

}
