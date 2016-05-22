package br.edu.iffarroupilha.sca.controle;

import java.util.List;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;

/**
 * <p>
 * Classe abstrata que concentra as opção padrões de operação para 
 * entidades. 
 * </p>
 * @author fernando
 * @since 16/03/2016 21:56
 */
public abstract class AControle {
	/**
	 * <p>
	 * Gravar ou atualizar uma informação no banco de dados, o que
	 * define em qual tabela os dados serão persistidos é o tipo
	 * da entidade, que por sua vez é passada como parametro nesta ação
	 * 
	 * </p>
	 * @param entidade
	 */
	public void gravar(Object entidade){
		Session sessao = HibernateUtil.getFabrica().openSession();
		// abre a transação
		sessao.beginTransaction();
		// salava ou atualiza a entidade
		sessao.saveOrUpdate(entidade);
		// comita a transacao
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	/**
	 * <p>
	 * Exclui uma informação do banco de dados, a entidade a ser
	 * excluida deve conter um id.
	 * </p>
	 */
	public void remover(Object entidade){
		Session sessao = HibernateUtil.getFabrica().openSession();
		// abre a transação
		sessao.beginTransaction();
		// salava ou atualiza a entidade
		sessao.delete(entidade);
		// comita a transacao
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	/**
	 * <p>
	 * Retorna uma lista com todos os registros de uma determinada
	 * tabela, o que define a tabela de origem dos dados é classe que 
	 * é informada como parametro para esta ação. Este metodo equivale 
	 * à: SELECT * FROM tabela
	 * </p>
	 * @return
	 */	
	public List listar(Class classeEntidade){
		Session sessao = HibernateUtil.getFabrica().openSession();
		List dados = sessao.createCriteria(classeEntidade).list();
		sessao.close();
		return dados;
	}
	/**
	 * <p>
	 * Especificacao do comportamento de busca por id, cabendo
	 * as classes concretas realizar a sua implementacao
	 * </p>
	 */
	public abstract Object buscaPorId(int id);
	
}
