package Projectbackend.BackEnd;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import Projectbackend.Config.DBConfig;
import Projectbackend.dao.ProductDAO;
import Projectbackend.dao.ProductDAOImpl;
import Projectbackend.pojo.Product;

public class ProductTest {

	private static DBConfig config;
	static ProductDAO productdao;
	@BeforeClass
	public static void setup()
	{
		config=new DBConfig();
		//AnnotationConfigApplicationContext conf=new AnnotationConfigApplicationContext();
    	//conf.scan("Projectbackend");
    	//conf.refresh();
    	//System.out.println(conf.getBean("ProductDAO"));
    	productdao= new ProductDAOImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void Add()
	{
		Product product =new Product();
    	product.setProductName("MI Note 5");
    	product.setProductDesc("12MP+5MP dual rear camera with portrait mode PDAF, HDR, flash light ");
    	product.setSupplierName("Pawan112");
    	product.setPrice(10999);
    	byte[] b=new byte[10];
    	b[0]=10;
    	product.setProductImage(b);
    	productdao.insertProduct(product);
    	System.out.println("Value is Inserted");
	}
	@Ignore
	@Test
	public void Delete()
	{
		Product product =new Product();
		product.setProductId(2);
    	product.setProductName("Mi");
    	product.setProductDesc("Mi Band 3");
    	product.setSupplierName("Pawan112");
    	product.setPrice(10999);
    	productdao.DeleteProduct(product);
    	System.out.println("Value is Delete");
	}
	@Ignore
	@Test
	public void Update()
	{
		Product Product =new Product();
		Product.setProductId(3);
    	Product.setProductName("Lenovo");
    	Product.setProductDesc("Lenovo Band 3");
    	productdao.UpdateProduct(Product);
    	System.out.println("Value is Update");
	}
	@Ignore
	@Test
	public void RetriveOne()
	{
		Product c=productdao.getProduct(3);
    	System.out.println(c.getProductId());
    	System.out.println(c.getProductDesc());
    	System.out.println(c.getProductName());
	}
	@Ignore
	@Test
	public void RetriveList()
	{
		List<Product> l=productdao.Productlist();
    	for(int i=0;i<l.size();i++)
    	{
        	System.out.print(l.get(i).getProductId());
    		System.out.print("    |    ");
    		System.out.print(l.get(i).getProductDesc());
    		System.out.print("    |    ");
    		System.out.print(l.get(i).getProductName());
    		System.out.print("    |    ");
    		System.out.print(l.get(i).getPrice());
    		System.out.print("    |    ");
    		System.out.print(l.get(i).getSupplierName());
    		System.out.println("    |    ");
    	}
	}
}
