package br.edu.iffarroupilha.sca.controle;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;
import br.edu.iffarroupilha.sca.modelo.Turma;

public class TurmaControle extends AControle{

	public Object buscaPorId(int id) {
		Session sessao =HibernateUtil.getFabrica().openSession();
		// criar a criteria
		Criteria c = sessao.createCriteria(Turma.class);
		c.add( Restrictions.idEq( id )  );
		
		return c.uniqueResult();
	}

}
