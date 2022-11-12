package model.dao;

import db.DB;
import model.dao.impl.AlunoDaoJDBC;

public class DaoFactory {
	
	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
}
