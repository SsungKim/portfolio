package work.service;

import java.io.*;
import java.util.*;

import javax.servlet.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

@Component
public class WorkService {
	@Autowired
	SqlSessionFactory fac;
	@Autowired
	ServletContext application;
	
	// 파일저장
	public String workFile(MultipartFile file) {
		if(file.isEmpty()){
			return null;
		}
		try{
			String uuid = UUID.randomUUID().toString().substring(0, 8);
			String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			File f = new File(application.getRealPath("/file/work"), uuid);
			file.transferTo(f);
			return uuid;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	// work upload DB
	public boolean upload(String name, String url, String tools, String people, String cons, String day, String content,
			String uuid) {
		SqlSession ss = fac.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("url", url);
		tools = tools.replace(", ", "_");
		map.put("tools", tools);
		map.put("people", people);
		cons = cons.replace(" / ", "_");
		map.put("cons", cons);
		map.put("day", day);
		map.put("content", content);
		map.put("uuid", uuid);
		try{
			ss.insert("work.upload", map);
			ss.commit();
			ss.close();
			return true;
		} catch(Exception e){
			e.printStackTrace();
			ss.rollback();
			ss.close();
			return false;
		}
	}
	
	// workList
	public List<HashMap> workList(){
		SqlSession ss = fac.openSession();
		List<HashMap> list = ss.selectList("work.workList");
		for(int i=0; i<list.size(); i++){
			HashMap m = list.get(i);
			m.put("tools", m.get("tools").toString().replace("_", ", "));
			m.put("cons", m.get("cons").toString().replace("_", " / "));
			list.set(i, m);
		}
		ss.close();
		return list;
	}

	// workList count
	public int count() {
		SqlSession ss = fac.openSession();
		int n = ss.selectOne("work.count");
		ss.close();
		return n;
	}
}
