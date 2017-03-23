package database.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mi.pojo.User;

public class UserDaoImpl implements UserDao{
	private Connection conn = null;					//数据库连接对象
	private PreparedStatement pstmt = null;			//数据库操作对象
	//通过构造方法取得数据库建立
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public boolean addUser(User user) throws Exception {
		boolean flag = false;
		String sql = "insert into users(name,passwd) values(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUsername());
		this.pstmt.setString(2, user.getPasswd());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}
	
	public User findByUsername(String name) throws Exception {
		User user = null;
		String sql = "select name from users";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setUsername(rs.getString(1));
			user.setPasswd(rs.getString(2));
		}
		this.pstmt.close();
		return user;
	}
}
