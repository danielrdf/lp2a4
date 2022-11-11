package com.github2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.github2.bean.Aluno;
import com.mysql.jdbc.PreparedStatement;

public class AlunoDao {

	// método para conexão com BD
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjsp", "root", "12345678");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	

	// método para inserir novo aluno
	public static int salvarAluno(Aluno a) {
		int status = 0;

		try {
			Connection conn = getConnection();
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO aluno (nome, endereco) VALUES (?, ?)");
			ps.setString(1, a.getNome());
			ps.setString(2, a.getEndereco());

			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	

	// método para listar todos os alunos
	public static List<Aluno> getAllAlunos() {
		List<Aluno> list = new ArrayList<Aluno>();

		try {
			Connection conn = getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM aluno");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEndereco(rs.getString("endereco"));
				list.add(aluno);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	
	// método para retornar aluno por número de matrícula
	public static Aluno getRegistroByMatricula(int matricula) {
		Aluno aluno = null;

		try {
			Connection conn = getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM aluno WHERE matricula=?");
			ps.setInt(1, matricula);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEndereco(rs.getString("endereco"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return aluno;
	}

	
	// método para atualizar aluno
	public static int updateAluno(Aluno a) {
		int status = 0;

		try {
			Connection conn = getConnection();
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("UPDATE aluno SET nome=?, endereco=? WHERE matricula=?");
			ps.setString(1, a.getNome());
			ps.setString(2, a.getEndereco());

			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	// método para deletar aluno
	public static int deletarAluno(Aluno a) {
		int status = 0;

		try {
			Connection conn = getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM aluno WHERE matricula=?");
			ps.setInt(1, a.getMatricula());

			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
