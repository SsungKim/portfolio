package main.service;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

@Component
public class MainService {
	@Autowired
	SqlSessionFactory fac;
	@Autowired
	ServletContext application;
	
	// �α���
	public boolean login(String id, String pw, HttpSession session){
		SqlSession ss = fac.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		List<HashMap> list = ss.selectList("main.login", map);
		ss.close();
		if(list.size() > 0){
			session.setAttribute("login", list.get(0));
			return true;
		} else {
			return false;
		}
	}
	
	// ������ ���� ���ε�
	@SuppressWarnings("resource")
	public void ckeditorImageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws Exception {
		OutputStream out = null;
		PrintWriter printWriter = null;	
		String fileName = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		String uploadPath = application.getRealPath("/file/ckFile");
		
		out = new FileOutputStream(new File(uploadPath, fileName));
		out.write(bytes);
		String callback = request.getParameter("CKEditorFuncNum");
		
		printWriter = response.getWriter();
		String fileUrl = request.getContextPath()+"/file/ckFile/" +fileName; //url ���
		
		printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
	               + callback
	               + ",'"
	               + fileUrl
	               + "','�̹����� ���ε� �Ͽ����ϴ�.'"
	               + ")</script>");
	       printWriter.flush();
	}
}
