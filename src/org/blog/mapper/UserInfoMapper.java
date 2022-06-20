package org.blog.mapper;

import java.util.List;
import java.util.Map;

import org.blog.entity.UserInfo;


public interface UserInfoMapper {
	//UserINnfo
	public abstract int queryUserIsExistById(int userid);
	
	public abstract List<UserInfo> queryAllUserInfos();
	
	public abstract UserInfo queryUserById(int userid);
	
	public abstract UserInfo queryUserInfoByUsername(String username);
	
	public abstract List<UserInfo> queryAllUserInfosByNickname(String nickname);

	public abstract int queryUserIsExistByUser(Map<String, Object> userParms);
	
	public abstract int queryUserIsExistByUsername(String username);
	
	
	
	public abstract void addUserInfo(Map<String, Object> parms);
	
	public abstract void deleteUserByUserid(int userid);
	
	public abstract void updateSexByUserid(Map<String, Object> userParms);
	
	public abstract void updatePwdByUserid(Map<String, Object> userParms);
	
	public abstract void updateNicknameByUserid(Map<String, Object> userParms);
	
	public abstract void updateMottoByUserid(Map<String, Object> userParms);
	
	
	
}
