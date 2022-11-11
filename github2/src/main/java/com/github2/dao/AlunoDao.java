package com.github2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
	
	// método para conectar ao BD
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("")
		}
	}
	
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
