$(function(){
     $.ajax({
     		async: true,
          type: "post",
          url: "../task/finishedList.do",//向后台发送请求
          dataType: "json",
          data: {groupId:$("#group").val(),page:'1',rows:'5'},
          cache: false,
          success: function(data) {
for (var i = 0; i <data.rows.length; i++) {//拼接对应<th>需要的值
    				var trs = "";
    				trs+="<tr ><td >"+ data.rows[i].id
				        + "</td><td >" + data.rows[i].name
				        + "</td><td >" + data.rows[i].createTime
				        +"</td><td>"+data.rows[i].endTime
				        + "</td><td ><a  href='javascript:;' onclick='openListActionDialog("+data.rows[i].id
				        +")'>流程执行过程</a><a  href='javascript:;' onclick='openListCommentDialog("+data.rows[i].id+")'>历史批注</a><a target='_blank' href='../processDefinition/showViewByTaskId.do?taskId="
				        +data.rows[i].id+"' >查看当前流程图</a></td>";
    					$('#tbody').append(trs);
		};

var currentPage = data.CurrentPage; //当前页数
var pageCount = data.total/5; //总页数
					        	  var options = {
					                  bootstrapMajorVersion: 3, //版本
					                  currentPage: currentPage, //当前页数
					                  totalPages: pageCount, //总页数
					                  numberOfPages: 5,
					                  shouldShowPage:true,//是否显示该按钮
					                  itemTexts: function (type, page, current) {
					                      switch (type) {
					                          case "first":
					                              return "首页";
					                          case "prev":
					                              return "上一页";
					                          case "next":
					                              return "下一页";
					                          case "last":
					                              return "末页";
					                          case "page":
					                              return page;
					                      }
					                  },
					                  onPageClicked: function (event, originalEvent, type, page) {
					                      $.ajax({
					                            async: true,
					                            url: "../task/finishedList.do",
					                            type: "post",
					                            dataType : "json",
					                            data: {groupId:$("#group").val(),page:page,rows:'5'},
					                            cache: false,
					                            success: function (data) {
					                          	 $('tbody').empty();
					                                for (var i = 0; i <data.rows.length; i++) {
					                                	var trs = "";
					                            		trs+="<tr ><td >"+ data.rows[i].id
					            				        + "</td><td >" + data.rows[i].name
					            				        + "</td><td >" + data.rows[i].createTime
					            				        +"</td><td>"+data.rows[i].endTime
					            				        + "</td><td ><a  href='javascript:;' onclick='openListActionDialog("+data.rows[i].id
					            				        +")'>流程执行过程</a>&nbsp;&nbsp;<a  href='javascript:;' onclick='openListCommentDialog("+data.rows[i].id+")'>历史批注</a>&nbsp;&nbsp;<a target='_blank' href='../processDefinition/showViewByTaskId.do?taskId="
					            				        +data.rows[i].id+"' >查看当前流程图</a></td>";
					                 $('#tbody').append(trs);
					                                };
					                            }//success
					                        });
					                  
					          }    }
        	  $('#pageLimit').bootstrapPaginator(options);
					        	  
          }
          
     });  
});

function openFinishaTaskTb(taskId){
	 $.ajax({ url : "../task/redirectPage.do",
		 async : true, 
		 type : "POST",
		 data : {  "taskId" : taskId }, 
		 // 成功后开启模态框 
		 success : function(result){
			 alert(result.url);//'办理任务',,'icon-check'
			 window.location.href=result.url+'?taskId='+taskId;
		 }, 
		 error : function() { alert("请求失败"); },
		 dataType : "json" });
}

function startApply(id){
	$.ajax({ url : "../leave/startApply.do",
		 async : true, 
		 type : "POST",
		 data : {leaveId : id }, 
		 // 成功后开启模态框 
		 success : 	function(result){
				if(result.success){
					 alert("系统提示请假申请提交成功，目前审核中，请耐心等待！");
					  window.location.reload();
				}else{
					alert("系统提示请假申请提交失败，请联系系统管理员！");
				}
			}, 
		 error : function() { alert("请求失败"); },
		 dataType : "json" });
}
/*
 * 流程执行过程
 * */
	function openListActionDialog(id){ 
					 $.ajax({ url : "../processInstance/listAction.do",
								 async : true, 
								 type : "POST",
								 data : {  "taskId" : id }, 
								 // 成功后开启模态框 
								 success : showQuery, 
								 error : function() { alert("请求失败"); },
								 dataType : "json" });
	}
	function showQuery(data){
						 $('#process').empty();
						for (var i = 0; i <data.rows.length; i++) {//拼接对应<th>需要的值
							var trs = " ";
							trs+="<tr ><td >"+data.rows[i].id
						        + "</td><td >" + data.rows[i].activityName
						        + "</td><td >" + data.rows[i].startTime
						        + "</td><td >" + data.rows[i].endTime
						        + "</td></tr>;"
						        $('#process').append(trs);
								}
						$('#mod1').modal('show');
	}
	
	/*
	 * 历史批注
	 * */
	function openListCommentDialog(id){ 
		 $.ajax({ url : "../task/listHistoryComment.do",
			 async : true, 
			 type : "POST",
			 data : {  "taskId" : id }, 
			 // 成功后开启模态框 
			 success : showQuery2, 
			 error : function() { alert("请求失败"); },
			 dataType : "json" });
	}
	function showQuery2(data){
		 $('#pizhu').empty();
		for (var i = 0; i <data.rows.length; i++) {//拼接对应<th>需要的值
			var trs = " ";
			trs+="<tr ><td >"+data.rows[i].time
		        + "</td><td >" + data.rows[i].userId
		        + "</td><td >" + data.rows[i].message
		        + "</td></tr>;"
		        $('#pizhu').append(trs);
				}
		$('#mod2').modal('show');
}
