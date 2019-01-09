<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>顶顶顶顶</title>
		<meta name="description" content="Restyling jQuery UI Widgets and Elements" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- basic styles -->
		<link href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/fullcalendar.css" />
		<!-- fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-skins.min.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<!-- inline styles related to this page -->
		<!-- ace settings handler -->
		<script src="${pageContext.request.contextPath}/static/assets/js/ace-extra.min.js"></script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body class="no-skin">
	<input type="hidden" value="${username}" id="ume"/>
		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<!-- /section:settings.box -->
					<div class="page-content-area">
					<div id="fuelux-wizard" data-target="#step-container">
												<!-- #section:plugins/fuelux.wizard.steps -->
												<ul class="wizard-steps">
													<li data-target="#step1" class="active">
														<span class="step">1</span>
														<span class="title">第一阶段</span>
													</li>

													<li data-target="#step2">
														<span class="step">2</span>
														<span class="title">第二阶段</span>
													</li>

													<li data-target="#step3">
														<span class="step">3</span>
														<span class="title">第三阶段</span>
													</li>

													<li data-target="#step4">
														<span class="step">4</span>
														<span class="title">第四阶段</span>
													</li>
												</ul>

												<!-- /section:plugins/fuelux.wizard.steps -->
											</div>
				
							<!-- 		<div class="row">
									<div class="col-sm-12">
										<h3 class="header smaller lighter green">进度条</h3>
										<div class="row">
											<div class="col-xs-12">
												#section:elements.progressbar
												<div class="progress pos-rel" data-percent="20%">
													<div class="progress-bar" style="width:20%;"></div>
												</div>

												<div class="progress progress-small progress-striped active">
													<div class="progress-bar progress-bar-warning" style="width: 20%;"></div>
												</div>
											</div>/.col
										</div>/.row
									</div>/.col
								</div>/.row -->
				
									 	<div class="row">
							<h1>日程安排</h1>
							<div class="col-xs-12">
								<div class="row">
									<div class="col-sm-9">
										<!-- <div class="space"></div> -->
										<div id="calendar"></div>
									</div>
									<div class="col-sm-3">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h4>自定义可拖拽事件</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main no-padding">
													<div id="external-events">
														<div class="external-event label-grey" data-class="label-grey">
															<i class="icon-move"></i>
															自定义可拖拽事件 1
														</div>
														<div class="external-event label-success" data-class="label-success">
															<i class="icon-move"></i>
															自定义可拖拽事件 2
														</div>
													<!-- 	<div class="external-event label-danger" data-class="label-danger">
															<i class="icon-move"></i>
															自定义可拖拽事件 3
														</div> -->
														<div class="external-event label-purple" data-class="label-purple">
															<i class="icon-move"></i>
															自定义可拖拽事件 4
														</div>
														<div class="external-event label-yellow" data-class="label-yellow">
															<i class="icon-move"></i>
															自定义可拖拽事件 5
														</div>
														<div class="external-event label-pink" data-class="label-pink">
															<i class="icon-move"></i>
															自定义可拖拽事件 6
														</div>
														<div class="external-event label-info" data-class="label-info">
															<i class="icon-move"></i>
															自定义可拖拽事件 7
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content-area -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span class="bigger-120">
							2014
						</span>
					</div>
					<!-- /section:basics/footer -->
				</div>
			</div>
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
		<!-- basic scripts -->
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->
		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="${pageContext.request.contextPath}/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/fullcalendar.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/bootbox.min.js"></script>
		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/static/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/ace.min.js"></script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
/* initialize the external events
	-----------------------------------------------------------------*/
	$('#external-events div.external-event').each(function() {   //为每一个自定义个可拓展条加上一个函数
		// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
		// it doesn't need to have a start or end
		var eventObject = {
			title: $.trim($(this).text()) // use the element's text as the event title
		};
		// store the Event Object in the DOM element so we can get to it later
	$(this).data('eventObject', eventObject);
		// make the event draggable using jQuery UI
		$(this).draggable({
			zIndex: 999,//控制当拖拽元素时，改变元素的z-index值。   使其堆叠在之上
			revert: true,      // 当元素拖拽结束后，元素是否回到原来的位置。
			revertDuration: 0  //  元素被拖拽后，回到原来位置的时间
		});
	});
	/* initialize the calendar-----------------------------------------------------------------*/
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();
	var calendar = $('#calendar').fullCalendar({
		//设置日历的头部按钮文字，值为Object对象：
		 buttonText: {  
			prev: '<i class="icon-chevron-left"></i>',
			next: '<i class="icon-chevron-right"></i>'
		},
	//用于定义日历头部的按钮和标题。
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		//数组类型的事件数据源。事件数据以数组的形式给FullCalendar调用。
		events: 
			function(start,end,callback){
            $.ajax({
                 url:"../tap/list.do",
                 type:'post',
                 data:{userId:$("#ume").val()},
                 dataType:'json',
                     success:function(data){
                    	 //请求成功时执行该函数内容，result即为服务器返回的json对象
                        var events=[];
                          for(var i =0;i<data.rows.length;i++){
                        	  events.push(data.rows[i]);    //挨个取出类别并填入类别数组
                          }
                          try {
                             callback(events);
                         } catch (e) {
                             console.info(e);
                         }
                     }
            });
       }
		,
		//是否允许事件可以被编辑，值为布尔类型，默认值为false
		editable: true,
		droppable: true, // this allows things to be dropped onto the calendar !!!
		//外部元素拖拽之drop
		drop: function(date, allDay) { // this function is called when something is dropped
			alert("allDay"+allDay);
			// retrieve the dropped element's stored Event Object
			var originalEventObject = $(this).data('eventObject'); //获取拖动条的文本值
			var $extraEventClass = $(this).attr('data-class'); //获取拖动条的 data-class属性值
			// we need to copy it, so that multiple events don't have a reference to the same object
			//我们需要复制它，以便多个事件没有对同一对象的引用
			//函数用于将一个或多个对象的内容合并到新的目标对象
			var copiedEventObject = $.extend({}, originalEventObject); //把值合并到到空对象上
			// assign it the date that was reported
			copiedEventObject.start = date;  //当前对象的起始位置
			copiedEventObject.allDay = allDay; //全天的
			copiedEventObject.allDayDefault=false;
			//如果拖动条的data-class属性有值，就将这个值赋值新对象calssName属性
			if($extraEventClass) copiedEventObject['className'] = [$extraEventClass]; 
			/*
				渲染一个新的日程事件到日程表上
				copiedEventObject:事件对象，至少有title 和start属性
				用 renderEvent 方法添加的日程会在日程表重载数据（refetches）之后消失。
				可以将stick设置为true
			*/
			// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
			$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
			// is the "remove after drop" checkbox checked?
			if ($('#drop-remove').is(':checked')) {
				// if so, remove the element from the "Draggable Events" list
				$(this).remove();
			}
		}
		,
		selectable: true,
		selectHelper: true,
		select: function(start, end, allDay) {
			/*
			start：表示你选中区域的开始时间，Date对象。
			end：表示你选中区域的结束时间，Date对象。
						当allday为true的时候，
						endDate可以包括最后一天（其实就是<和<=的区别）。
						allDay		是原始Js event对象，包含鼠标坐标等。如果是通过 select方法 选中的
			*/
			
			bootbox.prompt("创建新事件:", function(title) {
				if (title !== null) {
					 $.ajax({
		                 url:"../tap/save.do",
		                 type:'post',
		                 data:{userId:$("#ume").val(),start:start,end:end,
		                	 title:title,className: 'label-pink'},
		                 dataType:'json',
		                     success:function(data){
		                     alert("iiii");
		     				calendar.fullCalendar('renderEvent',{
								title: title,
								start: start,
								end: end,
								allDay: allDay,
								className: 'label-pink'
							},
		true); 
		            },error:function(){
		            	alert("hhhh")
		            }});
								
				}
			});
			
			calendar.fullCalendar('unselect');
		}
		,
		eventClick: function(calEvent, jsEvent, view) {
			alert(calEvent.end);
			if(calEvent.className=="label-danger"){
				return;
			}else {
				var form = $("<form action='' class='form-inline'><label>改变事件 &nbsp;</label></form>");
				form.append("<input class='middle' autocomplete=off type=text value='" + calEvent.title + "' /> ");
				form.append("<button type='submit' class='btn btn-sm btn-success'><i class='icon-ok'></i> Save</button>");
				var div = bootbox.dialog({
					message: form,
					buttons: {
						"delete" : {
							"label" : "<i class='icon-trash'></i> Delete Event",
							"className" : "btn-sm btn-danger",
							"callback": function() {
								alert(calEvent.className[0]);
								alert(calEvent.end);
								var endTime=null;
								if (calEvent.end==null){
									 endTime = calEvent.start;
								}else{
									endTime = calEvent.end;
								}
								  //begin
								  alert("endTime"+endTime);
								  var clsName = calEvent.className;
								  						 $.ajax({
																        url:"../tap/del.do",
																         type:'post',
																          data:{userId:$("#ume").val(),start:calEvent.start,end:endTime,
																          title:calEvent.title,className: calEvent.className[0]},
																          dataType:'json',
																          success:function(data){
																                     alert("成功");
																     				calendar.fullCalendar('removeEvents' , function(ev){
																																return (ev._id == calEvent._id);
																															});
																            },error:function(){
																            	alert("hhhh")
																            }});
								  //end
								//如果 idOrFilter是ID的话，会删除该ID的所有日程。idOrFilter 也可以是一个筛选函数，
								//接受 Event Object 参数，返回布尔类型参数（如果是true的话就删除）
							}
						} ,
						"close" : {
							"label" : "<i class='icon-remove'></i> Close",
							"className" : "btn-sm"
						} 
					}
				});
				form.on('submit', function(){
					calEvent.title = form.find("input[type=text]").val();
					alert(calEvent.title);
					alert(calEvent.start);
					alert(calEvent.end);
					alert(end);
					alert(calEvent.className);
					calendar.fullCalendar('updateEvent', calEvent); //方法，当更新事件时将事件渲染在日历上。
					div.modal("hide");
					return false;
				});
			}
			
			/*
				calEvent eventObject对象，包含了日程的信息 日期，标题等
				jsEvent：原声的js事件，包含，点击坐标之类的信息
				view 当前View Object
			*/
		}
	});
});
		</script>

	</body>
</html>
