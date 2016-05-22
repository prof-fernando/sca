package br.edu.iffarroupilha.sca.controle;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;
import br.edu.iffarroupilha.sca.modelo.Aluno;

public class AlunoControle  extends AControle{

	public Object buscaPorId(int id) {
		Session sessao =HibernateUtil.getFabrica().openSession();
		// criar a criteria
		Criteria c = sessao.createCriteria(Aluno.class);
		c.add( Restrictions.idEq( id )  );
		
		 return c.uniqueResult();
	}

}
