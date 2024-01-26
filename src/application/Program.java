package application;

import java.sql.Connection;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.DAO.CategoryDao;
import model.DAO.DaoFactory;
import model.DAO.ModelDao;
import model.entities.Category;
import model.entities.Model;
import model.services.DaoFunctions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Category cat = null;
		Model mod = null;
		
		try {
			if(conn == null) {
				DB.getConnection();
				
				CategoryDao catDao = DaoFactory.createCategoryDao(conn);
				ModelDao modDao = DaoFactory.createModelDao(conn);
				
				//-------------------Category Functions------------------------
				
				//DaoFunctions.insertCategory();
				
				//DaoFunctions.updateCategory();
				
				//DaoFunctions.deleteCategoryById();
				
				//DaoFunctions.findCategory();
				
				//DaoFunctions.listAllCategory();
				
				//-------------------Model Functions---------------------------
				
				//DaoFunctions.insertModel();
				
				//DaoFunctions.updateModel();
				
				//DaoFunctions.deleteModelById();
				
				//DaoFunctions.findModelById();
				
				//DaoFunctions.listAllModel();
				
				System.out.println("Iniciando testes");
				//DaoFunctions.insertCategory();
				//DaoFunctions.listAllCategory();
				//DaoFunctions.deleteCategoryById();
				//DaoFunctions.updateCategory();
				
				DaoFunctions.insertModel();
				DaoFunctions.listAllModel();
				DaoFunctions.insertModel();
				DaoFunctions.updateModel();
				DaoFunctions.deleteModelById();
				DaoFunctions.listAllModel();
				
				
				

			}
		}catch(DbException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection();
			sc.close();
		}
	}

}
