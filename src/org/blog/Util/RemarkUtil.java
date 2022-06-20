package org.blog.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.blog.entity.Remark;
import org.blog.mapper.RemarkMapper;

public class RemarkUtil {
	
	public boolean queryRemarkIsExistById(int commentid) {
		SqlSession session = MyBatisFactory.getSession();
		RemarkMapper remarkMapper =  session.getMapper(RemarkMapper.class);
		
		int result = remarkMapper.queryRemarkIsExistById(commentid);
		
		session.close();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	
	public List<Remark> queryAllRemarksByBlogid(int blogid){
		SqlSession session = MyBatisFactory.getSession();
		RemarkMapper remarkMapper =  session.getMapper(RemarkMapper.class);
		
		List<Remark> remarks =  remarkMapper.queryAllRemarksByBlogid(blogid);
		
		session.close();
		
		return remarks;
		
	}
	
	
	public List<Remark> queryAllRemarksByUsername(String name){
		SqlSession session = MyBatisFactory.getSession();
		RemarkMapper remarkMapper =  session.getMapper(RemarkMapper.class);
		
		List<Remark> remarks =  remarkMapper.queryAllRemarksByUsername(name);
		
		session.close();
		
		return remarks;
		
	}
	public List<Remark> queryAllRemarks(){
		SqlSession session = MyBatisFactory.getSession();
		RemarkMapper remarkMapper =  session.getMapper(RemarkMapper.class);
		
		List<Remark> remarks =  remarkMapper.queryAllRemarks();
		
		session.close();
		
		return remarks;
		
	}
	
	public void addRemarkByBlogid(int commentid, int userid, int blogid, String name, String message, Date remarkdate) {
		SqlSession session = MyBatisFactory.getSession();
		RemarkMapper remarkMapper =  session.getMapper(RemarkMapper.class);
		
		
		Map<String, Object> remarkParams = new HashMap<>();
		remarkParams.put("commentid", commentid);
		remarkParams.put("userid", userid);
		remarkParams.put("blogid", blogid);
		remarkParams.put("name", name);
		remarkParams.put("message", message);
		remarkParams.put("remarkdate", remarkdate);
		
		remarkMapper.addRemarkByBlogid(remarkParams);
		
		session.commit();
		session.close();
		
	}
	
	
	public void deleteRemarkByIdServlet(int commentid) {
		SqlSession session = MyBatisFactory.getSession();
		RemarkMapper remarkMapper =  session.getMapper(RemarkMapper.class);
		
		
		remarkMapper.deleteRemarkByIdServlet(commentid);
		
		session.commit();
		session.close();
		
	}
	
}
