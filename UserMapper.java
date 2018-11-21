package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import controller.user;


public class UserMapper implements RowMapper<user> {
   public user mapRow(ResultSet rs, int rowNum) throws SQLException {
      user user = new user();
      user.setId(rs.getInt("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
      user.setEmail(rs.getString("email"));
      user.setType(rs.getInt("type"));
      
      return user;
   }
}