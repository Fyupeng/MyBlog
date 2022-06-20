package org.blog.entity;

public class UserInfo {
	private int userid;// 用户id
	private String username;// 用户名
	private String password;// 密码
	private int sex;//性别
	private String nickname;// 别名
	private String motto;// 座右铭
	private String photo;// 个人头像

	public UserInfo() {

	}

	public UserInfo(int userid, String username, int sex, String password, String nickname, String motto, String photo) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.nickname = nickname;
		this.motto = motto;
		this.photo = photo;
	}
	
	

	public int getuserid() {
		return userid;
	}

	public void setuserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + ", sex=" + sex + ", nickname=" + nickname
				+ ", motto=" + motto + "]";
	}
	
	
}
