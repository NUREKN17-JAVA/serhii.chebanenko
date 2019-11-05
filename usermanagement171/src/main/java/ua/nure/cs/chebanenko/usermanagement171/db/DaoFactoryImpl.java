package ua.nure.cs.chebanenko.usermanagement171.db;

import ua.nure.cs.chebanenko.usermanagement171.domain.User;

public class DaoFactoryImpl extends DaoFactory {

	public Dao<User> getUserDao() {
		Dao<User> result;
		try {
			Class<?> clazz = Class.forName(properties.getProperty(USER_DAO));
			result=(Dao<User>) clazz.newInstance();
			result.setConnectionFactory(getConnectionFactory());
		}
		catch (Exception e){
			throw new RuntimeException(e);
		}
		return result;
	}

}