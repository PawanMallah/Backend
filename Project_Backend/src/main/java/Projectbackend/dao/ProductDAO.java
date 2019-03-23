package Projectbackend.dao;

import java.util.List;

import Projectbackend.pojo.Product;

public interface ProductDAO {
	public Boolean insertProduct(Product product);
	public Boolean DeleteProduct(Product product);
	public Boolean UpdateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> Productlist();
}
