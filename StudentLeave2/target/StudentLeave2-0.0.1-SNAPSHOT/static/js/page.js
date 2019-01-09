$(function(){
     $.ajax({
     		async: true,
          type: "post",
          url: "../leave/list.do",//向后台发送请求，后台为stuts2框架
          dataType: "json",
          data: {userId:$("#ume").val(),page:'1',rows:'5'},
          cache: false,
          success: function(data) {
/**
 * 1.如何在后端来执行分页查询，并将日期类型的数据转换为对应的json格式
   2.如果处理服务端响应的json字符串，并凭借到表格当中   
 */
 console.log(data);
for (var i = 0; i <data.rows.length; i++) {//拼接对应<th>需要的值
    				var trs = "";
    				trs+="<tr ><td >" +" "
				    +"</td><td >"+ data.rows[i].id
				        + "</td><td >" + data.rows[i].leaveDate
				        + "</td><td >" + data.rows[i].leaveDays
				        + "</td><td>" +data.rows[i].leaveReason
				        + "</td>";
    			if(data.rows[i].state=="未提交"){
    			/*	trs+=  + data.rows[i].state+"</span></td>";*/
    			    	trs+="<td ><span class='label label-info arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td><a  href='javascript:;' onclick='startApply("+data.rows[i].id+")'>提交申请</a></td></tr>";
    			    }else if(data.rows[i].state=='审核通过'){
    			    	trs+="<td ><span class='label label-success arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td><a    role='button' href='javascript:del("+data.rows[i].processInstanceId+")' >查看历史批注</a></td></tr>";
    			    	//trs+="<a  href='#modal-table' role='button' class='blue' data-toggle='modal'>查看历史批注</a></td>"；
    			    }else if(data.rows[i].state=='审核未通过'){
    			    	//data.rows[i].state=='审核未通过'
    			      // 	trs+="<td ><span class='label label-warning'>"+ data.rows[i].state+"</span></td><td><a  href='#modal-table'   role='button' class='blue' data-toggle='modal'>查看历史批注</a></td>";
    			      	trs+="<td ><span class='label label-success arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td><a    role='button'  class='blue' data-toggle='modal' href='javascript:;' onclick='del("+data.rows[i].processInstanceId+");>' 查看历史批注</a></td></tr>";
    			    }else{
    			     	trs+="<td ><span class='label label-danger arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td></td></tr>";
    			    }
 $('#tbody').append(trs);
};

//$("#tb").html('tbody');
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
					                            url: "../leave/list.do",
					                            type: "post",
					                            dataType : "json",
					                            data: {userId:$("#ume").val(),page:page,rows:'5'},
					                            cache: false,
					                            success: function (data) {
					                            
					                          	 $('tbody').empty();
					                                for (var i = 0; i <data.rows.length; i++) {
					                                	var trs = "";
					                    				trs+="<tr ><td >" +" "
					                				    +"</td><td >"+ data.rows[i].id
					                				        + "</td><td >" + data.rows[i].leaveDate
					                				        + "</td><td >" + data.rows[i].leaveDays
					                				        + "</td><td>" +data.rows[i].leaveReason
					                				        + "</td>";
					                    			if(data.rows[i].state=="未提交"){
					                    			    	trs+="<td ><span class='label label-info arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td><a  href='javascript:;' onclick='startApply("+data.rows[i].id+")'>提交申请</a></td></tr>";
					                    			    }else if(data.rows[i].state=='审核通过'){
					                    			    	trs+="<td ><span class='label label-success arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td><a    role='button' href='javascript:del("+data.rows[i].processInstanceId+")' >查看历史批注</a></td></tr>";
					                    			    }else if(data.rows[i].state=='审核未通过'){
					                    			      	trs+="<td ><span class='label label-success arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td><a    role='button'  class='blue' data-toggle='modal' href='javascript:;' onclick='del("+data.rows[i].processInstanceId+");>' 查看历史批注</a></td></tr>";
					                    			    }else{
					                    			     	trs+="<td ><span class='label label-danger arrowed-in arrowed-in-right'>"+ data.rows[i].state+"</span></td><td></td></tr>";
					                    			    }
					                 $('#tbody').append(trs);
					                                };
					                            }//success
					                        });
					                  
					          }    }
        	  $('#pageLimit').bootstrapPaginator(options);
					        	  
          }
          
     });  
});

function del(id){
	 $.ajax({ url : "../task/listHistoryCommentWithProcessInstanceId.do",
		 async : true, 
		 type : "POST",
		 data : {  "processInstanceId" : id }, 
		 // 成功后开启模态框 
		 success : showQuery, 
		 error : function() { alert("请求失败"); },
		 dataType : "json" });
}
function showQuery(data){
	 $('#pizhu').empty();
	for (var i = 0; i <data.rows.length; i++) {//拼接对应<th>需要的值
		var trs = " ";
		trs+="<tr ><td >"+data.rows[i].time
	        + "</td><td >" + data.rows[i].userId
	        + "</td><td >" + data.rows[i].message
	        + "</td></tr>;"
	        $('#pizhu').append(trs);
			}
	$('#modal-table').modal('show');
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
			 		//$("#dg").datagrid("reload");
					  window.location.reload();
				}else{
					alert("系统提示请假申请提交失败，请联系系统管理员！");
				}
			}, 
		 error : function() { alert("请求失败"); },
		 dataType : "json" });
}
function udp(id){
alert(id);
}
