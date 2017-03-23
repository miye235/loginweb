package database.dao;

import java.util.List;
import com.mi.pojo.User;

public interface UserDao {
	public boolean addUser(User user) throws Exception;
	
	//public List<User> findAll(String user_name) throws Exception;
	
	public User findByUsername(String name) throws Exception;
}
