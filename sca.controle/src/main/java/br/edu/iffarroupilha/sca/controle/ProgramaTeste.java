package br.edu.iffarroupilha.sca.controle;

import java.util.Date;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;
import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

public class ProgramaTeste {

	public static void main(String[] args) {
		
		
		
		Turma t = new Turma();
		t.setDescricao("Turma SI 2014 ");
		
		Aluno a = new Aluno();
		a.setNome("Paulo ");
		a.setDataNascimento(   new Date()   );
		// chave estrangeira
		a.setTurma(t);
		
		
		// grava os dados
		new TurmaControle().gravar(t);
		new AlunoControle().gravar(a);
		
		// fecha a fabrica de conexao
		HibernateUtil.getFabrica().close();
		
	}
	
	
	
}
