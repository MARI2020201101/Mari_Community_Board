package com.mariworld.bootboard.controller;

import com.mariworld.bootboard.dto.BoardDTO;
import com.mariworld.bootboard.dto.PageRequestDTO;
import com.mariworld.bootboard.entity.Board;
import com.mariworld.bootboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String index(Model model, PageRequestDTO pageRequestDTO){

        model.addAttribute("list",boardService.getList(pageRequestDTO));
        return "/board/list";
    }
    @GetMapping("/register")
    public String registerForm(PageRequestDTO pageRequestDTO){
        return "/board/register";
    }

    @PostMapping("/register")
    public String register(BoardDTO dto
            , PageRequestDTO pageRequestDTO
            , RedirectAttributes attr){
        log.info(String.valueOf(dto));
        log.info(String.valueOf(pageRequestDTO));
        Long bno = boardService.register(dto);
        log.info("bno : " + bno);
        attr.addFlashAttribute("msg"," 게시글 "+bno +" 번이 등록되었습니다.");
        //attr.addAttribute("page", pageRequestDTO.getPage());
        return "redirect:/board/list";
    }
    @GetMapping({"/read","/modify"})
    public void read(Long bno, PageRequestDTO pageRequestDTO
        , Model model){
        BoardDTO dto = boardService.read(bno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/modify")
    public String modify(BoardDTO dto, PageRequestDTO pageRequestDTO
        , RedirectAttributes rttr){
        boardService.modify(dto);
        rttr.addAttribute("page", pageRequestDTO.getPage());
        rttr.addAttribute("bno", dto.getBno());
        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String remove(BoardDTO dto, RedirectAttributes rttr){
        boardService.remove(dto.getBno());
        rttr.addFlashAttribute("msg"," 게시글 " + dto.getBno()+" 번이 삭제되었습니다.");
        return "redirect:/board/list";
    }
}
