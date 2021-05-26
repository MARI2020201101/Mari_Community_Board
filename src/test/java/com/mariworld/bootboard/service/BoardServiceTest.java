package com.mariworld.bootboard.service;

import com.mariworld.bootboard.dto.BoardDTO;
import com.mariworld.bootboard.dto.PageRequestDTO;
import com.mariworld.bootboard.dto.PageResultDTO;
import com.mariworld.bootboard.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void getListTest(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<BoardDTO,Object[]> result = boardService.getList(pageRequestDTO);
        result.getDtoList().forEach(System.out::println);
    }
}
