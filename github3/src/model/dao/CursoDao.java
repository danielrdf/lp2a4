package model.dao;

import java.util.List;

import model.entities.Curso;

public interface CursoDao {
	
	void insert(Curso curso);
	void update(Curso curso);
	void deleteById(Integer id);
	Curso findById(Integer id);
	List<Curso> findAll();

}
