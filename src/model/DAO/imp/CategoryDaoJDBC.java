package model.DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.DAO.CategoryDao;
import model.entities.Category;

public class CategoryDaoJDBC implements CategoryDao {
	private Connection conn;

	Scanner sc = new Scanner(System.in);

	public CategoryDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Category category) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO category (name) " + " VALUES" + " (?);");

			st.setString(1, category.getName());
			int RowsAffected = st.executeUpdate();
			if (RowsAffected > 0) {
				System.out.printf("\nNew category has been inserted");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Category category) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE category SET name = (?) WHERE ID = (?);");

			st.setInt(2, category.getId());
			st.setString(1, category.getName());
			
			System.out.println(category);
			
			int RowsAffected = st.executeUpdate();
			if (RowsAffected > 0) {
				System.out.printf("\nCategory has been updated!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(int id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("delete from category WHERE id = ?;");

			st.setInt(1, id);
			int RowsAffected = st.executeUpdate();
			if (RowsAffected > 0) {
				System.out.printf("\nCategory has been deleted");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Category findById(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Category cat = null;

		try {
			st = conn.prepareStatement("SELECT * FROM category " + "WHERE id = ?;");

			st.setInt(1, id);

			rs = st.executeQuery();

			while (rs.next()) {
				cat = instantiateCategory(rs);
			}
			return cat;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Category> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		Category cat = null;
		List<Category> list = new ArrayList<>();

		try {
			st = conn.prepareStatement("SELECT * FROM category ORDER BY 'name';");

			rs = st.executeQuery();

			while (rs.next()) {
				cat = instantiateCategory(rs);
				list.add(cat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return list;
		
	}

	private Category instantiateCategory(ResultSet rs) throws SQLException {
		Category cat = new Category(rs.getInt("ID"), rs.getString("name"));
		return cat;
	}

}
