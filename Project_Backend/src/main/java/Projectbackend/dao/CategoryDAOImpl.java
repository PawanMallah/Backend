package Projectbackend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import Projectbackend.pojo.Category;


@Repository("categoryDAO")
@Service
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionfactory = sessionFactory;
		System.out.println("2> in catDaoImpl const.");
	}
	//@Transactional
	public Boolean insertCategory(Category category) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Boolean DeleteCategory(Category category) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Boolean UpdateCategory(Category category) {
		try
		{
			Session session =sessionfactory.openSession();
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
			return true;
			}catch(Exception e)
			{
				return false;
			}
	}
	
	public Category getCategory(int CategoryId) {
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			Category c=session.get(Category.class, CategoryId);
			return c;
		
	}

	public List<Category> categorylist() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from Category");
		List<Category> list=new ArrayList<Category>();
		list=q.list();
		session.close();
		return list;
	}

}
