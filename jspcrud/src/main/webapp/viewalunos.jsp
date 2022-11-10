<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualização de Alunos</title>
</head>
<body>
	<%@ page import="com.jspcrud.dao.AlunoDao, com.jspcrud.bean.*, java.util.*"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
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
		</tr>
		<c:forEach items="${list}" var="aluno">
			<tr>
				<td>${aluno.getMatricula()}</td>
				<td>${aluno.getNome()}</td>
				<td>${aluno.getEndereco()}</td>
				<%-- <td><a href="editform.jsp?id=${usuario.getId()}">Editar</a></td>
				<td><a href="deleteusuario.jsp?id=${usuario.getId()}">Excluir</a></td> --%>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>