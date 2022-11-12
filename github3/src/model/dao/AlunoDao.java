package model.dao;

import java.util.List;

import model.entities.Aluno;
import model.entities.Curso;

public interface AlunoDao {
	
	void insert(Aluno aluno);
	void update(Aluno aluno);
	void deleteById(Integer id);
	Aluno findById(Integer id);
	List<Aluno> findAll();
	List<Aluno> findByCurso(Curso curso);

}
