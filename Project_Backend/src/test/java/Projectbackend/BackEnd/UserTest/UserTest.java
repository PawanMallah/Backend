package Projectbackend.BackEnd.UserTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import Projectbackend.Config.DBConfig;
import Projectbackend.dao.UserDAO;
import Projectbackend.dao.UserDAOImpl;
import Projectbackend.pojo.User;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class UserTest {
	static DBConfig config=new DBConfig();
	static UserDAO userdao;
	@BeforeClass
	public static void setup()
	{
		userdao=new UserDAOImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	 
	@Ignore
	@Test
	public  void addUser()
	{
		try
		{
		User user=new User();
		user.setFname("Pawan");
		user.setLname("Mallah");
		user.setAddress("Jogeshwari");
		user.setEmail("Pawanmallah612@gmail.com");
		user.setPassword("12345678");
		userdao.AddUser(user);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Ignore
	@Test
	public void DeleteUser()
	{
		try
		{
			User user=new User();
			user.setId(34);
			user.setFname("Pawan");
			user.setLname("Mallah");
			user.setAddress("Jogeshwari");
			user.setEmail("Pawanmallah612@gmail.com");
			user.setPassword("12345678");
			
			if(userdao.DeleteUser(user))
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
	public void UpdateUser()
	{
		try
		{
			User user=new User();
			user.setId(36);
			user.setFname("Pawan");
			user.setLname("Mallah");
			user.setAddress("Malad");
			user.setEmail("Pawanmallah612@gmail.com");
			user.setPassword("12345678");
			
			if(userdao.UpdateUser(user))
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
			User user=new User();
			user.setEmail("Pawanmallah612@gmail.com");
			String a=userdao.getpass(user.getEmail());
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
			User user=new User();
			user.setEmail("Pawanmallah612@gmail.com");
			user.setPassword("12345678");
			//userdao.CheckLogin(user.getEmail(),"12345678");
			//List<User>l=new ArrayList<User>();
				System.out.println(userdao.CheckLogin(user.getEmail(),"12345678"));
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage());
		}
	}
	@Ignore
	@Test
	public void Details()
	{
		User u=new User();
		u.setEmail("Pawanmallah612@gmail.com");
		u=userdao.Details(u.getEmail());
		System.out.println(u.getId());
		System.out.println(u.getFname());
		System.out.println(u.getLname());
		System.out.println(u.getAddress());
		System.out.println(u.getEmail());
		System.out.println(u.getPassword());
	}
	@Test
	public void Exist()
	{
		System.out.println(userdao.ExistEmail("Pawanmallah612@gmail.com"));
	}
}

