package application;

import java.sql.Connection;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.DAO.CategoryDao;
import model.DAO.DaoFactory;
import model.DAO.ModelDao;
import model.entities.Category;
import model.entities.Model;

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
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
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
				
				//---------------------------FIND CATEGORY BY ID-------------------------------------------
				//System.out.print("\nID from category: ");
				//int id = sc.nextInt();
				//Category category = catDao.findById(id);
				//System.out.println(category);
				
				
				//----------------------------LIST ALL CATEGORIES-----------------------------------
				//List<Category> list = catDao.findAll();
				//for (Category category : list) {
				//	System.out.println(category);
				//}
				
				//-----------------------------INSERT MODEL-------------------------------------
				//System.out.print("Name from nee model: ");
				//String name = sc.next();
				//System.out.print("Release date (dd/MM/yyyy): ");
				//LocalDate releaseDate = LocalDate.parse(sc.next(), fmt);
				//System.out.print("Cavalary(cc): ");
				//int cavalary = sc.nextInt();
				//System.out.print("Price: ");
				//Double price = sc.nextDouble();
				//Model model = new Model(name,releaseDate,cavalary,price);
				//modDao.insert(model);
				//System.out.println(model);
				
				//---------------------------UPDATE MODEL--------------------------------------
				//System.out.print("\nID from model: ");
				//int id = sc.nextInt();
				//mod = modDao.findById(id);
				//System.out.print("\nNew name from model: ");
				//String name = sc.next();
				//mod.setName(name);
				//modDao.update(mod);
				
				//---------------------------DELETE BY ID-----------------------------------------
				//System.out.print("\nID from model: ");
				//int id = sc.nextInt();
				//modDao.deleteById(id);
				
				//---------------------------FIND MODEL BY ID-------------------------------------------
				//System.out.print("\nID from model: ");
				//int id = sc.nextInt();
				//Model model = modDao.findById(id);
				//System.out.println(model);
				
				//----------------------------LIST ALL MODELS-----------------------------------
				//List<Model> list = modDao.findAll();
				//for (Model model : list) {
				//	System.out.println(model);
				//}
				

				
				
				
				

			}
		}catch(DbException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection();
			sc.close();
		}
	}

}
