package Projectbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import Projectbackend.pojo.Supplier;
import Projectbackend.pojo.User;

public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	SessionFactory sessionfactory;
	public SupplierDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	public boolean AddSupplier(Supplier Supplier) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.save(Supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean DeleteSupplier(Supplier Supplier) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.delete(Supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean UpdateSupplier(Supplier Supplier) {
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(Supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public String getSupplierpass(String email) {
		try
		{
			String pass = null;
			Session session=sessionfactory.openSession();
			Query q=session.createQuery("from Supplier");
			List<Supplier> supplier=new ArrayList<Supplier>();
			
			supplier=q.list();
			
			for(int i=0;i<supplier.size();i++)
			{
				if(email.equals(supplier.get(i).getEmail()))
				{
					Supplier s=new Supplier();
					s.setFname(supplier.get(i).getFname());
					
					s.setId(supplier.get(i).getId());
					s.setPassword(supplier.get(i).getPassword());
					pass=supplier.get(i).getPassword();
					//list.set(0, u);
				}
				System.out.println(supplier.get(i).getEmail());
				System.out.println(supplier.get(i).getPassword());
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
	public boolean CheckSupplierLogin(String email, String Pass) {
		String Password;
		Password=getSupplierpass(email);
		if(Pass.equals(Password)&&Pass!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public Supplier SupplierDetails(String email) {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from Supplier");
		List<Supplier> s=new ArrayList<Supplier>();
		
		s=q.list();
		Supplier supplier=new Supplier();
		for(int i=0;i<s.size();i++)
		{
			if(email.equals(s.get(i).getEmail()))
			{
				supplier.setFname(s.get(i).getFname());
				supplier.setCompanyName(s.get(i).getCompanyName());
				supplier.setId(s.get(i).getId());
				supplier.setPassword(s.get(i).getPassword());
				supplier.setEmail(s.get(i).getEmail());
			}
			System.out.println(s.get(i).getEmail());
			System.out.println(s.get(i).getPassword());
		}
		return supplier;
	}
	public boolean ExistSupplierEmail(String email) {
		try
		{
			String pass = null;
			Session session=sessionfactory.openSession();
			Query q=session.createQuery("from Supplier");
			List<Supplier> supplier=new ArrayList<Supplier>();
			supplier=q.list();
			for(int i=0;i<supplier.size();i++)
			{
				if(email.equals(supplier.get(i).getEmail()))
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
