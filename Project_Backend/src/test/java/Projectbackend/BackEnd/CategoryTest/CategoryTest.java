package Projectbackend.BackEnd.CategoryTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Projectbackend.Config.DBConfig;
import Projectbackend.dao.CategoryDAO;
import Projectbackend.dao.CategoryDAOImpl;
import Projectbackend.pojo.Category;
import junit.framework.TestCase;

public class CategoryTest {
	private static DBConfig config;
	static CategoryDAO categorydao;
	@BeforeClass
	public static void setup()
	{
		config=new DBConfig();
		//AnnotationConfigApplicationContext conf=new AnnotationConfigApplicationContext();
    	//conf.scan("Projectbackend");
    	//conf.refresh();
    	//System.out.println(conf.getBean("categoryDAO"));
    	categorydao= new CategoryDAOImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void Add()
	{
		Category category =new Category();
    	category.setCategoryName("Mi");
    	category.setCategoryDesc("Mi Band 3");
    	categorydao.insertCategory(category);
    	System.out.println("Value is Inserted");
	}
	@Ignore
	@Test
	public void Delete()
	{
		Category category =new Category();
		category.setCategoryId(2);
    	category.setCategoryName("Mi");
    	category.setCategoryDesc("Mi Band 3");
    	categorydao.DeleteCategory(category);
    	System.out.println("Value is Delete");
	}
	@Ignore
	@Test
	public void Update()
	{
		Category category =new Category();
		category.setCategoryId(3);
    	category.setCategoryName("Lenovo");
    	category.setCategoryDesc("Lenovo Band 3");
    	categorydao.UpdateCategory(category);
    	System.out.println("Value is Update");
	}
	@Ignore
	@Test
	public void RetriveOne()
	{
		Category c=categorydao.getCategory(3);
    	System.out.println(c.getCategoryId());
    	System.out.println(c.getCategoryDesc());
    	System.out.println(c.getCategoryName());
	}
	@Test
	public void RetriveList()
	{
		List<Category> l=categorydao.categorylist();
    	for(int i=0;i<l.size();i++)
    	{
        	System.out.print(l.get(i).getCategoryId());
    		System.out.print("    |    ");
    		System.out.print(l.get(i).getCategoryDesc());
    		System.out.print("    |    ");
    		System.out.print(l.get(i).getCategoryName());
    		System.out.println("    |    ");
    	}
	}	
}