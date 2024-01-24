package model.DAO;

import java.util.List;

import model.entities.Model;

public interface ModelDao{
	void insert(Model model);
	void update(Model model);
	void deleteById(int id);
	void findById(int id);
	List<Model> findAll();
}
