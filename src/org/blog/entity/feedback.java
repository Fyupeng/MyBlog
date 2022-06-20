package org.blog.entity;

public class feedback {
	int messageid;
	String message;

	public feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public feedback(int messageid, String message) {
		super();
		this.messageid = messageid;
		this.message = message;
	}

	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "faceback [messageid=" + messageid + ", message=" + message + "]";
	}

}
