package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
public class MainApp {

	public static void main(String[] args) {

		 ApplicationContext context = new ClassPathXmlApplicationContext("user_jdbc.xml");

		 UserJDBCTemplate UserJDBCTemplate = 
	         (UserJDBCTemplate)context.getBean("UserJDBCTemplate");
		 System.out.println("------Records Creation--------" );
		 //UserJDBCTemplate.create("mona", "mona@gmail.com", "1234", 2);
		 UserService user=new UserService();
	     user.getUsers();      
	}

}
