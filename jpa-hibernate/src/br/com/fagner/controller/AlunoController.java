package br.com.fagner.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fagner.repositorio.Aluno;

public class AlunoController {

	// Abrir uma sessão
	EntityManagerFactory emf; // Serve para abrir a conexao com o mysql;
	EntityManager em; // Realiza as operações

	public AlunoController() {
		/*
		 * Vai criar nossa conexão pegando o valore do PERSISTENCE.XML do campo
		 * " <persistence-unit name="aluno" transaction-type="RESOURCE_LOCAL">"
		 * o apontamento da unidade de persistencia.
		 */

		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
	}

	/*
	 * Metodos de CRUD.
	 */

	public void salvar(Aluno VAluno) {

		em.getTransaction().begin(); // Iniciando uma transação no banco de
										// dados.
		em.merge(VAluno); // Salva nosso objecto no banco de dados
		em.getTransaction().commit();// Fazendo o commit no banco de dados.
		emf.close(); // Nesse ponto encerramos a transação.
	}

	public void remover(Aluno VAluno) {

		em.getTransaction().begin(); // Iniciando uma transação no banco de
										// dados.

		Query q = em.createNativeQuery("DELETE FROM aluno WHERE matricula =" + VAluno.getMatricula());
		q.executeUpdate();

		em.getTransaction().commit();// Fazendo o commit no banco de dados.
		emf.close(); // Nesse ponto encerramos a transação.
	}

	public List<Aluno> listaAluno() {

		em.getTransaction().begin(); // Iniciando uma transação no banco de
									// dados.
		Query consultaAlunos = em.createQuery("SELECT aluno FROM Aluno aluno");
		
		List<Aluno> listarAlunos = consultaAlunos.getResultList();
		
		em.getTransaction().commit();// Fazendo o commit no banco de dados.
		
		emf.close(); // Nesse ponto encerramos a transação.
		
		return listarAlunos;
	}

}
