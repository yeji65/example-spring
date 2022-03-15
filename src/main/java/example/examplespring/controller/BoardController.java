package example.examplespring.controller;

import example.examplespring.entity.Board;
import example.examplespring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/board/write") //localhost:9000/board/write
    public String boardWriteForm() {

        return "boardwrite" ;
    }
    //글 작성 처리
   @PostMapping("/board/writepro")
    public String boardWriterPro(Board board){

        boardService.write(board);
        return "";
    }
    //글 리스트
    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.boardList());
        return "boardlist";
    }

    //글 상세조회
    @GetMapping("/board/view") //localhost:9000/board/view?id=1
    public String boardView(Model model,Integer id){
        model.addAttribute("board",boardService.boardView(id));
        return "boardview";
    }
}
