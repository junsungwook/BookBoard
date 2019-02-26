package org.zerock.book;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private BoardService service;
	
	@Autowired
	private PageDTO page;
	
	//Ãß°¡Æû
	@GetMapping("/register")
	public void register() {
		
	}
	
	//Ãß°¡
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	/*
	 * public void list(Model model) { logger.info("list..."); int total =
	 * service.getTotal(); model.addAttribute("total",total);
	 * model.addAttribute("list",service.getList()); }
	 */
	public void list(Criteria cri,Model model) {
		logger.info("list : "+cri);
		System.out.println(cri.getType());
		System.out.println(cri.getKeyword());
		model.addAttribute("list",service.getList(cri));
		int total = service.getTotalCount(cri);
		System.out.println(total);
		page.paging(cri,total);
		model.addAttribute("pageMaker",page);
		model.addAttribute("total",total);
	}
	
	
	
	
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno")Long bno,Model model) {
      logger.info("get..."+bno);
      BoardVO board = service.get(bno);
      model.addAttribute("board",board);
	} 
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {

		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
	
}
