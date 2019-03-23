package Projectbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import Projectbackend.pojo.Category;
import Projectbackend.pojo.Product;

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	public ProductDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionfactory = sessionFactory;
	}
	
	public Boolean insertProduct(Product product) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Boolean DeleteProduct(Product product) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Boolean UpdateProduct(Product product) {
		try
		{
			Session session =sessionfactory.openSession();
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	public Product getProduct(int productId) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Product p=session.get(Product.class, productId);
		return p;
	}

	public List<Product> Productlist() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from Product");
		List<Product> list=new ArrayList<Product>();
		list=q.list();
		session.close();
		return list;
	}

}
