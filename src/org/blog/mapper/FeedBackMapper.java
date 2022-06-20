package org.blog.mapper;

import java.util.List;
import java.util.Map;

import org.blog.entity.feedback;

public interface FeedBackMapper {
	
	public abstract List<feedback> queryFeedBack();
	
	public abstract int queryFeedBackIsExistById(int messageid);
	
	public abstract List<feedback> queryFeedBackById(int messageid);
	
	public abstract void deleteFeedBackById(int messagid);
	
	public abstract void addFeedBack(Map<String, Object> feedBackParams);
	
}
