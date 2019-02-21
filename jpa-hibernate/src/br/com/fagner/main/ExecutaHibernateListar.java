package br.com.fagner.main;

import java.util.List;

import br.com.fagner.controller.AlunoController;
import br.com.fagner.repositorio.Aluno;

public class ExecutaHibernateListar {

	public static void main(String[] args) {
		
		AlunoController listaRegistro = new AlunoController();
		
	
		List<Aluno> alunosListados = listaRegistro.listaAluno();
		
		for (int i = 0; i < alunosListados.size(); i++) {
			
			System.out.println(" Nome: "      + alunosListados.get(i).getNome()  +
					           " Idade: "     + alunosListados.get(i).getIdade() +
					           " Madricula: " + alunosListados.get(i).getMatricula()) ;
			
		}
		
	}	
}
