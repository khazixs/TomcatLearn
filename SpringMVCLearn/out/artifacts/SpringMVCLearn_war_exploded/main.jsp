<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2019/11/21
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
main.jsp<br/>
request:${requestScope.req}<br/>
session:${sessionScope.session}<br/>
sessionParam:${sessionScope.sessionParam}<br/>
application:${applicationScope.application}
<hr/>
map:${requestScope.key}
<hr/>
model:${requestScope.model}
<hr/>
mav:${requestScope.mav}

</body>
</html>
