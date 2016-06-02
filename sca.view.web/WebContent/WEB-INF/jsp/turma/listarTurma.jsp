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
		$('table').DataTable({
			  "language": { 
		            "lengthMenu": "Registros: _MENU_ ",
		            "zeroRecords": "Nenhum registro encontrado!",
		            "info": "Página _PAGE_ de _PAGES_",
		            "infoEmpty": "Sem registros",
		            "infoFiltered": "(buscando em _MAX_ registros)",
		            "search" : "Buscar:",
		            "paginate" : {
		            	"first" : "Primeiro",
		            	"last": "Último",
		            	"next" : ">>",
		            	"previous" : "<<"
		            }
		        }
		        
			
		});
	})
</script>

</head>
<body>


	<form method="post" 
	  action="http://localhost:8080/sca.view.web/turma/gravar" >
	   <label for="txtDescricao" >Descricao: </label>
	   <input type="text" id="txtDescricao"  name="turma.descricao" >
	   <input type="submit" value="gravar">
	</form>
	
	<h2>
	${MSG}
	</h2>
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