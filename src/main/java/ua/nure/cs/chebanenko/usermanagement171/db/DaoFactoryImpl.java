package ua.nure.cs.chebanenko.usermanagement171.db;

import ua.nure.cs.chebanenko.usermanagement171.domain.User;

public class DaoFactoryImpl extends DaoFactory {

	@Override
	public Dao getUserDao() {
	       Dao result = null;
		try {
			Class clazz = Class.forName(properties.getProperty(USER_DAO));
			result = (Dao) clazz.newInstance();
			result.setConnectionFactory(getConnectionFactory());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

}