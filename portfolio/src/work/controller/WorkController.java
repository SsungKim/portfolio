package work.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;

import work.service.*;

@Controller
@RequestMapping("/work")
public class WorkController {
	@Autowired
	WorkService ws;

	// work index
	@RequestMapping("")
	public ModelAndView work(){
		ModelAndView mav = new ModelAndView("t:work/work");
		mav.addObject("menu", "Work");
		List<HashMap> workList = ws.workList();
		mav.addObject("workList", workList);
		return mav;
	}
	
	// work upload
	@RequestMapping("/upload")
	public ModelAndView upload(){
		ModelAndView mav = new ModelAndView("t:work/upload");
		mav.addObject("menu", "Work");
		return mav;
	}
	
	// work upload save
	@RequestMapping("/uploadSave")
	@ResponseBody
	public boolean uploadSave(@RequestParam(name="name")String name, @RequestParam(name="url")String url,
												@RequestParam(name="tools")String tools, @RequestParam(name="people")String people,
												@RequestParam(name="cons")String cons, @RequestParam(name="day")String day,
												@RequestParam(name="content")String content, MultipartHttpServletRequest req){
		MultipartFile file = req.getFile("file");
		String uuid = "";
		if(file != null){
			uuid = ws.workFile(file);
		}
		return ws.upload(name, url, tools, people, cons, day, content, uuid);
	}
	
	// workList count
	@RequestMapping("/count")
	@ResponseBody
	public int count(){
		return ws.count();
	}
	
	// main에서 work 항목 클릭
	@RequestMapping("/view/{num}")
	public ModelAndView view(@PathVariable(name="num")String num){
		ModelAndView mav = new ModelAndView("t:work/work");
		mav.addObject("menu", "Work");
		List<HashMap> workList = ws.workList();
		mav.addObject("workList", workList);
		mav.addObject("viewNum", num);
		return mav;
	}
}
