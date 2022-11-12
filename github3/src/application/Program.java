package application;

import java.util.Date;

import model.entities.Aluno;
import model.entities.Curso;

public class Program {

	public static void main(String[] args) {

		Curso obj = new Curso(1, "Arquitetura");
		
		Aluno aluno = new Aluno(21, "Bob", "bob@gmail.com", new Date(), new Date(), obj);
		
		System.out.println(aluno);
		
	}

}
