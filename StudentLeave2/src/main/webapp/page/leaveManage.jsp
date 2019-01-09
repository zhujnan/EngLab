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

<!-- 结束 -->
		<input type="hidden" value="${username}" id="ume"/>
		<div class="main-container" id="main-container">
		<div class="page-content">
			<button id="loading-btn" type="button"  class="btn btn-primary" data-toggle="modal" data-target="#mod1">请假申请</button>
			<div class="modal fade" id="mod1" tabindex="-1">
						<div class="modal-dialog modal-sm" style="z-index:2041;width:600px">
								<div class="modal-content">
									<div class="modal-header">
												<button class="close" data-dismiss="modal"><span>&times;</span></button>
															<h4 class="modal-title">请假申请</h4>
									</div>
									<div class="modal-body">
																<div class="input-group">
																		<span class="input-group-addon">请假天数：</span>
																					<input type="text"  id="leaveDays" class="form-control" placeholder="请输入请假天数">
																</div>
																<div class="input-group">
																			<span class="input-group-addon">请假原因：</span>
																			<div class="pos-rel">
																				<textarea class="form-control limited autosize-transition"  name="leaveReason"  id="limited" maxlength="50"></textarea>
																			</div>
																			<input type="hidden" id="userId" value="${username}"/>
			 																<input type="hidden" id="state" value="未提交"/>
																</div>
									</div>
									<div class="modal-footer">
											<button class="btn btn-white btn-info btn-bold" id="applay">
												<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i>
												保存
											</button>
									</div>
							</div>
					</div>
		</div><!-- model end -->
			
			<table class="table table-striped table-bordered table-hover"  id="tb">
			<thead>
						<tr>
								<th class="center">
														<label class="position-relative">
															<input type="checkbox" class="ace" />
															<span class="lbl"></span>
														</label>
									</th>
													<th>编号</th>
													<th>请假日期</th>
													<th>请假天数</th>
													<th class="hidden-480">请假原因</th>
													<th class="hidden-480">审核状态</th>
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
		<div id="modal-table" class="modal fade" tabindex="-1">
									<div class="modal-dialog" style="z-index:2041;">
										<div class="modal-content">
											<div class="modal-header no-padding">
												<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													请假流程
												</div>
											</div>
											<div class="modal-body  no-padding">
												<table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
													<thead>
														<tr>
															<th>批注时间</th>
															<th>批注人</th>
															<th>批注信息</th>
														</tr>
													</thead>
													<tbody id="pizhu">
													</tbody>
												</table>
											</div>

											<div class="modal-footer no-margin-top">
												<button class="btn btn-sm btn-danger pull-left" data-dismiss="modal">
													<i class="ace-icon fa fa-times"></i>
													关闭
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div><!-- /.modal-dialog -->
			</div>
	</div>
	<!-- 弹窗开始 -->
			<!-- <script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
		</script> -->

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
		<script type="text/javascript" src="../static/js/page.js"></script>
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
				
				/*    $.ajax({
			     		async: true,
			          type: "post",
			          url: "../leave/save.do",//向后台发送请求，后台为stuts2框架
			          dataType: "json",
			          data: {leaveDays:$("#leaveDays").val(),leaveReason:$("#limited").val(),user.id:$("#user.id").val(),state:$("#state").val()},
			          cache: false,
			          success: function(data) {
			        	  alert(data.success);
						},
						error:function(){
							alert("失败");
							}
						}); 
			})*/
 
		</script>
</body>
</html>