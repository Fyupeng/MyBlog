package org.blog.entity;

public class Friend {
	private int friendid;
	private int frienduserid;
	private String friendusername;
	private int friendsex;
	private String friendnickname;
	private String friendmotto;
	private int userid;

	public Friend() {

	}

	public Friend(int friendid, int frienduserid, String friendusername, int friendsex, String friendnickname,
			String friendmotto, int userid) {
		this.friendid = friendid;
		this.frienduserid = frienduserid;
		this.friendusername = friendusername;
		this.friendsex = friendsex;
		this.friendnickname = friendnickname;
		this.friendmotto = friendmotto;
		this.userid = userid;
	}

	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public int getFrienduserid() {
		return frienduserid;
	}

	public void setFrienduserid(int frienduserid) {
		this.frienduserid = frienduserid;
	}

	public String getFriendusername() {
		return friendusername;
	}

	public void setFriendusername(String friendusername) {
		this.friendusername = friendusername;
	}

	public int getFriendsex() {
		return friendsex;
	}

	public void setFriendsex(int friendsex) {
		this.friendsex = friendsex;
	}

	public String getFriendnickname() {
		return friendnickname;
	}

	public void setFriendnickname(String friendnickname) {
		this.friendnickname = friendnickname;
	}

	public String getfriendmotto() {
		return friendmotto;
	}

	public void setfriendmotto(String friendmotto) {
		this.friendmotto = friendmotto;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Friend [friendid=" + friendid + ", frienduserid=" + frienduserid + ", friendusername=" + friendusername
				+ ", friendsex=" + friendsex + ", friendnickname=" + friendnickname + ", friendmotto=" + friendmotto + ", userid="
				+ userid + "]";
	}

}
