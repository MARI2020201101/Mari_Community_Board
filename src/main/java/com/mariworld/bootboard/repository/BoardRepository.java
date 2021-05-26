package com.mariworld.bootboard.repository;

import com.mariworld.bootboard.dto.PageRequestDTO;
import com.mariworld.bootboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b,m from Board b left join b.member m")
    public List<Object[]> getBoardWithMember();

    @Query(value ="select b,m from Board b left join b.member m"
            ,countQuery = "select count(b) from Board b")
    public Page<Object[]> getBoardWithMember(PageRequest pageRequest);


}
