<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link
	href="http://localhost:8080/sca.view.web/css/jquery.dataTables.min.css"
	rel="stylesheet"></link>

<script src="http://localhost:8080/sca.view.web/js/jquery.js"></script>

<script
	src="http://localhost:8080/sca.view.web/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('table').DataTable();
	})
</script>

</head>
<body>


	Formulário
	<hr>
	<table >
		<thead>
			<tr>
				<th>Descricao</th>
				<th>editar</th>
				<th>excluir</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${turmas }" var="t">
				<tr>
					<td>${t.descricao }</td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>