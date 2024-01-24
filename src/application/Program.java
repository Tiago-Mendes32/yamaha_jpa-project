package application;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.DAO.CategoryDao;
import model.DAO.DaoFactory;
import model.entities.Category;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Category cat = null;
		
		try {
			if(conn == null) {
				DB.getConnection();
				
				CategoryDao catDao = DaoFactory.createCategoryDao(conn);
				
				//-----------------------------INSERT CATEGORY-------------------------------------
				//System.out.print("Digite o nome da nova categoria de motos: ");
				//cat = new Category(sc.next());
				//catDao.insert(cat);
				
				//---------------------------UPDATE CATEGORY--------------------------------------
				//System.out.print("\nID from category: ");
				//int id = sc.nextInt();
				//cat = catDao.findById(id);
				//System.out.print("\nNew name from category: ");
				//String name = sc.next();
				//cat.setName(name);
				//catDao.update(cat);
				
				//---------------------------DELETE BY ID-----------------------------------------
				//System.out.print("\nID from category: ");
				//int id = sc.nextInt();
				//catDao.deleteById(id);
				
				//---------------------------FIND BY ID-------------------------------------------
				//System.out.print("\nID from category: ");
				//int id = sc.nextInt();
				//Category category = catDao.findById(id);
				//System.out.println(category);
				
				
				//----------------------------LIST ALL CATEGORY-----------------------------------
				List<Category> list = catDao.findAll();
				for (Category category : list) {
					System.out.println(category);
				}
				

				
				
				
				

			}
		}catch(DbException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection();
			sc.close();
		}
	}

}
