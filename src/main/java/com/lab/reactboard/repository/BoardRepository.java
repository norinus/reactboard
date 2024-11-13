package com.lab.reactboard.repository;

import com.lab.reactboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BoardRepository extends JpaRepository<Board, Long> , JpaSpecificationExecutor<Board> {
}
