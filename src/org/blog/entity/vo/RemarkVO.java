package org.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;


public class RemarkVO implements  Comparable<RemarkVO>,  Serializable{
	private int commentid;// 评论id
	private int userid;//用户id
	private int blogid;// 博客id
	private String name;// 评论人:也就是userinfo里面的username
	private String message;// 评论信息
	private Date remarkdate;// 评论时间
	private String datetimeago;

	public RemarkVO() {

	}

	public RemarkVO(int commentid, int blogid, String name, String message, Date remarkdate) {
		this.commentid = commentid;
		this.blogid = blogid;
		this.name = name;
		this.message = message;
		this.remarkdate = remarkdate;
	}
	
	public RemarkVO(int commentid,int userid, int blogid, String name, String message, Date remarkdate) {
		this.commentid = commentid;
		this.userid = userid;
		this.blogid = blogid;
		this.name = name;
		this.message = message;
		this.remarkdate = remarkdate;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getremarkdate() {
		return remarkdate;
	}

	public void setremarkdate(Date remarkdate) {
		this.remarkdate = remarkdate;
	}
	
	public String getDatetimeago() {
		return datetimeago;
	}
	
	public void setDatetimeago(String datetimeago) {
		this.datetimeago = datetimeago;
	}

	
	@Override
	public String toString() {
		return "RemarkVO [commentid=" + commentid + ", userid=" + userid + ", blogid=" + blogid + ", name=" + name
				+ ", message=" + message + ", remarkdate=" + remarkdate + ", datetimeago=" + datetimeago + "]";
	}

	@Override
	public int compareTo(RemarkVO o) {
		long i = this.getremarkdate().getTime() - o.getremarkdate().getTime();//先按日期排序
		if(i == 0) {
			return this.getCommentid() - o.getCommentid();//再按id排序
		}
		return (int) i;
	}
	
	
	
}
