package Projectbackend.BackEnd;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import Projectbackend.Config.DBConfig;
import Projectbackend.dao.SupplierDAO;
import Projectbackend.dao.SupplierDAOImpl;
import Projectbackend.pojo.Supplier;

public class SupplierTest {

	static DBConfig config=new DBConfig();
	static SupplierDAO supplierdao;
	@BeforeClass
	public static void setup()
	{
		supplierdao=new SupplierDAOImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	 
	@Ignore
	@Test
	public  void addsupplier()
	{
		try
		{
		Supplier supplier=new Supplier();
		supplier.setFname("Pawan");
		supplier.setCompanyName("CIAPN");
		supplier.setEmail("Pawanmallah612@gmail.com");
		supplier.setPassword("12345678");
		supplierdao.AddSupplier(supplier);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Ignore
	@Test
	public void Deletesupplier()
	{
		try
		{
			Supplier supplier=new Supplier();
			supplier.setId(112);
			supplier.setFname("Pawan");
			supplier.setCompanyName("CIPAM");
			supplier.setEmail("Pawanmallah612@gmail.com");
			supplier.setPassword("12345678");
			
			if(supplierdao.DeleteSupplier(supplier))
			{
				System.out.println("Value Deleted");
			}
			else
			{
				System.out.println("Value is not Deleted");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Ignore
	@Test
	public void Updatesupplier()
	{
		try
		{
			Supplier supplier=new Supplier();
			supplier.setId(113);
			supplier.setFname("Aakash");
			supplier.setCompanyName("CIAPN");
			supplier.setEmail("Pawanmallah612@gmail.com");
			supplier.setPassword("12345678");
			
			if(supplierdao.UpdateSupplier(supplier))
			{
				System.out.println("Value Updated");
			}
			else
			{
				System.out.println("Value is not Updated");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Ignore
	@Test
	public void getpassword()
	{
		try
		{
			Supplier supplier=new Supplier();
			supplier.setEmail("pawanmallah612@gmail.com");
			String a=supplierdao.getSupplierpass(supplier.getEmail());
			System.out.println("Call");
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage());
		}
	}
	@Ignore
	@Test
	public void CheckLogin()
	{
		try
		{
			Supplier supplier=new Supplier();
			supplier.setEmail("Pawanmallah612@gmail.com");
			supplier.setPassword("12345678");
			//supplierdao.CheckLogin(supplier.getEmail(),"12345678");
			//List<supplier>l=new ArrayList<supplier>();
				System.out.println(supplierdao.CheckSupplierLogin(supplier.getEmail(),"12345678"));
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage());
		}
	}
	@Ignore
	@Test
	public void Exist()
	{
		System.out.println(supplierdao.ExistSupplierEmail("Pawanmallah612@gmail.com"));
	}
}
