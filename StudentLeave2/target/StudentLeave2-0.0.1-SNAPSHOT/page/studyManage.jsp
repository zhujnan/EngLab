<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>jsMind</title>
    <link type="text/css" rel="stylesheet" href="../static/style/jsmind.css" />
    <style type="text/css">
        #jsmind_container{
            width:800px;
            height:500px;
            border:solid 1px #ccc;
            /*background:#f4f4f4;*/
            background:#f4f4f4;
        }
    </style>
</head>
<body>
		<div id="jsmind_container"></div>
		<div>hhh</div>
<script type="text/javascript" src="../static/js/jsmind.js"></script>
<script type="text/javascript" src="../static/js/jsmind.draggable.js"></script>
<script type="text/javascript">
    function load_jsmind(){
        var mind = {
            "meta":{
                "name":"demo",
                "author":"hizzgdev@163.com",
                "version":"0.2",
            },
            "format":"node_array",
            "data":[
                {"id":"root", "isroot":true, "topic":"java软件开发"},
///zhujn/articles/5469107.html
                {"id":"javase", "parentid":"root", "topic":"javase", "background-color":"#0000ff"},
                {"id":"sub11", "parentid":"javase", "topic":"<a href='https://pan.baidu.com/s/1qXqfNOYoGR796dtg4A3v_w' >baidu</a>"},
                {"id":"sub12", "parentid":"javase", "topic":"sub12"},
                {"id":"sub13", "parentid":"javase", "topic":"sub13"},

                {"id":"数据库", "parentid":"root", "topic":"数据库"},
                {"id":"sub21", "parentid":"数据库", "topic":"sub21"},
                {"id":"sub22", "parentid":"数据库", "topic":"sub22","foreground-color":"#33ff33"},

                {"id":"前端", "parentid":"root", "topic":"前端"},
            ]
        };
        var options = {
            container:'jsmind_container',
            editable:true, //是否启用编辑
            theme:'primary',//主题
            support_html:true,//是否支持
            mode :'full'     
        }
        var jm = jsMind.show(options,mind);
        // jm.set_readonly(true);
        // var mind_data = jm.get_data();
        // alert(mind_data);
        jm.add_node("sub2","sub23", "new node", {"background-color":"red"});
        jm.set_node_color('sub21', 'green', '#ccc');
    }

    load_jsmind();
</script>
</body>
</html>