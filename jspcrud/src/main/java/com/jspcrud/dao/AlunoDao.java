package com.jspcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jspcrud.bean.Aluno;
import com.mysql.jdbc.PreparedStatement;

public class AlunoDao {
	
	// método para listar todos os alunos
	public static List<Aluno> getAllAlunos() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Aluno> list = new ArrayList<>();

		try {
			conn = DB.getConnection();
			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM aluno");
			rs = ps.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEndereco(rs.getString("endereco"));
				list.add(aluno);
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
