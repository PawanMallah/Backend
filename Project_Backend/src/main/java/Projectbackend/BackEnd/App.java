package Projectbackend.BackEnd;

import java.util.ArrayList;
import java.util.List;

import Projectbackend.Config.DBConfig;
import Projectbackend.dao.CategoryDAO;
import Projectbackend.dao.CategoryDAOImpl;
import Projectbackend.pojo.Category;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	DBConfig config=new DBConfig();
    	CategoryDAO categorydao; 
    	
    	categorydao= new CategoryDAOImpl(config.getSessionFactory(config.getH2DataSource()));
    	
    	Category category =new Category();
    	category.setCategoryId(2);
    	category.setCategoryDesc("Mi Band 2");
    	category.setCategoryName("Mi");
    	//------Insert------
    	//if(categorydao.insertCategory(category))
    	//{
    	//	System.out.println("Value is Inserted");
    	//}
    	//else
    	//{
    	//	System.out.println("Value is not Inserted");
    	//}
    	//------Delete------
    	//if(categorydao.DeleteCategory(category))
    	//{
    	//	System.out.println("Value is Deleted");
    	//}
    	//else
    	//{
    	//	System.out.println("Value is not Not Deleted");
    	//}
    	//------Update------
    	//if(categorydao.UpdateCategory(category))
    	//{
    	//	System.out.println("Value is Update");
    	//}
    	//else
    	//{
    	//	System.out.println("Value is not Not Update");
    	//}
    	//----Retrive One Record --------
    	//Category c=categorydao.getCategory(3);
    	//System.out.println(c.getCategoryId());
    	//System.out.println(c.getCategoryDesc());
    	//System.out.println(c.getCategoryName());
    	
    	//Retrive All Record
    	//List<Category> l=categorydao.categorylist();
    	//for(int i=0;i<l.size();i++)
    	//{
        //	System.out.print(l.get(i).getCategoryId());
    	//	System.out.print("    |    ");
    	//	System.out.print(l.get(i).getCategoryDesc());
    	//	System.out.print("    |    ");
    	//	System.out.print(l.get(i).getCategoryName());
    	//	System.out.println("    |    ");
    	//}
    	
    }
}
