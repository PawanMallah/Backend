package Projectbackend.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Projectbackend.pojo.Category;
import Projectbackend.pojo.User;

public class UserDAOImpl implements UserDAO {

	public static List<User> list;
	SessionFactory sessionfactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionfactory=sessionFactory;
		
	}
	public boolean AddUser(User user) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean DeleteUser(User user) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean UpdateUser(User user) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public String getpass(String email) {
		try
		{
			String pass = null;
			Session session=sessionfactory.openSession();
			Query q=session.createQuery("from User");
			List<User> user=new ArrayList<User>();
			list=new ArrayList<User>();
			user=q.list();
			
			for(int i=0;i<user.size();i++)
			{
				if(email.equals(user.get(i).getEmail()))
				{
					User u=new User();
					u.setFname(user.get(i).getFname());
					u.setLname(user.get(i).getLname());
					u.setAddress(user.get(i).getAddress());
					u.setId(user.get(i).getId());
					u.setPassword(user.get(i).getPassword());
					pass=user.get(i).getPassword();
					//list.set(0, u);
				}
				System.out.println(user.get(i).getEmail());
				System.out.println(user.get(i).getPassword());
			}
			System.out.println(pass);
			return pass;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

	}
	public boolean CheckLogin(String Email, String Pass) {
		String Password;
		Password=getpass(Email);
		if(Pass.equals(Password)&&Pass!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public User Details(String email) {
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from User");
		List<User> user=new ArrayList<User>();
		list=new ArrayList<User>();
		user=q.list();
		User u=new User();
		for(int i=0;i<user.size();i++)
		{
			if(email.equals(user.get(i).getEmail()))
			{
				
				u.setFname(user.get(i).getFname());
				u.setLname(user.get(i).getLname());
				u.setAddress(user.get(i).getAddress());
				u.setId(user.get(i).getId());
				u.setPassword(user.get(i).getPassword());
				u.setEmail(user.get(i).getEmail());
			}
			System.out.println(user.get(i).getEmail());
			System.out.println(user.get(i).getPassword());
		}
		return u;
	}
	public boolean ExistEmail(String email) {
		try
		{
			String pass = null;
			Session session=sessionfactory.openSession();
			Query q=session.createQuery("from User");
			List<User> user=new ArrayList<User>();
			user=q.list();
			for(int i=0;i<user.size();i++)
			{
				if(email.equals(user.get(i).getEmail()))
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}

		
}




