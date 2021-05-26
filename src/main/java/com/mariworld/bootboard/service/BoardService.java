package com.mariworld.bootboard.service;

import com.mariworld.bootboard.dto.BoardDTO;
import com.mariworld.bootboard.dto.PageRequestDTO;
import com.mariworld.bootboard.dto.PageResultDTO;
import com.mariworld.bootboard.entity.Board;
import com.mariworld.bootboard.entity.Member;

import java.util.List;

public interface BoardService {

    public List<Object[]> getList();
    public List<Board> getListTest();
    //public List<Object[]> getList(PageRequestDTO pageRequestDTO);
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
    public Long register(BoardDTO dto);

    default BoardDTO entityToDTO(Board board, Member member){
        BoardDTO dto = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .email(member.getEmail())
                .name(member.getName())
                .regDate(board.getRegDate())
                .build();
        return dto;
    }

    default Board DTOtoEntity(BoardDTO dto){
        Member member = Member.builder().email(dto.getEmail()).build();
        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(member)
                .build();
        return board;
    }

}
