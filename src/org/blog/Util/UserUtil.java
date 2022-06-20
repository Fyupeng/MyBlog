package org.blog.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.blog.entity.UserInfo;
import org.blog.mapper.UserInfoMapper;

public class UserUtil {
	
	public void addUserInfo(int userid,String username, String password, int sex, String nickname, String motto) {
		
		SqlSession session = MyBatisFactory.getSession();
		
		Map<String, Object> userInfoParms = new HashMap<>();
		userInfoParms.put("userid", userid);
		userInfoParms.put("username", username);
		userInfoParms.put("password", password);
		userInfoParms.put("sex", sex);
		userInfoParms.put("nickname", nickname);
		userInfoParms.put("motto", motto);
		
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		userInfoMapper.addUserInfo(userInfoParms);
	
		session.commit();
		session.close();
	}
	
	public boolean queryUserIsExistById(int userid) {
		SqlSession session = MyBatisFactory.getSession();
		
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		int result = userInfoMapper.queryUserIsExistById(userid);
		
		session.close();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	
	public UserInfo queryUserById(int userid) {
		SqlSession session = MyBatisFactory.getSession();
		
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		UserInfo userinfo = userInfoMapper.queryUserById(userid);
		
		session.close();
		
		return userinfo;
		
	}
	
	
	public List<UserInfo> queryAllUserInfos() {
		SqlSession session = MyBatisFactory.getSession();
		
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		List<UserInfo> userInfos = (List<UserInfo>)userInfoMapper.queryAllUserInfos();
		
		session.close();
		
		return userInfos;
		
	}
	
	public List<UserInfo> queryAllUserInfosByNickname(String nickname) {
		SqlSession session = MyBatisFactory.getSession();
		
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		List<UserInfo> userInfos = (List<UserInfo>)userInfoMapper.queryAllUserInfosByNickname(nickname);
		
		session.close();
		
		return userInfos;
		
	}
	
	
	public boolean queryUserIsExistByUser(String username, String password) {
		SqlSession session = MyBatisFactory.getSession();
		
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		Map<String, Object> userParms = new HashMap<>();
		userParms.put("username", username);
		userParms.put("password", password);
		
		int result = userInfoMapper.queryUserIsExistByUser(userParms);
		
		session.close();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	public boolean queryUserIsExistByUsername(String username) {
		SqlSession session = MyBatisFactory.getSession();
		
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		
		int result = userInfoMapper.queryUserIsExistByUsername(username);
		
		session.close();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	public UserInfo queryUserInfoByUsername(String username) {
		UserInfo userInfo = null;
		
		SqlSession session = MyBatisFactory.getSession();
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		
		userInfo = userInfoMapper.queryUserInfoByUsername(username);
		
		session.close();	
		
		return userInfo;
		
	}
	
	public void deleteUserByUserid(int userid) {
		
		SqlSession session = MyBatisFactory.getSession();
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		
		userInfoMapper.deleteUserByUserid(userid);
		
		session.commit();
		session.close();	
		
	}
	
	
	public void updateSexByUserid(int userid, int sex) {
		
		SqlSession session = MyBatisFactory.getSession();
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		Map<String, Object> userParms = new HashMap<>();
		userParms.put("userid", userid);
		userParms.put("sex", sex);
		
		userInfoMapper.updateSexByUserid(userParms);
		
		session.commit();
		session.close();	
		
	}

	public void updatePwdByUserid(int userid, String password) {
	
		SqlSession session = MyBatisFactory.getSession();
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		Map<String, Object> userParms = new HashMap<>();
		userParms.put("userid", userid);
		userParms.put("password", password);
		
		userInfoMapper.updatePwdByUserid(userParms);
		
		session.commit();
		session.close();	
	
	}

	public void updateNicknameByUserid(int userid, String nickname) {
	
		SqlSession session = MyBatisFactory.getSession();
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		Map<String, Object> userParms = new HashMap<>();
		userParms.put("userid", userid);
		userParms.put("nickname", nickname);
		
		userInfoMapper.updateNicknameByUserid(userParms);
		
		session.commit();
		session.close();	
	
	}	
	
	public void updateMottoByUserid(int userid, String motto) {
		
		SqlSession session = MyBatisFactory.getSession();
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		
		Map<String, Object> userParms = new HashMap<>();
		userParms.put("userid", userid);
		userParms.put("motto", motto);
		
		userInfoMapper.updateMottoByUserid(userParms);
		
		session.commit();
		session.close();	
		
	}
	
	
	
}
