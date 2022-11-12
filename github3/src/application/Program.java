package application;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

public class Program {

	public static void main(String[] args) {

		AlunoDao alunoDao = DaoFactory.createAlunoDao();
		
		System.out.println("=== TEST 1: aluno findById ===");
		Aluno aluno = alunoDao.findById(3);
		
		System.out.println(aluno);
		
	}

}
