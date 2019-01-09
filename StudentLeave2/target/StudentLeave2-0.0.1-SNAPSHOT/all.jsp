<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<title>首页 - 统一开发平台 - UI库</title>
		<meta name="description" content="This is page-header (.page-header &gt; h1)" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace.min.css" id="main-ace-style" />
		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-rtl.min.css" />
</head>
<body class="no-skin">
     <!--[if !IE]> -->
			<script type="text/javascript">
				window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.min.js'>"+"<"+"/script>");
			</script>
		<div id="navbar" class="navbar navbar-default">
							<div class="navbar-container" id="navbar-container">
								<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
									<span class="sr-only">Toggle sidebar</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<!-- /section:basics/sidebar.mobile.toggle -->
								<div class="navbar-header pull-left">
									<!-- #section:basics/navbar.layout.brand -->
									<a href="index.html" class="navbar-brand">
										<small>
											<img src="${pageContext.request.contextPath}/static/assets/avatars/logo.png" alt="" />
										</small>
									</a>
								</div>
								<!-- /section:basics/navbar.dropdown -->
								<!-- 导航栏末端begin-->
																				<div class="navbar-buttons navbar-header pull-right" role="navigation">
														<ul class="nav ace-nav">
									
															<li class="green">
																<a data-toggle="dropdown" class="dropdown-toggle" href="#">
																	<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
																	<span class="badge badge-success">5</span>
																</a>
									
																<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
																	<li class="dropdown-header">
																		<i class="ace-icon fa fa-envelope-o"></i>
																		13条未读信息
																	</li>
									
																	<li class="dropdown-content">
																		<ul class="dropdown-menu dropdown-navbar">
																			<li>
																				<a href="#">
																					<img src="${pageContext.request.contextPath}/static/assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
																					<span class="msg-body">
																						<span class="msg-title">
																							<span class="blue">B2C:</span>
																							系统产生20个错误，12个警告...
																						</span>
									
																						<span class="msg-time">
																							<i class="ace-icon fa fa-clock-o"></i>
																							<span>2014-12-15 18:00:00</span>
																						</span>
																					</span>
																				</a>
																			</li>
									
																			<li>
																				<a href="#">
																					<img src="${pageContext.request.contextPath}/static/assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
																					<span class="msg-body">
																						<span class="msg-title">
																							<span class="blue">积分商城:</span>
																							系统产生20个错误，12个警告...
																						</span>
									
																						<span class="msg-time">
																							<i class="ace-icon fa fa-clock-o"></i>
																							<span>2018-12-15 18:00:00</span>
																						</span>
																					</span>
																				</a>
																			</li>
									
																			<li>
																				<a href="#">
																					<img src="${pageContext.request.contextPath}/static/assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
																					<span class="msg-body">
																						<span class="msg-title">
																							<span class="blue">政府机票采购:</span>
																							系统产生20个错误，12个警告...
																						</span>
									
																						<span class="msg-time">
																							<i class="ace-icon fa fa-clock-o"></i>
																							<span>2014-12-15 18:00:00</span>
																						</span>
																					</span>
																				</a>
																			</li>
									
																			<li>
																				<a href="#">
																					<img src="${pageContext.request.contextPath}/static/assets/avatars/avatar2.png" class="msg-photo" alt="Kate's Avatar" />
																					<span class="msg-body">
																						<span class="msg-title">
																							<span class="blue">B2B:</span>
																							系统产生20个错误，12个警告...
																						</span>
									
																						<span class="msg-time">
																							<i class="ace-icon fa fa-clock-o"></i>
																							<span>2014-12-15 18:00:00</span>
																						</span>
																					</span>
																				</a>
																			</li>
									
																			<li>
																				<a href="#">
																					<img src="${pageContext.request.contextPath}/static/assets/avatars/avatar5.png" class="msg-photo" alt="Fred's Avatar" />
																					<span class="msg-body">
																						<span class="msg-title">
																							<span class="blue">货运系统:</span>
																							系统产生20个错误，12个警告...
																						</span>
									
																						<span class="msg-time">
																							<i class="ace-icon fa fa-clock-o"></i>
																							<span>2014-12-15 18:00:00</span>
																						</span>
																					</span>
																				</a>
																			</li>
																		</ul>
																	</li>
									
																	<li class="dropdown-footer">
																		<a href="inbox.html">
																			查看全部消息
																			<i class="ace-icon fa fa-arrow-right"></i>
																		</a>
																	</li>
																</ul>
															</li>
									
															<!-- #section:basics/navbar.user_menu -->
															<li class="light-blue">
																<a data-toggle="dropdown" href="#" class="dropdown-toggle">
																	<img class="nav-user-photo" src="${pageContext.request.contextPath}/static/assets/avatars/user.jpg" alt="Jason's Photo" />
																	<span class="user-info">
																		<strong>欢迎您</strong><br />
																		${activeUser.username}(${currentMemberShip.user.firstName }${currentMemberShip.user.lastName })【${currentMemberShip.group.name }】
																	</span>
									
																	<i class="ace-icon fa fa-caret-down"></i>
																</a>
									
																<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
																	<li>
																		<a href="#">
																			<i class="ace-icon fa fa-cog"></i>
																			系统设置
																		</a>
																	</li>
									
																	<li>
																		<a href="profile.html">
																			<i class="ace-icon fa fa-user"></i>
																			个人信息设置
																		</a>
																	</li>
									
																	<li class="divider"></li>
									
																	<li>
																		<a href="${pageContext.request.contextPath}/logout.action">
																			<i class="ace-icon fa fa-power-off"></i>
																			登出
																		</a>
																	</li>
																</ul>
															</li>
									
															<!-- /section:basics/navbar.user_menu -->
														</ul>
													</div>
								<!-- 导航栏末端end -->
							</div><!-- /.navbar-container -->
		</div>
		<div class="main-container" id="main-container">
			<div id="sidebar" class="sidebar responsive">
					<ul class="nav nav-list">
												<li class="active">
													<a href="index.html">
														<i class="menu-icon fa fa-tachometer"></i>
														<span class="menu-text"> 总控制台 </span>
													</a>
							
													<b class="arrow"></b>
												</li>
												<!-- 管理员页面 begin -->
												<shiro:hasRole name="管理员">
												<li class="">
																<a href="#" class="dropdown-toggle">
																	<i class="menu-icon fa fa-desktop"></i>
																	<span class="menu-text"> 管理员 </span>
																	<b class="arrow fa fa-angle-down"></b>
																</a>
																	<b class="arrow"></b> 

																	<ul class="submenu">
																				<li class="">
																					<a href="${pageContext.request.contextPath}/page/userManage.jsp" target="fname">
																						<i class="menu-icon fa fa-caret-right"></i>
																					   用户管理
																					</a>
																					<b class="arrow"></b>
																				</li>
																				<li class="">
																					<a href="${pageContext.request.contextPath}/page/timeManage.jsp" target="fname">
																						<i class="menu-icon fa fa-caret-right"></i>
																						角色管理
																					</a>
																					<b class="arrow"></b>
																				</li>
																				<li class="">
																					<a href="page.jsp" target="fname">
																						<i class="menu-icon fa fa-caret-right"></i>
																						用户权限管理
																					</a>
																					<b class="arrow"></b>
																				</li>
																		</ul>
											</li>
											<li class="">
																<a href="#" class="dropdown-toggle">
																	<i class="menu-icon fa fa-desktop"></i>
																	<span class="menu-text"> 流程管理 </span>
																	<b class="arrow fa fa-angle-down"></b>
																</a>
																	<b class="arrow"></b> 

																	<ul class="submenu">
																				<li class="">
																					<a href="" target="fname">
																						<i class="menu-icon fa fa-caret-right"></i>
																					   流程部署管理
																					</a>
																					<b class="arrow"></b>
																				</li>
																				<li class="">
																					<a href="${pageContext.request.contextPath}/page/timeManage.jsp" target="fname">
																						<i class="menu-icon fa fa-caret-right"></i>
																						流程定义管理
																					</a>
																					<b class="arrow"></b>
																				</li>
																				
																		</ul>
											</li>
											</shiro:hasRole>
												<!-- 管理员页面end -->
											<li class="">
														<a href="#" class="dropdown-toggle">
															<i class="menu-icon fa fa-desktop"></i>
															<span class="menu-text"> 学习管理 </span>
															<b class="arrow fa fa-angle-down"></b>
														</a>

										<b class="arrow"></b> 

														<ul class="submenu">
																		<li class="">
																			<a href="${pageContext.request.contextPath}/page/studyManage.jsp"  target="fname">
																				<i class="menu-icon fa fa-caret-right"></i>
																			   课程管理
																			</a>
											
																			<b class="arrow"></b>
																		</li>
			
																		<li class="">
																			<a href="${pageContext.request.contextPath}/page/timeManage.jsp" target="fname">
																				<i class="menu-icon fa fa-caret-right"></i>
																				  日程管理
																			</a>
											
																			<b class="arrow"></b>
																		</li>
																		<li class="">
																			<a href="${pageContext.request.contextPath}/studypage/study.jsp" target="fname">
																				<i class="menu-icon fa fa-caret-right"></i>
																				分页
																			</a>
											
																			<b class="arrow"></b>
																		</li>
													</ul>
											</li>
											<!-- 三级菜单begin -->
													<li class="">
								<a href="javascript:void(0)" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>
										学习安排
									<b class="arrow fa fa-angle-down"></b>
								</a>

								<b class="arrow"></b>

								<ul class="submenu">
									<li class="">
										<a href="javascript:void(0)">
											<i class="menu-icon fa fa-leaf green"></i>
											呵呵
										</a>

										<b class="arrow"></b>
									</li>

									<li class="">
										<a href="javascript:void(0)" class="dropdown-toggle">
											<i class="menu-icon fa fa-pencil orange"></i>
											第一阶段
											<b class="arrow fa fa-angle-down"></b>
										</a>

										<b class="arrow"></b>

										<ul class="submenu">
											<li class="">
												<a href="${pageContext.request.contextPath}/javapage/d.jsp" target="fname">
													<i class="menu-icon fa fa-plus purple"></i>
													基本数据类型
												</a>

												<b class="arrow"></b>
											</li>

											<li class="">
												<a href="javascript:void(0)">
													<i class="menu-icon fa fa-eye pink"></i>
													分支与循环
												</a>

												<b class="arrow"></b>
											</li>
										</ul>
									</li>
										<li class="">
										<a href="javascript:void(0)" class="dropdown-toggle">
											<i class="menu-icon fa fa-pencil orange"></i>
											第二阶段
											<b class="arrow fa fa-angle-down"></b>
										</a>

										<b class="arrow"></b>

										<ul class="submenu">
											<li class="">
												<a href="javascript:void(0)">
													<i class="menu-icon fa fa-plus purple"></i>
													  基本数据类型
												</a>

												<b class="arrow"></b>
											</li>

											<li class="">
												<a href="javascript:void(0)">
													<i class="menu-icon fa fa-eye pink"></i>
													分支循环
												</a>

												<b class="arrow"></b>
											</li>
										</ul>
									</li>
										<li class="">
										<a href="javascript:void(0)" class="dropdown-toggle">
											<i class="menu-icon fa fa-pencil orange"></i>
											第三阶段阶段
											<b class="arrow fa fa-angle-down"></b>
										</a>

										<b class="arrow"></b>

										<ul class="submenu">
											<li class="">
												<a href="javascript:void(0)">
													<i class="menu-icon fa fa-plus purple"></i>
													jdbc
												</a>

												<b class="arrow"></b>
											</li>

											<li class="">
												<a href="javascript:void(0)">
													<i class="menu-icon fa fa-eye pink"></i>
													html/css
												</a>

												<b class="arrow"></b>
											</li>
										</ul>
									</li>
										<li class="">
										<a href="javascript:void(0)" class="dropdown-toggle">
											<i class="menu-icon fa fa-pencil orange"></i>
											第四阶段
											<b class="arrow fa fa-angle-down"></b>
										</a>

										<b class="arrow"></b>

										<ul class="submenu">
											<li class="">
												<a href="javascript:void(0)">
													<i class="menu-icon fa fa-plus purple"></i>
													添加商品
												</a>

												<b class="arrow"></b>
											</li>

											<li class="">
												<a href="javascript:void(0)">
													<i class="menu-icon fa fa-eye pink"></i>
													查看商品
												</a>

												<b class="arrow"></b>
											</li>
										</ul>
									</li>
								</ul>
							</li>
											<!-- 三级菜单end -->
												<li class="">
														<a href="#" class="dropdown-toggle">
															<i class="menu-icon fa fa-list"></i>
															<span class="menu-text"> 任务管理 </span>
															<b class="arrow fa fa-angle-down"></b>
														</a>
										<b class="arrow"></b>
														<ul class="submenu">
																		<li class="">
																			<a href="${pageContext.request.contextPath}/page/daibanManage.jsp" target="fname">
																				<i class="menu-icon fa fa-caret-right"></i>
																				待办任务管理
																			</a>
																			<b class="arrow"></b>
																		</li>
																			<li class="">
																			<a href="${pageContext.request.contextPath}/page/yibanManage.jsp" target="fname">
																				<i class="menu-icon fa fa-caret-right"></i>
																				已办任务管理
																			</a>
																			<b class="arrow"></b>
																		</li>
																			<li class="">
																			<a href="${pageContext.request.contextPath}/page/lishiManage2.jsp" target="fname">
																				<i class="menu-icon fa fa-caret-right"></i>
																				历史任务管理
																			</a>
																			<b class="arrow"></b>
																		</li>
													</ul>
											</li>
											
											<!-- 开始 -->
											<shiro:hasRole name="学生">
																	<li class="">
														<a href="#" class="dropdown-toggle">
															<i class="menu-icon fa fa-pencil-square-o"></i>
															<span class="menu-text"> 业务管理 </span>
															<b class="arrow fa fa-angle-down"></b>
														</a>
										<b class="arrow"></b>
														<ul class="submenu">
																		<li class="">
																			<a href="${pageContext.request.contextPath}/page/leaveManage.jsp" target="fname">
																				<i class="menu-icon fa fa-caret-right"></i>
																				请假申请
																			</a>
																			<b class="arrow"></b>
																		</li>
													</ul>
											</li>
												</shiro:hasRole>
											<!-- 结束 -->
					</ul>
					
			</div>
			<div class="main-content">
			       		<div class="breadcrumbs" id="breadcrumbs">
									<ul class="breadcrumb">
										<li>
											<i class="ace-icon fa fa-home home-icon"></i>
											<a href="index.html">UI库首页</a>
										</li>
									</ul><!-- /.breadcrumb -->
									<div class="nav-search" id="nav-search">
										<form class="form-search">
											<span class="input-icon">
												<input type="text"  placeholder="请输入关键字 ..."  class="nav-search-input" id="nav-search-input" autocomplete="off" />
												<i class="ace-icon fa fa-search nav-search-icon"></i>
											</span>
										</form>
									</div><!-- /.nav-search -->
				       	</div>
						<div class="page-content">
								<div class="page-content-area" >
								 <iframe  name="fname"   frameborder="0"  
								 				style="margin-left:0px ;" width=90% height="700px"   scrolling="no"
												 src="${pageContext.request.contextPath}/page/welcome.jsp">
								 </iframe>
							</div>
			</div>
			<div class="footer">
					<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span class="bigger-120">
							 统一开发平台-UI库 &copy; 2014
						</span>
					</div>
				</div>
			</div>
			</div>
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>
		<script type="text/javascript">
				window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.min.js'>"+"<"+"/script>");
			</script>
     <script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="${pageContext.request.contextPath}/static/assets/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/ace.min.js"></script>
     
</body>
</html>