package br.com.fagner.main;

import br.com.fagner.controller.AlunoController;
import br.com.fagner.repositorio.Aluno;

public class ExecutaHibernateRemover {

	public static void main(String[] args) {

		Aluno AlunoNovo = new Aluno();
		AlunoController removeRegistro = new AlunoController();

		AlunoNovo.setMatricula("99984567");
		removeRegistro.remover(AlunoNovo);

	}

}
