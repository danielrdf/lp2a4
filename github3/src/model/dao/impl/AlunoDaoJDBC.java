package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO aluno "
					+ "(nome, email, dataIngresso, dataConclusao, idCurso) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getEmail());
			st.setDate(3, new java.sql.Date(aluno.getDataIngresso().getTime()));
			st.setDate(4, new java.sql.Date(aluno.getDataConclusao().getTime()));
			st.setInt(5, aluno.getCurso().getId());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					aluno.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Aluno aluno) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE aluno "
					+ "SET nome = ?, email = ?, dataIngresso = ?, dataConclusao = ?, idCurso = ? "
					+ "WHERE id = ?");
			
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getEmail());
			st.setDate(3, new java.sql.Date(aluno.getDataIngresso().getTime()));
			st.setDate(4, new java.sql.Date(aluno.getDataConclusao().getTime()));
			st.setInt(5, aluno.getCurso().getId());
			st.setInt(6, aluno.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM aluno WHERE id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT aluno.*, curso.nome as Curso "
					+ "FROM aluno JOIN curso "
					+ "ON aluno.idCurso = curso.id "
					+ "ORDER BY nome");
			
			rs = st.executeQuery();
			
			List<Aluno> list = new ArrayList<>();
			Map<Integer, Curso> map = new HashMap<>();
			
			while (rs.next()) {
				
				Curso curso1 = map.get(rs.getInt("idCurso"));
				
				if (curso1 == null) {
					curso1 = instantiateCurso(rs);
					map.put(rs.getInt("idCurso"), curso1);
				}
				
				Aluno aluno = instantiateAluno(rs, curso1);
				list.add(aluno);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Aluno> findByCurso(Curso curso) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT aluno.*, curso.nome as Curso "
					+ "FROM aluno JOIN curso "
					+ "ON aluno.idCurso = curso.id "
					+ "WHERE idCurso = ? "
					+ "ORDER BY nome");
			
			st.setInt(1, curso.getId());
			
			rs = st.executeQuery();
			
			List<Aluno> list = new ArrayList<>();
			Map<Integer, Curso> map = new HashMap<>();
			
			while (rs.next()) {
				
				Curso curso1 = map.get(rs.getInt("idCurso"));
				
				if (curso1 == null) {
					curso1 = instantiateCurso(rs);
					map.put(rs.getInt("idCurso"), curso1);
				}
				
				Aluno aluno = instantiateAluno(rs, curso1);
				list.add(aluno);
			}
			return list;
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
