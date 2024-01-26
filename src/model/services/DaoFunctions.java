package model.services;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.DAO.CategoryDao;
import model.DAO.DaoFactory;
import model.DAO.ModelDao;
import model.entities.Category;
import model.entities.Model;

public class DaoFunctions {
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static Connection conn = DB.getConnection();
	static Scanner sc = new Scanner(System.in);
	static CategoryDao catDao = DaoFactory.createCategoryDao(conn);
	static ModelDao modDao = DaoFactory.createModelDao(conn);
	static Category cat = new Category();
	static Model mod = new Model();
	
	public static void insertCategory() {
		System.out.print("Name from new category: ");
		String name = sc.next();
		cat = new Category(name);
		catDao.insert(cat);
	}
	
	public static void updateCategory() {
		System.out.print("\nID from update category: ");
		int id = sc.nextInt();
		cat = catDao.findById(id);
		System.out.print("\nNew name from category: ");
		String name = sc.next();
		cat.setName(name);
		catDao.update(cat);
	}
	
	public static void deleteCategoryById() {
		System.out.print("\nID from category delete: ");
		int id = sc.nextInt();
		catDao.deleteById(id);
	}
	
	public static Category findCategory() {
		System.out.print("\nID from category: ");
		int id = sc.nextInt();
		Category category = catDao.findById(id);
		System.out.println(category);
		
		return category;
	}
	
	public static void listAllCategory() {
		List<Category> list = catDao.findAll();
		for (Category category : list) {
			System.out.println(category);
		}
	}
	
	public static void insertModel() {
		System.out.print("Insert new model data: "
				+ "\nName: ");
		String name = sc.next();
		System.out.print("Release date (dd/MM/yyyy): ");
		LocalDate releaseDate = LocalDate.parse(sc.next(), fmt);
		System.out.print("Cavalary(cc): ");
		int cavalary = sc.nextInt();
		System.out.print("Price: ");
		Double price = sc.nextDouble();
		Model model = new Model(name,releaseDate,cavalary,price);
		modDao.insert(model);
		System.out.println(model);
	}
	
	public static void updateModel() {
		System.out.print("\nID from model: ");
		int id = sc.nextInt();
		mod = modDao.findById(id);
		System.out.print("\nNew name from model: ");
		String name = sc.next();
		mod.setName(name);
		modDao.update(mod);
	}
	
	public static void deleteModelById() {
		System.out.print("\nID from model delete: ");
		int id = sc.nextInt();
		modDao.deleteById(id);
	}
	
	public static Model findModelById() {
		System.out.print("\nID for find model: ");
		int id = sc.nextInt();
		Model model = modDao.findById(id);
		System.out.println(model);
		
		return model;
	}
	
	public static void listAllModel() {
		List<Model> list = modDao.findAll();
		for (Model model : list) {
			System.out.println(model);
		}
	}
	
}
