package model.entities;

import java.time.LocalDate;
import java.util.Objects;

import model.services.DaoFunctions;

public class Model {
	private Integer id;
	private String name;
	private LocalDate releaseDate;
	private int cc;
	private Double price;
	private Category category;
	
	public Model() {
	}
	
	public Model(String name, LocalDate releaseDate, int cc, Double price, int categoryId) {
		id = null;
		this.name = name;
		this.releaseDate = releaseDate;
		this.cc = cc;
		this.price = price;
		this.category = DaoFunctions.findCategoryById(categoryId);
	}
	
	public Model(String name, LocalDate releaseDate, int cc, Double price) {
		id = null;
		this.name = name;
		this.releaseDate = releaseDate;
		this.cc = cc;
		this.price = price;
	}

	public Model(int id, String name, LocalDate releaseDate, int cc, Double price, int categoryId) {
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.cc = cc;
		this.price = price;
		this.category = DaoFunctions.findCategoryById(categoryId);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", releaseDate=" + releaseDate + ", cc=" + cc + ", price=" + price + "category: " + category.getName();
	}

}
