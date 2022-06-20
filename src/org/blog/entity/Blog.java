package org.blog.entity;

import java.util.Date;

public class Blog {
	private int blogid;// 博客id
	private int userid;// 用户id
	private String headline;// 博客标题
	private String content;// 博客内容
	private Date createdate;// 博客创建时间
	private Date updatedate;// 博客修改时间
	private int likes;// 点赞

	public Blog() {

	}

	public Blog(int blogid, int userid, String headline, String content, Date createdate, Date updatedate) {
		this.blogid = blogid;
		this.userid = userid;
		this.headline = headline;
		this.content = content;
		this.createdate = createdate;
		this.updatedate = updatedate;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Blog [blogid=" + blogid + ", userid=" + userid + ", headline=" + headline + ", content=" + content
				+ ", createdate=" + createdate + ", updatedate=" + updatedate + ", likes=" + likes + "]";
	}

}
