<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>ArtManagement</title>
    <!-- 当Management模块启动时，会直接访问欢迎页面index.jsp，
    并通过该页面访问ArtServlet获得全部油画数据并转发到canvas_list.jsp-->
    <meta http-equiv="refresh" content="0;url=<%=request.getContextPath()%>/art/list.do">
  </head>
</html>
