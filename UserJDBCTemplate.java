package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import controller.user;

public class UserJDBCTemplate {
	 private DataSource dataSource;
	 private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }
	   
	   public void create(String name, String email,String password,int type) {
		      String SQL = "insert into user (name, email,password,type) values (?, ?, ?, ?)";
		      jdbcTemplateObject.update( SQL, name, email,password,type);
		      System.out.println("Created Record Name = " + name + " email = " + email);
		     
		   }
	   
	   public List<user> listUsers() {
		      String SQL = "select * from user";
		      
		      //List <user> users = jdbcTemplateObject.query(SQL, new UserMapper());
		      List<user> customers = new ArrayList<user>();
		  	
		  	List<Map> rows = getJdbcTemplate().queryForList(SQL);
		  	for (Map row : rows) {
		  		user customer = new user();
		  		customer.setId((Integer)row.get("id"));
		  		customer.setName((String)row.get("name"));
		  				  		customers.add(customer);
		  	}
		      return customers;
		   }
	   
}
