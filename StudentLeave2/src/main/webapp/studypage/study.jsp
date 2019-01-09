<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<meta name="description" content="Restyling jQuery UI Widgets and Elements" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace.min.css" id="main-ace-style" />
		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath}/static/assets/js/ace-extra.min.js"></script>
		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>
<body>
		<!-- pagecontentareaBegin -->
					<div class="page-content-area">
						<div class="row">
							<div class="col-xs-12">
								<div id="user-profile-2" class="user-profile">
										<div class="tabbable">
											<ul class="nav nav-tabs padding-18">
												<li class="active">
													<a data-toggle="tab" href="#home">
														<i class="green icon-user bigger-120"></i>
														详细资料
													</a>
												</li>


												<li>
													<a data-toggle="tab" href="#friends">
														<i class="blue icon-group bigger-120"></i>
														联系人
													</a>
												</li>

												<li>
													<a data-toggle="tab" href="#pictures">
														<i class="pink icon-picture bigger-120"></i>
														个人相册
													</a>
												</li>
											</ul>

											<div class="tab-content no-border padding-24">
												<div id="home" class="tab-pane in active">
													
												</div><!-- #home -->

											
												<div id="friends" class="tab-pane">
												

													<div class="hr hr10 hr-double"></div>

													<ul class="pager pull-right">
														<li class="previous disabled">
															<a href="#">&larr; 前一页</a>
														</li>

														<li class="next">
															<a href="#">后一页 &rarr;</a>
														</li>
													</ul>
												</div><!-- /#friends -->

												<div id="pictures" class="tab-pane">
													<ul class="ace-thumbnails">
														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-1.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-2.jpg" />
																<div class="text">
																	<div class="inner">带遮罩提示的相册例子</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-3.jpg" />
																<div class="text">
																	<div class="inner">带遮罩提示的相册例子</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-4.jpg" />
																<div class="text">
																	<div class="inner">带遮罩提示的相册例子</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-5.jpg" />
																<div class="text">
																	<div class="inner">带遮罩提示的相册例子</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-6.jpg" />
																<div class="text">
																	<div class="inner">带遮罩提示的相册例子</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-1.jpg" />
																<div class="text">
																	<div class="inner">带遮罩提示的相册例子</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="${pageContext.request.contextPath}/static/assets/images/gallery/thumb-2.jpg" />
																<div class="text">
																	<div class="inner">带遮罩提示的相册例子</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="icon-link"></i>
																</a>

																<a href="#">
																	<i class="icon-paper-clip"></i>
																</a>

																<a href="#">
																	<i class="icon-pencil"></i>
																</a>

																<a href="#">
																	<i class="icon-remove red"></i>
																</a>
															</div>
														</li>
													</ul>
												</div><!-- /#pictures -->
											</div>
										</div>
									</div>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content-area -->
		<!-- pageContentAreaEnd -->
			<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>


		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/static/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/ace.min.js"></script>
		
</body>
</html>