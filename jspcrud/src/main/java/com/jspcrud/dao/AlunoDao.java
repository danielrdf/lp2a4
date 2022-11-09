package com.jspcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jspcrud.bean.AlunoPojo;

public class AlunoDao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "12345678");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static List<AlunoPojo> getAllAlunos() {
		List<AlunoPojo> list = new ArrayList<>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM aluno");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				AlunoPojo aluno = new AlunoPojo();
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
