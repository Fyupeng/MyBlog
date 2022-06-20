package org.blog.mapper;

import java.util.List;
import java.util.Map;

import org.blog.entity.Remark;

public interface RemarkMapper {
	
	public abstract int queryRemarkIsExistById(int commentid);
	
	public abstract List<Remark> queryAllRemarksByBlogid(int blogid);
	
	public abstract List<Remark> queryAllRemarksByUsername(String name);
	
	public abstract List<Remark> queryAllRemarks();
	
	public abstract void addRemarkByBlogid(Map<String, Object> remarkParams);
	
	public abstract void deleteRemarkByIdServlet(int commentid);
	
	
}
