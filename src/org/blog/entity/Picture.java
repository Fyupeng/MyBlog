package org.blog.entity;

public class Picture {
	private int pictureid;
	private String picturename;
	private String pictureroute;
	private int userid;
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Picture(int pictureid, String picturename, String pictureroute, int userid) {
		super();
		this.pictureid = pictureid;
		this.picturename = picturename;
		this.pictureroute = pictureroute;
		this.userid = userid;
	}
	public int getPicutreid() {
		return pictureid;
	}
	public void setPicutreid(int pictureid) {
		this.pictureid = pictureid;
	}
	public String getPicturename() {
		return picturename;
	}
	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	public String getPictureroute() {
		return pictureroute;
	}
	public void setPictureroute(String pictureroute) {
		this.pictureroute = pictureroute;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "picture [pictureid=" + pictureid + ", picturename=" + picturename + ", pictureroute=" + pictureroute
				+ ", userid=" + userid + "]";
	}
	
	
	
}
