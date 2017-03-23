package com.mi.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable{
	private String username = "";
	private String passwd = "";
	Map<String, String>userMap = null;
	Map<String, String>errorsMap = null;
	
	public User() {
		super();
		this.username = "";
		this.passwd = "";
		userMap = new HashMap<String, String>();
		errorsMap = new HashMap<String, String>();
		//添加用户，模拟从数据库查询出的数据库
		//userMap.put("zhangsan", "zs123");
		//userMap.put("lisi", "ls123");
	}
	
	public boolean isValidate() {
		boolean flag = true;
		if(!this.userMap.containsKey(this.username)) {
			flag = false;
			errorsMap.put("username", "该用户不存在");
			this.username = "";
		}
		
		String password = this.userMap.get(this.username);
		if (password == null|| !password.equals(this.passwd)) {
			flag = false;
			this.passwd = "";
			errorsMap.put("passwd", "密码错误，请输入正确密码");
			this.username = "";
		}
		return flag;
	}
	
	//获取错误信息
	public String getErrors(String key) {
		String errorV = this.errorsMap.get(key);
		return errorV == null?"":errorV;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		username = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
