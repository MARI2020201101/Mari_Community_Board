package com.mariworld.bootboard.service;

import com.mariworld.bootboard.dto.BoardDTO;
import com.mariworld.bootboard.dto.PageRequestDTO;
import com.mariworld.bootboard.dto.PageResultDTO;
import com.mariworld.bootboard.entity.Board;
import com.mariworld.bootboard.entity.Member;
import com.mariworld.bootboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    @Override
    public List<Object[]> getList() {
        return boardRepository.getBoardWithMember();
    }

    @Override
    public List<Board> getListTest() {
        return boardRepository.findAll();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        PageRequest pageRequest = pageRequestDTO.makePageRequest(Sort.by("bno").descending());
        Page<Object[]> entity = boardRepository.getBoardWithMember(pageRequest);

        Function<Object[],BoardDTO> fn = (en -> entityToDTO(
                (Board) en[0],(Member) en[1]
        ));
        return new PageResultDTO<>(entity,fn);
    }

    @Override
    public Long register(BoardDTO dto) {
        Member member = Member.builder().email(dto.getEmail()).build();
        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(member)
                .build();
        boardRepository.save(board);
        return board.getBno();
    }
}
