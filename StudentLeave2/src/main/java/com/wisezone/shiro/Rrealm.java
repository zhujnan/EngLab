package com.wisezone.shiro;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import com.wisezone.dao.GroupDao;
import com.wisezone.dao.UserDao;
import com.wisezone.entity.ActiveUser;
import com.wisezone.entity.Group;
import com.wisezone.entity.User;

/**
 * �Զ���Realm
 * @author Administrator
 *
 */
public class Rrealm extends AuthorizingRealm{
	@Resource
	private UserDao userDao;
	@Resource
	private GroupDao groupDao;
	@Override
	public void setName(String name) {
		super.setName("realm");
	}
	/**
	 * ��̬��Ȩ����
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("shiro��Ȩ����...");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//���ݵ�ǰ��¼�û���ѯ���Ӧ��Ȩ�ޣ���Ȩ
		ActiveUser activeUser = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
		List<Group> gps 
				=  groupDao
					.findByUserId(activeUser.getUsername());
		ArrayList<String> lists = new ArrayList<String>();
		for(int i=0;i<gps.size();i++) {
			System.out.println("��ɫ��"+gps.get(i).getName());
			lists.add(gps.get(i).getName());
		}
		info.addRoles(lists);
		/**
		 * ����ɫ�����û�������session��
		 */
		return info;
	}
/**
 * ��֤����
 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("shiro��֤����...");
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();// �������л���û���
		System.out.println("�û�����ֵΪ"+username+"�Ͼ�����֧Ԯ");
		User loginUser = userDao.findById(username);
		if (loginUser == null) {
			return null;
		} else {
			// ��������֤��Ϣ����
			/***
			 * ����һ��ǩ�����������������λ�û�ȡ��ǰ����Ķ���
			 * �������������ݿ��в�ѯ��������
			 * ����������ǰrealm������
			 */ 
			 // ���������Ҫ����ҳ��ʾ��ǰ��¼���û���
			//1.����Activer����
			String pd = loginUser.getPassword();
			ActiveUser u = new ActiveUser();
			u.setUsername(loginUser.getId());
			/**
			 * �����û�ȡ�˵����Ϳ���������ö���ʵ����
			 */
		  Session session = SecurityUtils.getSubject().getSession();
		  session.setAttribute("username", loginUser.getId());
		  session.setAttribute("firstName", loginUser.getFirstName());
		  session.setAttribute("lastName", loginUser.getLastName());
		  session.setAttribute("group", groupDao
					.findByUserId(username).get(0).getId());
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(u,
					pd,this.getClass().getSimpleName());
			return info;//���ظ���ȫ���������ɰ�ȫ����������ȶ����ݿ��в�ѯ���������ҳ���ύ������
		}
	}
}

