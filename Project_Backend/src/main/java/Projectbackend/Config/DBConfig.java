package Projectbackend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import Projectbackend.dao.CategoryDAOImpl;
import Projectbackend.pojo.Category;
import Projectbackend.pojo.Supplier;
import Projectbackend.pojo.User;

@Configuration
@ComponentScan("Projectbackend")
@EnableTransactionManagement
public class DBConfig {
	
	@Bean(name = "datasource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/pawan");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("faculty");
		System.out.println("Accessing Hibernate Config datasource");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");  // change to update after all complete
		System.out.println("Hibernate Properties created");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		System.out.println("Session object Created");
		sessionBuilder.addProperties(getHibernateProperties());
		System.out.println("Properties added");
		
		sessionBuilder.scanPackages("Projectbackend.pojo");
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		System.out.println("User class added");
		return sessionBuilder.buildSessionFactory();
	}
		

	
	
	// Required Beans
	
	@Autowired
	@Bean(name="categoryDao")
	public CategoryDAOImpl getCategoryData(SessionFactory sf){
		System.out.println("2> in catDaoImpl config");
		return new CategoryDAOImpl(sf);
	}
}