<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>简单通用表格 - 表格 - 统一开发平台 - UI库</title>
		<meta name="description" content="Restyling jQuery UI Widgets and Elements" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link href="bootstrap3/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="../static/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../static/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../static/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="../static/assets/css/ace.min.css" id="main-ace-style" />
 		<script src="../static/js/jquery-3.3.1.js"></script>
 		<script src="../static/bootstrap3/js/bootstrap.min.js"></script>
<script src="../static/js/bootstrap-paginator.js"></script>
		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		<style type="text/css">
			.CSSearchTbl{ border:1px #008CD4 solid;}
			.CSSearchTbl thead{}
			.CSSearchTbl thead tr{}
			.CSSearchTbl thead tr th{  text-align:left; padding-left:10px;}
			.CSSearchTbl tbody{}
			.CSSearchTbl tbody tr{}
			.CSSearchTbl tbody tr td{  padding: 10px;}
			.CSSearchTbl tbody tr td.right{ text-align: left;}
			.CSSearchTbl tbody tr td.left{ text-align: right;}
			.table-responsive{ display: none;}
		</style>
</head>
<body class="no-skin">
<input type="hidden" value="${username}" id="ume"/>
		<div class="main-container" id="main-container">
				<div class="widget-box">
																											<div class="widget-header header-color-blue">
																												<h5 class="bigger lighter" style="display:inline-block;">
																													<i class="icon-table"></i>
																													代办任务管理
																												</h5>
																											</div>
																											<div class="widget-body">
																														<div class="widget-main no-padding">
																																		<table class="table table-striped table-bordered table-hover">
																																					<thead class="thin-border-bottom">
																																									<tr>
																																										<th>
																																											<i class="icon-user"></i>
																																										任务ID
																																										</th>
																										
																																										<th>
																																											<i>@</i>
																																											任务名称
																																										</th>
																																										<th class="hidden-480">创建时间</th>
																																										<th class="hidden-480">操作</th>
																																									</tr>
																																					</thead>
																																					<tbody id="tbody">
																																			</tbody>
																																		</table>
																																		<div  id="example" style="text-align: center">
																																    			    <ul id="pageLimit"></ul>
																																		</div>
																														</div>
																									</div><!-- /span -->
																						</div>
	</div>

		<script src="../static/assets/js/ace-extra.min.js"></script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	<!-- 	<script src="assets/js/bootstrap.min.js"></script> -->
		<script src="../static/assets/js/jquery.dataTables.min.js"></script>
		<script src="../static/assets/js/jquery.dataTables.bootstrap.js"></script>
		<!-- ace scripts -->
		<script src="../static/assets/js/ace-elements.min.js"></script>
		<script src="../static/assets/js/ace.min.js"></script>
		<script type="text/javascript" src="../static/js/daibanManage.js"></script>
		<script type="text/javascript">
			jQuery(function($) {
				$(document).on('click', 'th input:checkbox' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
			});
				$(document).on('click', '#applay' , function(){
				 alert($("#userId").val());
							 $.ajax({
						     		async: true,
						          type: "post",
						          url: "../leave/save.do",//向后台发送请求，后台为stuts2框架
						          dataType: "json",
						          data: {leaveDays:$("#leaveDays").val(),leaveReason:$("#limited").val(),userId:$("#userId").val(),state:$("#state").val()},
						          cache: false,
						          success: function(data) {
						        	//  $('#modal-table').modal('hide');
						        	  alert("申请成功");
						        	  window.location.reload();
									},
									error:function(){
										alert("失败");
										}
									}); 
			});
			})
				//分页
		</script>
</body>
</html>