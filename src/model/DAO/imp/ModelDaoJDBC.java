package model.DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.DAO.ModelDao;
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
			st = conn.prepareStatement("INSERT INTO Model (name, releaseDate, cc, price, CategoryId) " + " VALUES" + " (?,?,?,?,?);");

			st.setString(1, model.getName());
			st.setDate(2, java.sql.Date.valueOf(model.getReleaseDate()));
			st.setInt(3, model.getCc());
			st.setDouble(4, model.getPrice());
			st.setInt(5, model.getCategory().getId());
			
			int RowsAffected = st.executeUpdate();
			if (RowsAffected > 0) {
				System.out.printf("\nNew model has been inserted");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Model model) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE Model SET name=?, releaseDate=?, cc=?, price=?, CategoryId=? WHERE ID=?;");

			st.setString(1, model.getName());
			st.setDate(2, java.sql.Date.valueOf(model.getReleaseDate()));
			st.setInt(3, model.getCc());
			st.setDouble(4, model.getPrice());
			st.setInt(5, model.getCategory().getId());
			st.setInt(6, model.getId());
			
			System.out.println(model);
			
			int RowsAffected = st.executeUpdate();
			if (RowsAffected > 0) {
				System.out.printf("\nModel has been updated!");
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
			st = conn.prepareStatement("delete from model WHERE id = ?;");

			st.setInt(1, id);
			int RowsAffected = st.executeUpdate();
			if (RowsAffected > 0) {
				System.out.printf("\nModel has been deleted");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Model findById(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Model mod = null;

		try {
			st = conn.prepareStatement("SELECT * FROM model " + "WHERE id = ?;");

			st.setInt(1, id);

			rs = st.executeQuery();

			while (rs.next()) {
				mod = instantiateModel(rs);
			}
			return mod;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Model> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		Model mod = null;
		List<Model> list = new ArrayList<>();

		try {
			st = conn.prepareStatement("SELECT * FROM Model ORDER BY 'name';");

			rs = st.executeQuery();

			while (rs.next()) {
				mod = instantiateModel(rs);
				list.add(mod);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return list;
		
	}

	private Model instantiateModel(ResultSet rs) throws SQLException {
		Model mod = new Model(rs.getInt("ID"), rs.getString("name"), rs.getDate("releaseDate").toLocalDate(), rs.getInt("cc"), rs.getDouble("price"), rs.getInt("CategoryId"));
		return mod;
	}

}
