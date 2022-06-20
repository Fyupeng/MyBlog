package org.blog.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.blog.entity.Friend;
import org.blog.mapper.FriendMapper;

public class FriendUtil {

	public List<Friend> queryAllFriendsByUserid(int userid) {
		
		SqlSession session = MyBatisFactory.getSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		
		List<Friend> friends =  friendMapper.queryAllFriendsByUserid(userid);
			
		session.close();
		
		return friends;
	}
	
	
	public boolean queryFriendIsExistById(int friendid) {
		
		SqlSession session = MyBatisFactory.getSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		
		int result =  friendMapper.queryFriendIsExistById(friendid);
		
		session.close();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	
	public List<Friend> queryAllFriendsByFriendusernamewithUserid(int userid, String friendusername) {
		
		SqlSession session = MyBatisFactory.getSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		
		Map<String, Object> friendParams = new HashMap<>();
		friendParams.put("userid", userid);
		friendParams.put("friendusername", friendusername);
		
		List<Friend> friends =  friendMapper.queryAllFriendsByFriendusernamewithUserid(friendParams);
		
		session.close();
		
		return friends;
	}
	
	
	public List<Friend> queryAllFriendsByFriendnicknameWithUserid(int userid, String friendnickname) {
		
		SqlSession session = MyBatisFactory.getSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		
		Map<String, Object> friendParams = new HashMap<>();
		friendParams.put("userid", userid);
		friendParams.put("friendnickname", friendnickname);
		
		List<Friend> friends =  friendMapper.queryAllFriendsByFriendnicknameWithUserid(friendParams);
		
		session.close();
		
		return friends;
	}
	
	public void addFriendByUserid(int friendid, int frienduserid, String friendusername, int friendsex, String friendnickname, String friendmotto, int userid) {
		
		SqlSession session = MyBatisFactory.getSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		
		Map<String, Object> friendParams = new HashMap<>();
		
		friendParams.put("friendid", friendid);
		friendParams.put("frienduserid", frienduserid);
		friendParams.put("friendusername", friendusername);
		friendParams.put("friendsex", friendsex);
		friendParams.put("friendnickname", friendnickname);
		friendParams.put("friendmotto", friendmotto);
		friendParams.put("userid", userid);
		
		
		friendMapper.addFriendByUserid(friendParams);
	
		session.commit();
		session.close();
	}
	public void deleteFriendByFriendid(int friendid) {
		
		SqlSession session = MyBatisFactory.getSession();
		FriendMapper friendMapper = session.getMapper(FriendMapper.class);
		
		
		friendMapper.deleteFriendByFriendid(friendid);
		
		session.commit();
		session.close();
	}
	
	
}
