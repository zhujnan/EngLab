package com.wisezone.entity;

/**
 * 用户角色关联实体 扩展
 * @author user
 *
 */
public class MemberShip {

	private User user; // 用户 
	private Group group; // 角色
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	
}
