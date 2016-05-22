package br.edu.iffarroupilha.sca.view.web.controle;

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
}
