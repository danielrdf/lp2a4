<%@page import="com.crudjsp.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.crudjsp.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	UsuarioDao.deletarUsuario(u);
	response.sendRedirect("viewusuarios.jsp");
%>