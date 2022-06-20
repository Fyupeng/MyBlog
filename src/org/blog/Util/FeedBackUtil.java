package org.blog.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.blog.entity.feedback;
import org.blog.mapper.FeedBackMapper;

public class FeedBackUtil {
	
	public  List<feedback> queryFeedBack(){
		SqlSession session = MyBatisFactory.getSession();
		FeedBackMapper feedbackMapper = session.getMapper(FeedBackMapper.class);
		
		List<feedback> feedBacks = feedbackMapper.queryFeedBack();
		
		return feedBacks;
	
	}
	
	public boolean queryFeedBackIsExistById(int messageid){
		SqlSession session = MyBatisFactory.getSession();
		FeedBackMapper feedbackMapper = session.getMapper(FeedBackMapper.class);
		
		int result = feedbackMapper.queryFeedBackIsExistById(messageid);
		
		if(result > 0) {
			return true;
		}
		
		return false;
	}
		
	public  List<feedback> queryFeedBackById(int messageid){
		SqlSession session = MyBatisFactory.getSession();
		FeedBackMapper feedbackMapper = session.getMapper(FeedBackMapper.class);
		
		List<feedback> feedBacks = feedbackMapper.queryFeedBackById(messageid);
		
		return feedBacks;
		
	}
	
	public void addFeedBack(int messageid, String message) {
		SqlSession session = MyBatisFactory.getSession();
		FeedBackMapper feedbackMapper = session.getMapper(FeedBackMapper.class);
		
		Map<String, Object> feedBackParams = new HashMap<>();
		feedBackParams.put("messageid", messageid);
		feedBackParams.put("message", message);
		
		feedbackMapper.addFeedBack(feedBackParams);
		
		session.commit();
		session.close();
		
	}
	
	public  void deleteFeedBackById(int messagid) {
		SqlSession session = MyBatisFactory.getSession();
		FeedBackMapper feedbackMapper = session.getMapper(FeedBackMapper.class);
		
		feedbackMapper.deleteFeedBackById(messagid);
		
		session.commit();
		session.close();
	}
	
}
