<%@page import="com.github2.dao.AlunoDao"%>
<jsp:useBean id="a" class="com.github2.bean.Aluno"></jsp:useBean>
<jsp:setProperty property="*" name="a"/>

<%
	int i = AlunoDao.salvarAluno(a);
	
	if (i > 0) {
		response.sendRedirect("addaluno-success.jsp");
	}
	else {
		response.sendRedirect("addaluno-error.jsp");
	}
%>