<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição do aluno</title>
</head>
<body>

	<%@page import="com.github2.bean.Aluno, com.github2.dao.AlunoDao" %>
	
	<%
		String matricula = request.getParameter("matricula");
		Aluno aluno = AlunoDao.getRegistroByMatricula(Integer.parseInt(matricula));
	%>
	
	<h1>Edição de aluno</h1>
	
	<form action="editaluno.jsp" method="post">
		<input type="hidden" name="matricula" value="<%=aluno.getMatricula()%>"/>
		<table>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" value="<%=aluno.getNome()%>"/></td>
			</tr>
			<tr>
				<td>Endereço: </td>
				<td><input type="text" name="endereco" value="<%=aluno.getEndereco()%>"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Editar aluno"></input></td>
			</tr>
		</table>
	</form>

</body>
</html>