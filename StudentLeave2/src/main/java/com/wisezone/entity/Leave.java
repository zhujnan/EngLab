package com.wisezone.entity;

import java.util.Date;

/**
 * ��ٵ�ʵ��
 * @author user
 *
 */
public class Leave {

	private Integer id; // ���
	private User user; // �����
	private Date leaveDate; // �������
	private Integer leaveDays; // �������
	private String leaveReason; // ���ԭ��
	private String state; // ���״̬  δ�ύ  ����� ���ͨ�� ���δͨ��
	private String processInstanceId; // ����ʵ��id
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public Integer getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(Integer leaveDays) {
		this.leaveDays = leaveDays;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	@Override
	public String toString() {
		return "Leave [id=" + id + ", user=" + user + ", leaveDate=" + leaveDate + ", leaveDays=" + leaveDays
				+ ", leaveReason=" + leaveReason + ", state=" + state + ", processInstanceId=" + processInstanceId
				+ "]";
	}
	
	
}
