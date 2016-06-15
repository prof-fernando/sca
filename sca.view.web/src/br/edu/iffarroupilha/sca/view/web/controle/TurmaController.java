package br.edu.iffarroupilha.sca.view.web.controle;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.edu.iffarroupilha.sca.controle.TurmaControle;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * Controlador web com vraptor para a entidade de turma
 * </p>
 * 
 * @author fernando
 */
@Resource
public class TurmaController {

	private Result result;

	public TurmaController(Result r) {
		this.result = r;
	}

	public void listarTurma() {

		TurmaControle tc = new TurmaControle();
		result.include("turmas", tc.listar(Turma.class));
	}
	
	public void gravar(Turma turma){
		new TurmaControle().gravar(turma);
		result.include("MSG","Gravado com sucesso!");
		// apos gravar redireciona ao metodo de listagem
		result.redirectTo(this).listarTurma();
	}
	
	@Path("turma/excluir/{id}")
	public void excluir(int id){
		TurmaControle controle = new TurmaControle();
		// carrega objeto antes de excluir
		Turma t = (Turma) controle.buscaPorId(id);
		// exclui a informação
		controle.remover(t);
		result.include("MSG","Excluído com sucesso!");
		// apos gravar redireciona ao metodo de listagem
		result.redirectTo(this).listarTurma();	
	}
	
	@Path("turma/editar/{id}")
	public void editar(int id){
		TurmaControle controle = new TurmaControle();
		// carrega objeto antes de excluir
		Turma t = (Turma) controle.buscaPorId(id);
		result.include("TURMA",t);
		// apos gravar redireciona ao metodo de listagem
		result.redirectTo(this).listarTurma();	
	}
}
