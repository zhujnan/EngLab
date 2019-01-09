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
		<div class="main-container" id="main-container">
				<div class="main-content">
						<div class="page-content">
								<div class="page-content-area">
													<div class="row">
							<div class="col-xs-12">
										<div class="row">
													<form class="form-horizontal" role="form">
																<div class="widget-box">
																				<div class="widget-header header-color-blue">
																					<h5 class="bigger lighter" style="display:inline-block;">
																						<i class="icon-table"></i>
																						领导审批
																					</h5>
																				</div>
																				<div class="widget-body">
																				<br/>
																							<div class="row">
																									<div class="col-xs-12">
																														<div class="col-xs-6">
																																	<div class="form-group">
																																			<label class="col-sm-3 control-label no-padding-right" for="form-field-1">请假人：</label>
																																			<div class="col-sm-9">
																																						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="leavePerson" />
																																			</div>
																																	</div>
																														</div>
																														<div class="col-xs-6">
																																	<div class="form-group">
																																			<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 请假天数：</label>
																																			<div class="col-sm-9">
																																						<input type="text" id="leaveDays" />
																																			</div>
																																	</div>
																														</div>
																														
																														<div class="form-group">
																																	<label class="col-sm-2 control-label no-padding-right" for="limited">请假原因：&nbsp;&nbsp;&nbsp;&nbsp;</label>
																																	<div class="col-sm-10">
																																		<div class="pos-rel">
																																			<textarea class="form-control limited autosize-transition " id="leaveReason" maxlength="50" style="resize: none;width: 400px;"></textarea>
																																		</div>
																																	</div>
																														</div>
																															<div class="form-group">
																																	<label class="col-sm-2 control-label no-padding-right" for="limited">批注：&nbsp;&nbsp;&nbsp;&nbsp;</label>
																																	<div class="col-sm-10">
																																		<div class="pos-rel">
																																			<textarea class="form-control limited autosize-transition " id="limited" maxlength="50" style="resize: none;width: 400px;"></textarea>
																																		</div>
																																	</div>
																														</div>
																														<!-- 按钮begin -->
																																
																														<div class="clearfix form-actions">
																															<div class="col-md-offset-4 col-md-8">
																																<button onclick="st(1)" class="btn btn-info" type="button">
																																	<i class="ace-icon fa fa-check bigger-110"></i>
																																	批准
																																</button>
																																<button onclick="st(2)" class="btn" type="reset">
																																	<i class="ace-icon fa fa-undo bigger-110"></i>
																																	驳回
																																</button>
																															</div>
																														</div>
																														<!-- end -->
																											</div>
																							</div><!-- row -->
																							
																				</div><!-- widget-body -->
																</div>
												</form>
										</div>
							</div>
					</div>
							
								<div class="hr hr-18 dotted hr-double"></div>
					<div class="row">
											<div class="col-xs-12">
																	<div class="row">
																					<div class="widget-box">
																											<div class="widget-header header-color-blue">
																												<h5 class="bigger lighter" style="display:inline-block;">
																													<i class="icon-table"></i>
																													批注列表
																												</h5>
																											</div>
																											<div class="widget-body">
																														<div class="widget-main no-padding">
																																		<table class="table table-striped table-bordered table-hover">
																																					<thead class="thin-border-bottom">
																																									<tr>
																																										<th>
																																											<i class="icon-user"></i>
																																										批注时间
																																										</th>
																										
																																										<th>
																																											<i>@</i>
																																											批注人
																																										</th>
																																										<th class="hidden-480">批注信息</th>
																																									</tr>
																																					</thead>
																							
																																					<tbody id="pizhu">
																																			</tbody>
																																		</table>
																														</div>
																									</div><!-- /span -->
																						</div>
																	</div>
											</div>
						</div>
								</div><!-- page-content-area -->
						</div><!-- page-content -->
				</div><!-- main-content -->
		</div> <!-- main-container -->
				
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
		<script type="text/javascript">
		$(function(){
			 $.ajax({
		     		async: true,
		          type: "post",
		          url: "../leave/getLeaveByTaskId.do",//向后台发送请求，后台为stuts2框架
		          dataType: "json",
		          data: {taskId:'${param.taskId}'},
		          cache: false,
		          success: function(result) {
		        		var leave=result.leave;
		        		if(leave.user==null){
		        			$("#leavePerson").val(" ");
		        		}else{
		        			$("#leavePerson").val(leave.user.firstName+leave.user.lastName);
		        		}
		    			$("#leaveDays").val(leave.leaveDays);
		    			$("#leaveReason").val(leave.leaveReason);
		        		//alert(leave.user.firstName+leave.user.lastName);
			    			
					},
					error:function(){
						alert("失败aa");
						}
					});  
			 $.ajax({
		     		async: true,
		          type: "post",
		          url: "../task/listHistoryComment.do",//向后台发送请求，后台为stuts2框架
		          dataType: "json",
		          data: {taskId:'${param.taskId}'},
		          cache: false,
		          success: function(data) {
		        		alert("hi")
		        		for (var i = 0; i <data.rows.length; i++) {//拼接对应<th>需要的值
	var trs = "";
	trs+="<tr ><td >"+ data.rows[i].time
     + "</td><td >" + data.rows[i].userId
     + "</td><td >" + data.rows[i].message
     + "</td></tr>";

$('#pizhu').append(trs);}
					},
					error:function(){
						alert("失败bb");
						}
					}); 

		});
		
		function st(state){
			alert("领导提交页面"+$("#leaveDays").val());
			alert("领导批注内容"+$("#limited").val());
			 $.ajax({
		     		async: true,
		          type: "post",
		          url: "../task/audit_ld.do",//向后台发送请求，后台为stuts2框架
		          dataType: "json",
		          data: {state:state,taskId:'${param.taskId}',leaveDays:$("#leaveDays").val(),comment:$("#limited").val()},
		          cache: false,
		          success: function(result) {
		        	  alert("jjj");
		        	  if(result.success){
		        		  alert("提交成功");
		        	  }else{
		        		  alert("提交失败");
		        		  return;
		        	  }
					},
					error:function(){
						alert("提交失败2");
						}
					}); 
		}
/* 		function submit(state){
			alert("state"+state);
			 $.ajax({
		     		async: true,
		          type: "post",
		          url: "../task/audit_ld.do",//向后台发送请求，后台为stuts2框架
		          dataType: "json",
		          data: {state:state},
		          cache: false,
		          success: function(result) {
		        	  alert("jjj");
		        	  if(result.success){
		        		  alert("提交成功");
		        	  }else{
		        		  alert("提交失败");
		        		  return;
		        	  }
					},
					error:function(){
						alert("提交失败2");
						}
					}); 
		} */
		
				//分页
		</script>
</body>
</html>