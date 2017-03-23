package database.service;

import java.util.List;
import database.dao.*;
import database.db.DBConnection;
import com.mi.pojo.User;

public class UserService implements UserDao{
	private DBConnection dbconn = null;			//定义数据库连接类
	private UserDao dao = null;					//声明DAO对象
	//在构造方法中实例化数据库连接，同时实例化dao对象
	public UserService() throws Exception {
		this.dbconn = new DBConnection();
		this.dao = new UserDaoImpl(this.dbconn.getConnection());
		//实例化ProductDaoImpl的实现类
	}
	
	public boolean addUser(User user) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findByUsername(user.getUsername()) == null) {
				//如果要插入的用户名不存在
				flag = this.dao.addUser(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}
	
	public User findByUsername(String name) throws Exception {
		User user = null;
		try {
			user = this.dao.findByUsername(name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return user;
	}
}
