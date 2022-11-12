package application;

import java.util.Date;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;
import model.entities.Aluno;
import model.entities.Curso;

public class Program {

	public static void main(String[] args) {

		AlunoDao alunoDao = DaoFactory.createAlunoDao();
		
		Aluno aluno = alunoDao.findById(3);
		
		System.out.println(aluno);
		
	}

}
