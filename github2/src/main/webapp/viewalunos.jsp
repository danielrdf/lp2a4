<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualização de Alunos</title>
</head>
<body>
	<%@ page import="com.github2.dao.AlunoDao, com.github2.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1>Listagem de usuários</h1>
	
	<%
		List<Aluno> list = AlunoDao.getAllAlunos();
		request.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr>
			<th>Matrícula</th>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${list}" var="aluno">
			<tr>
				<td>${aluno.getMatricula()}</td>
				<td>${aluno.getNome()}</td>
				<td>${aluno.getEndereco()}</td>
				<td><a href="editform.jsp?matricula=${aluno.getMatricula()}">Editar</a></td>
				<td><a href="deletealuno.jsp?matricula=${aluno.getMatricula()}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addalunoform.jsp">Adicionar novo aluno</a>
	
</body>
</html>