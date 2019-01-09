package com.wisezone.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wisezone.entity.ActiveUser;
import com.wisezone.entity.Group;
import com.wisezone.entity.MemberShip;
import com.wisezone.entity.PageBean;
import com.wisezone.entity.User;
import com.wisezone.service.GroupService;
import com.wisezone.service.MemberShipService;
import com.wisezone.service.UserService;
import com.wisezone.util.ResponseUtil;
import com.wisezone.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 用户Controller层
 * @author user
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private MemberShipService memberShipService;
	
	@Resource
	private GroupService groupService;
	
	//系统首页
	@RequestMapping("/first.do")
	public String first(Model model)throws Exception{
		//从shiro的session中取activeUser
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		//通过model传到页面
		model.addAttribute("activeUser", activeUser); 
		//住页面显示当前用户的时候会使用该对象
		return "all";
	}
	
	/**
	 * 用户登录
	 * @param requset
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest requset,HttpServletResponse response)throws Exception{
		String exceptionClassName = (String) requset.getAttribute("shiroLoginFailure");
		JSONObject result = new JSONObject();
		if(exceptionClassName!=null) {
			System.out.println("xx"+exceptionClassName);
			if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
				 //最终会抛给异常处理器
				result.put("success", true);
				result.put("errorInfo", "用户名或者密码错误");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误。
			}
		}
		return "/page/login"; 
		//当认证失败的时候，安全管理器会将请求交给该方法处理，在这个方法中
		//转发到登录页面。
		
		/*String userName=requset.getParameter("userName");
		String password=requset.getParameter("password");
		String groupId=requset.getParameter("groupId");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName", userName);
		map.put("password", password);
		map.put("groupId", groupId);
		
		MemberShip memberShip=memberShipService.login(map); 
		//根据用户名，密码，角色id 查询该用户所在的成员关系表信息
		JSONObject result=new JSONObject();
		if(memberShip==null){ 
			//没有查到就在json对象中添加2个key，value键值对
			//{'success':'false',"errorInfo", "用户名或者密码错误！"}
			result.put("success", false);
			result.put("errorInfo", "用户名或者密码错误！");
			System.out.println("aaa");
		}else{
			result.put("success", true);
			requset.getSession().setAttribute("currentMemberShip", memberShip);
			System.out.println("bbb");
		}
		ResponseUtil.write(response, result);
		return null;*/
	}
	/**
	 * 分页条件查询用户
	 * @param page
	 * @param rows
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,User s_user,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", StringUtil.formatLike(s_user.getId())); // 查询用户名获取
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList=userService.find(map);
		Long total=userService.getTotal(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(userList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * 分页条件查询用户以及用户所有的角色
	 * @param page
	 * @param rows
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listWithGroups")
	public String listWithGroups(
			@RequestParam(value="page",required=false)String page,
			@RequestParam(value="rows",required=false)String rows,
			User s_user,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", StringUtil.formatLike(s_user.getId()));
		map.put("start", pageBean.getStart()); //开始位置
		map.put("size", pageBean.getPageSize()); //每页显示行数
		List<User> userList=userService.find(map);
		for(User user:userList){
			StringBuffer groups=new StringBuffer();
			List<Group> groupList=groupService.findByUserId(user.getId());
			for(Group g:groupList){
				groups.append(g.getName()+",");
			}
			if(groups.length()>0){
				user.setGroups(groups.deleteCharAt(groups.length()-1).toString()); // 去掉最后一个逗号
			}else{
				user.setGroups(groups.toString());	
			}
		}
		Long total=userService.getTotal(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(userList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或者修用户
	 * @param user
	 * @param response
	 * @param flag 1 添加  2修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(User user,HttpServletResponse response,Integer flag)throws Exception{
		int resultTotal=0; // 操作的记录条数
		if(flag==1){
			resultTotal=userService.add(user);
		}else{
			resultTotal=userService.update(user);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除用户
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			userService.delete(idsStr[i]);
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 判断是否存在指定用户名
	 * @param userName
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/existUserName")
	public String existUserName(String userName,HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();
		if(userService.findById(userName)==null){
			result.put("exist", false);
		}else{
			result.put("exist", true);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 修改用户密码
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(String id,String newPassword,HttpServletResponse response)throws Exception{
		User user=new User();
		user.setId(id);
		user.setPassword(newPassword);
		int resultTotal=userService.update(user);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
}
