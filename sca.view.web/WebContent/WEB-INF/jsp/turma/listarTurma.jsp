<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Turma</title>
<link href="http://localhost:8080/sca.view.web/css/bootstrap.min.css"
	rel="stylesheet"></link>

<link
	href="http://localhost:8080/sca.view.web/css/jquery.dataTables.min.css"
	rel="stylesheet"></link>

<script src="http://localhost:8080/sca.view.web/js/jquery.js"></script>

<script
	src="http://localhost:8080/sca.view.web/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('table').DataTable({
			"language" : {
				"lengthMenu" : "Registros: _MENU_ ",
				"zeroRecords" : "Nenhum registro encontrado!",
				"info" : "Página _PAGE_ de _PAGES_ (total _MAX_)",
				"infoEmpty" : "Sem registros",
				"infoFiltered" : "(buscando em _MAX_ registros)",
				"search" : "Buscar:",
				"paginate" : {
					"first" : "Primeiro",
					"last" : "Último",
					"next" : ">>",
					"previous" : "<<"
				}
			}

		});

		$('.btnExcluir').click(function() {
			var resposta = confirm('Tem certeza que deseja excluir?');
			return resposta;
		});

	})
</script>

</head>
<body>




	<div class="panel panel-default">
		<div class="panel-heading">Turmas</div>
		<div class="panel-body">




			<form method="post"
				action="http://localhost:8080/sca.view.web/turma/gravar"
				class="form-inline"
				>
				 <div class="form-group">
				  
				   <label for="txtDescricao">Descricao: </label>
				   <input type="text" class="form-control" required
					 id="txtDescricao" name="turma.descricao"
					 value="${TURMA.descricao }">
			   
			   </div>
			  <div class="form-group">
			  
				 <input type="hidden"
					name="turma.idTurma" value="${TURMA.idTurma }">
					
					 <input class="btn btn-success"
					type="submit" value="gravar">
					
			  </div>		
			</form>

			<c:if test="${not empty MSG }">
				<p class="alert-success">
					<span class="glyphicon glyphicon-ok   "></span> ${MSG}
				</p>
			</c:if>

			<hr>
			<table>
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
							<td><a
								href="http://localhost:8080/sca.view.web/turma/editar/${t.idTurma}">
									editar </a></td>
							<td><a class="btnExcluir"
								href="http://localhost:8080/sca.view.web/turma/excluir/${t.idTurma}">

									excluir </a></td>


						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>


</body>
</html>