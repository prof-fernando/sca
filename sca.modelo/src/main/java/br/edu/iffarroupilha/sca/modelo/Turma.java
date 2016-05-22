package br.edu.iffarroupilha.sca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 * Entidade para persistencia de turmas
 * </p>
 * 
 * @author fernando
 * @since 09/03/16
 */
@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurma;
	@Column(nullable = false, length = 150)
	private String descricao;

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * <p>
	 * Metodo sobrescrito para apresentar a descrição da turma quando ela for
	 * inserida na combobox
	 * </p>
	 */
	public String toString() {
		return descricao;
	}

	public boolean equals(Object obj) {
		return getIdTurma() == ((Turma) obj).getIdTurma();
	}
}
