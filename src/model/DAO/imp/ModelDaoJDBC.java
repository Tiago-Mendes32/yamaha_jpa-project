package model.DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.DbException;
import model.DAO.ModelDao;
import model.entities.Category;
import model.entities.Model;

public class ModelDaoJDBC implements ModelDao {
	private Connection conn;

	Scanner sc = new Scanner(System.in);

	public ModelDaoJDBC(Connection conn) {
		this.conn = conn;
	}

@Override
public void insert(Model model) {
	PreparedStatement st = null;
	
	try {
		st = conn.prepareStatement("INSERT INTO category (name) "
				+ " VALUES"
				+ " (?);");
		
		System.out.print("Insert the name from new category: ");
		String modelName = sc.nextLine();
		st.setString(1, modelName);
		Boolean status = st.execute();
		if(status) {
			System.out.printf("\nNew category has been inserted");
		}
	} catch(SQLException e) {
		throw new DbException(e.getMessage());
	}
	}

	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Model> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
