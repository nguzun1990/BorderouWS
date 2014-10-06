package md.usarb.borderou.dao;

import md.usarb.borderou.vo.User;

public interface UserDao {
	 
	User findByUserName(String username);
 
}