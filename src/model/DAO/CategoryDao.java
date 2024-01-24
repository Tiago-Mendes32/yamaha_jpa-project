package model.DAO;

import java.util.List;

import model.entities.Category;

public interface CategoryDao{
	void insert(Category category);
	void update(Category category);
	void deleteById(int id);
	Category findById(int id);
	List<Category> findAll();
}
