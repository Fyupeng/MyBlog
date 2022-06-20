package org.blog.mapper;

import java.util.List;
import java.util.Map;

import org.blog.entity.Blog;

public interface BlogMapper {
	//Blog
	public abstract int queryBlogIsExistById(int blogid);
	
	public abstract Blog queryBlogById(int blogid);
	
	public abstract void addBlogWithoutUpdatedate(Map<String, Object> blogParams);
	
	public abstract void addBlogWithoutCreatedate(Map<String, Object> blogParams);
	
	public abstract List<Blog> queryBlogByUserid(int userid);
	
	public abstract void updateBlogByBlogidWithoutcontent(Map<String, Object> blogParams);
	
	public abstract void updateBlogByBlogidWithoutHeadline(Map<String, Object> blogParams);
	
	public abstract void updateBlogByBlogidWithUpdatedate(Map<String, Object> blogParams);
	
	public abstract void updateBlogByBlogidForLikes(int blogid);
	
	public abstract void updateBlogByBlogidForDislikes(int blogid);
	
	public abstract void deleteBlogByBlogid(int blogid);
	
}
