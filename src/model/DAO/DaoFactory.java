package model.DAO;

import java.sql.Connection;

import db.DB;
import model.DAO.imp.CategoryDaoJDBC;
import model.DAO.imp.ModelDaoJDBC;

public class DaoFactory {
	
	public static CategoryDao createCategoryDao(Connection conn) {
		CategoryDao categoryDao = new CategoryDaoJDBC(DB.getConnection());
		return categoryDao;
	}
	
	public static ModelDao createModelDao(Connection conn) {
		ModelDao modelDao = new ModelDaoJDBC(DB.getConnection());
		return modelDao;
	}
}
