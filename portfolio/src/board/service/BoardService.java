package board.service;

import java.text.*;
import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class BoardService {
	@Autowired
	SqlSessionFactory fac;
	
	// upload
	public boolean upload(String title, String content){
		SqlSession ss = fac.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		String day = sdf.format(System.currentTimeMillis());
		map.put("day", day);
		try{
			ss.insert("board.upload", map);
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

	// boardList
	public List<HashMap> boardList(int page) {
		SqlSession ss = fac.openSession();
		List<HashMap> list = ss.selectList("board.boardList", (page-1)*14);
		ss.close();
		return list;
	}

	// view
	public HashMap view(String num) {
		SqlSession ss = fac.openSession();
		HashMap map = ss.selectOne("board.view", num);
		ss.close();
		return map;
	}

	// boardList page
	public int boardPage() {
		SqlSession ss = fac.openSession();
		int page = ss.selectOne("board.count");
		ss.close();
		return page%14 == 0 ? page/14 : page/14+1;
	}

	// board delete
	public boolean delete(String num) {
		SqlSession ss = fac.openSession();
		int n = ss.delete("board.delete", num);
		if(n>0){
			ss.commit();
			ss.close();
			return true;
		} else {
			ss.rollback();
			ss.close();
			return false;
		}
	}

	// modify save
	public boolean modify(String title, String content, String num) {
		SqlSession ss = fac.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("num", num);
		map.put("title", title);
		map.put("content", content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		String day = sdf.format(System.currentTimeMillis());
		map.put("day", day);
		int n = ss.update("board.modify", map);
		if(n>0){
			ss.commit();
			ss.close();
			return true;
		} else {
			ss.rollback();
			ss.close();
			return false;
		}
	}
}
