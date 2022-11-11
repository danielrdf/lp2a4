<%@page import="com.github2.dao.AlunoDao"%>
<jsp:useBean id="a" class="com.github2.bean.Aluno"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>

<%
	AlunoDao.deletarAluno(a);
	response.sendRedirect("viewusuarios.jsp");
%>
