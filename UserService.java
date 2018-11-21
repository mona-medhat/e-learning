package controller;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controller.user;  

@Path("/UserService") 
public class UserService {  
	UserJDBCTemplate userDao = new UserJDBCTemplate();  
   
@GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_XML)
   public List<user> getUsers(){ 
      return userDao.listUsers();
   }  
}