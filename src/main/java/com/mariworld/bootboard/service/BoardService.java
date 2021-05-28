package com.mariworld.bootboard.service;

import com.mariworld.bootboard.dto.BoardDTO;
import com.mariworld.bootboard.dto.PageRequestDTO;
import com.mariworld.bootboard.dto.PageResultDTO;
import com.mariworld.bootboard.entity.Board;
import com.mariworld.bootboard.entity.Member;

import java.util.List;

public interface BoardService {

    List<Object[]> getList();
    List<Board> getListTest();
    //public List<Object[]> getList(PageRequestDTO pageRequestDTO);
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
    Long register(BoardDTO dto);
    BoardDTO read(Long bno);
    void modify(BoardDTO dto);
    void remove(Long bno);

    default BoardDTO entityToDTO(Board board, Member member){
        BoardDTO dto = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .email(member.getEmail())
                .name(member.getName())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .build();
        return dto;
    }

    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder().email(dto.getEmail()).build();
        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(member)
                .build();
        return board;
    }

}
