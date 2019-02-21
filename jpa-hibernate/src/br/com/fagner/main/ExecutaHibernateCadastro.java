package br.com.fagner.main;

import br.com.fagner.controller.AlunoController;
import br.com.fagner.repositorio.Aluno;

public class ExecutaHibernateCadastro {

	public static void main(String[] args) {
		
		/*
		 * Instânciano o novo registro que vou cadastrar 
		 * Passando os dados para cadastro do registro
		 */
		
		Aluno AlunoNovo = new Aluno();
		
		/*
		 * Salvando o registro no banco de dados
		 */
		
		AlunoController salvaRegistro = new AlunoController();
		
		AlunoNovo.setNome("José Alvez");
		AlunoNovo.setIdade(50);
		AlunoNovo.setMatricula("991234567");
		
		salvaRegistro.salvar(AlunoNovo);
		
		AlunoNovo.setNome("Roberto Ameida");
		AlunoNovo.setIdade(30);
		AlunoNovo.setMatricula("9998000");
		
		salvaRegistro.salvar(AlunoNovo);
	
		
		AlunoController removeRegistro = new AlunoController();
		
		AlunoNovo.setMatricula("99984567");
		removeRegistro.remover(AlunoNovo);
		
		
		
	}

}
