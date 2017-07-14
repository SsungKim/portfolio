package board.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import board.service.*;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService bs;

	// board index
	@RequestMapping("")
	public ModelAndView board(){
		ModelAndView mav = new ModelAndView("t:board/board");
		mav.addObject("menu", "Board");
		List<HashMap> boardList = bs.boardList(1);
		mav.addObject("boardList", boardList);
		mav = pageInner(mav, 1);
		return mav;
	}
	
	// page method
	public ModelAndView pageInner(ModelAndView mav, int select){
		int page = bs.boardPage();
		int first = 1;
		int last = page;
		int start = select/5*5+1;
		int end = start+4 > last ? last : start+4;
		mav.addObject("select", select);
		mav.addObject("first", first);
		mav.addObject("last", last);
		mav.addObject("start", start);
		mav.addObject("end", end);
		return mav;
	}
	
	// write
	@RequestMapping("/write")
	public ModelAndView write(){
		ModelAndView mav = new ModelAndView("t:board/write");
		mav.addObject("menu", "Board");
		return mav;
	}
	
	// upload
	@RequestMapping("/upload")
	@ResponseBody
	public boolean upload(@RequestParam(name="title")String title, @RequestParam(name="content")String content){
		return bs.upload(title, content);
	}
	
	// view
	@RequestMapping("/view/{num}")
	@ResponseBody
	public HashMap view(@PathVariable(name="num")String num){
		return bs.view(num);
	}
	
	// move page
	@RequestMapping("/page/{page}")
	public ModelAndView page(@PathVariable(name="page")int page){
		ModelAndView mav = new ModelAndView("t:board/board");
		mav.addObject("menu", "Board");
		mav.addObject("menu_type", "page");
		List<HashMap> boardList = bs.boardList(page);
		mav.addObject("boardList", boardList);
		mav = pageInner(mav, page);
		return mav;
	}
	
	// delete
	@RequestMapping("/delete/{num}")
	@ResponseBody
	public boolean delete(@PathVariable(name="num")String num){
		return bs.delete(num);
	}
	
	// modify
	@RequestMapping("/modify/{num}")
	public ModelAndView modify(@PathVariable(name="num")String num){
		ModelAndView mav = new ModelAndView("t:board/modify");
		mav.addObject("menu", "Board");
		HashMap board = bs.view(num);
		mav.addObject("title", board.get("title"));
		mav.addObject("content", board.get("content"));
		mav.addObject("num", num);
		return mav;
	}
	
	// modify save
	@RequestMapping("/modify")
	@ResponseBody
	public boolean modifySave(@RequestParam(name="title")String title, @RequestParam(name="content")String content,
												@RequestParam(name="num")String num){
		return bs.modify(title, content, num);
	}
	
	// main -> board view
	@RequestMapping("view2/{num}")
	public ModelAndView view2(@PathVariable(name="num")String num){
		ModelAndView mav = new ModelAndView("t:board/board");
		mav.addObject("menu", "Board");
		List<HashMap> boardList = bs.boardList(1);
		mav.addObject("boardList", boardList);
		mav = pageInner(mav, 1);
		HashMap content = bs.view(num);
		mav.addObject("content", content);
		return mav;
	}
}
