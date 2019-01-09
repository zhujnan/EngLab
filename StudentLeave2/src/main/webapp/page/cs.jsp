<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/style/jsmind.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jsmind.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="jsmind_container"></div>

        <script type="text/javascript">
            var mind = {
                // 3 data formats were supported ...
                // see Documents for more information
            };
            var options = {
                container:'jsmind_container',
                theme:'orange',
                editable:true
            };
            var jm = new jsMind(options);
            jm.show(mind);
        </script>
</body>
</html>