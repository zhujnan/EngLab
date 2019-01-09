package com.wisezone.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tip {
	private String userId;
	private String title;
	private Date start;
	private Date end;
	private String className;
	public Tip() {}
	
	public Tip(String userId, String title, Date start, Date end, String className) {
		this.userId = userId;
		this.title = title;
		this.start = start;
		this.end = end;
		this.className = className;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		if(end==null) {
			this.end = null;
		}
		this.end = end;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Tip [userId=" + userId + ", title=" + title + ", start=" + start + ", end=" + end + ", className="
				+ className + "]";
	}
	
}
