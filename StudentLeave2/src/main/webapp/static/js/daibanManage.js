$(function(){
     $.ajax({
     		async: true,
          type: "post",
          url: "../task/list.do",//向后台发送请求，后台为stuts2框架
          dataType: "json",
          data: {userId:$("#ume").val(),page:'1',rows:'5'},
          cache: false,
          success: function(data) {
 console.log(data);
for (var i = 0; i <data.rows.length; i++) {//拼接对应<th>需要的值
    				var trs = "";
    				trs+="<tr ><td >"+ data.rows[i].id
				        + "</td><td >" + data.rows[i].name
				        + "</td><td >" + data.rows[i].createTime
				        + "</td><td ><a  href='javascript:;' onclick='openFinishaTaskTb("+data.rows[i].id
				        +")'>办理任务</a>&nbsp;&nbsp;<a target='_blank' href='../task/showCurrentView.do?taskId="
				        +data.rows[i].id+"' >查看当前流程图</a>";

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
					                            url: "../task/list.do",
					                            type: "post",
					                            dataType : "json",
					                            data: {userId:$("#ume").val(),page:page,rows:'5'},
					                            cache: false,
					                            success: function (data) {
					                          	 $('tbody').empty();
					                                for (var i = 0; i <data.rows.length; i++) {
					                                	var trs = "";
					                    				trs+="<tr ><td >"+ data.rows[i].id
					                				        + "</td><td >" + data.rows[i].name
					                				        + "</td><td >" + data.rows[i].createTime
					                				        + "</td><td ><a  href='javascript:;' onclick='openFinishaTaskTb("+data.rows[i].id
					                				        +")'>办理任务</a>&nbsp;&nbsp;<a target='_blank' href='../task/showCurrentView.do?taskId="
					                				        +data.rows[i].id+"' >查看当前流程图</a>";
					                    		
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
function udp(id){
alert(id);
}
