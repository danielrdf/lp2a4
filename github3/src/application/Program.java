package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;
import model.entities.Curso;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		AlunoDao alunoDao = DaoFactory.createAlunoDao();
		
		System.out.println("==== TEST 1: aluno findById ====");
		Aluno aluno = alunoDao.findById(3);
		System.out.println(aluno);
		
		System.out.println("\n==== TEST 2: aluno findByCurso ====");
		Curso curso = new Curso(2, null);
		List<Aluno> list = alunoDao.findByCurso(curso);
		for (Aluno aluno1 : list) {
			System.out.println(aluno1);
		}
		
		System.out.println("\n==== TEST 3: aluno findAll ====");
		list = alunoDao.findAll();
		for (Aluno aluno1 : list) {
			System.out.println(aluno1);
		}
		
		System.out.println("\n==== TEST 4: aluno insert ====");
		Aluno novoAluno = new Aluno(null, "Greg", "greg@gmail.com", new Date(), new Date(), curso);
		alunoDao.insert(novoAluno);
		System.out.println("Inserted! New id = " + novoAluno.getId());
		
		System.out.println("\n==== TEST 5: aluno update ====");
		aluno = alunoDao.findById(1);
		aluno.setNome("Martha Waine");
		alunoDao.update(aluno);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TEST 6: aluno delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		alunoDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
