package Projectbackend.dao;

import java.util.List;

import Projectbackend.pojo.Category;



public interface CategoryDAO {
	public Boolean insertCategory(Category category);
	public Boolean DeleteCategory(Category category);
	public Boolean UpdateCategory(Category category);
	public Category getCategory(int CategoryId);
	public List<Category> categorylist(); 
}
