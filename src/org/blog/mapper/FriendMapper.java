package org.blog.mapper;

import java.util.List;
import java.util.Map;

import org.blog.entity.Friend;

public interface FriendMapper {
	
	public abstract List<Friend> queryAllFriendsByUserid(int userid);
	
	public abstract int queryFriendIsExistById(int friendid);
	
	public abstract List<Friend> queryAllFriendsByFriendusernamewithUserid(Map<String, Object> friendParams);
	
	public abstract List<Friend> queryAllFriendsByFriendnicknameWithUserid(Map<String, Object> friendParams);
	
	public abstract void addFriendByUserid(Map<String, Object> friendParams);
	
	public abstract void deleteFriendByFriendid(int friendid);
	
}
