package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.entities.Aluno;
import model.entities.Curso;

public class AlunoDaoJDBC implements AlunoDao {
	
	private Connection conn;
	
	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Aluno aluno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Aluno aluno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluno findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT aluno.*, curso.nome as Curso "
					+ "FROM aluno JOIN curso "
					+ "ON aluno.idCurso = curso.id "
					+ "WHERE aluno.id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Curso curso = instantiateCurso(rs);
				Aluno aluno = instantiateAluno(rs, curso);
				return aluno;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Aluno instantiateAluno(ResultSet rs, Curso curso) throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setId(rs.getInt("id"));
		aluno.setNome(rs.getString("nome"));
		aluno.setEmail(rs.getString("email"));
		aluno.setDataIngresso(rs.getDate("dataIngresso"));
		aluno.setDataConclusao(rs.getDate("dataConclusao"));
		aluno.setCurso(curso);
		return aluno;
	}

	private Curso instantiateCurso(ResultSet rs) throws SQLException {
		Curso curso = new Curso();
		curso.setId(rs.getInt("idCurso"));
		curso.setNome(rs.getString("Curso"));
		return curso;
	}

	@Override
	public List<Aluno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findByCurso(Curso curso) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT aluno.*, curso.nome as 'Curso' "
					+ "FROM aluno JOIN curso "
					+ "ON aluno.idCurso = curso.id "
					+ "WHERE idCurso = ? "
					+ "ORDER BY nome");
			
			st.setInt(1, curso.getId());
			
			rs = st.executeQuery();
			
			List<Aluno> list = new ArrayList<>();
			
			////////// VIDEO 283 MINUTO 6:00 /////////////////
			while (rs.next()) {
				Curso curso = instantiateCurso(rs);
				Aluno aluno = instantiateAluno(rs, curso);
				list.add(aluno);
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
