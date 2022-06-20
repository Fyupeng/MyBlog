package org.blog.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.blog.entity.Blog;
import org.blog.mapper.BlogMapper;

public class BlogUtil {
	
		
		public void addBlogWithoutUpdatedate(int blogid, int userid, String headline, String content, Date createdate, int likes) {
			
			SqlSession session = MyBatisFactory.getSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			
			Map<String, Object> blogParams = new HashMap<>();
			blogParams.put("blogid", blogid);
			blogParams.put("userid", userid);
			blogParams.put("headline", headline);
			blogParams.put("content", content);
			blogParams.put("createdate", createdate);
			blogParams.put("likes", likes);
			
			
			blogMapper.addBlogWithoutUpdatedate(blogParams);
			
			session.commit();
			session.close();
			
		}
		
		public Blog queryBlogById(int blogid) {
			
			SqlSession session = MyBatisFactory.getSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			
			Blog blog = blogMapper.queryBlogById(blogid);
			
			session.close();
			
			return blog;
			
		}
	
	public void addBlogWithoutCreatedate(int blogid, int userid, String headline, String content, Date updatedate) {
		
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Map<String, Object> blogParams = new HashMap<>();
		blogParams.put("blogid", blogid);
		blogParams.put("userid", userid);
		blogParams.put("headline", headline);
		blogParams.put("content", content);
		blogParams.put("updatedate", updatedate);
		
		
		blogMapper.addBlogWithoutCreatedate(blogParams);
		
		session.commit();
		session.close();
		
	}
	
	public boolean queryBlogIsExistById(int blogid) {
		
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		
		int result = blogMapper.queryBlogIsExistById(blogid);
		
		session.close();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	public List<Blog> queryBlogByUserid(int userid) {
		
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		
		List<Blog> blogs = blogMapper.queryBlogByUserid(userid);
		
		session.close();
		
		 
		return blogs;
		
	}
	
	public void updateBlogByBlogidWithoutcontent(int blogid, String headline) {
			
			SqlSession session = MyBatisFactory.getSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			
			Map<String, Object> blogParams = new HashMap<>();
			
			blogParams.put("blogid", blogid);
			blogParams.put("headline", headline);
			
			blogMapper.updateBlogByBlogidWithoutcontent(blogParams);
			
			session.commit();
			session.close();
			
	}
	
	public void updateBlogByBlogidForLikes(int blogid) {
		
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		
		blogMapper.updateBlogByBlogidForLikes(blogid);
		
		session.commit();
		session.close();
		
	}
	
	public void updateBlogByBlogidForDislikes(int blogid) {
			
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		
		blogMapper.updateBlogByBlogidForDislikes(blogid);
		
		session.commit();
		session.close();
		
	}
	
	public void updateBlogByBlogidWithoutHeadline(int blogid, String content) {
		
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Map<String, Object> blogParams = new HashMap<>();
		
		blogParams.put("blogid", blogid);
		blogParams.put("content", content);
		
		blogMapper.updateBlogByBlogidWithoutHeadline(blogParams);
		
		session.commit();
		session.close();
		
	}
	
	public void updateBlogByBlogidWithUpdatedate(int blogid, Date updatedate) {
		
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Map<String, Object> blogParams = new HashMap<>();
		
		blogParams.put("blogid", blogid);
		blogParams.put("updatedate", updatedate);
		
		blogMapper.updateBlogByBlogidWithUpdatedate(blogParams);
		
		session.commit();
		session.close();
		
	}
	
	public void deleteBlogByBlogid(int blogid) {
		
		SqlSession session = MyBatisFactory.getSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		
		blogMapper.deleteBlogByBlogid(blogid);
		
		session.commit();
		session.close();
		
	}
	
	
}
