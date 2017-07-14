package main.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;

import board.service.*;
import main.service.*;
import work.service.*;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	MainService ms;
	@Autowired
	WorkService ws;
	@Autowired
	BoardService bs;

	// index
	@RequestMapping("")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("t:index");
		mav.addObject("menu", "Home");
		List<HashMap> workList = ws.workList();
		mav.addObject("workList", workList);
		List<HashMap> boardList = bs.boardList(1);
		mav.addObject("boardList", boardList);
		return mav;
	}
	
	// 관리자 로그인
	@RequestMapping("/admin")
	public ModelAndView admin(){
		ModelAndView mav = new ModelAndView("t:main/admin");
		return mav;
	}
	
	// 로그인
	@RequestMapping("/login/{id}/{pw}")
	@ResponseBody
	public boolean login(@PathVariable(name="id")String id, @PathVariable(name="pw")String pw, HttpSession session){
		return ms.login(id, pw, session);
	}
	
	// 에디터 파일 업로드
	@RequestMapping(value="/ckUpload", method=RequestMethod.POST)
	public void ckeditorImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		try {
			ms.ckeditorImageUpload(request, response, upload);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
