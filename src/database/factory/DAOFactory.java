package database.factory;

import database.dao.UserDao;
import database.service.UserService;

public class DAOFactory {
	public static UserDao getIEmpDAOInstance() throws Exception {
		return new UserService();
	}
}
