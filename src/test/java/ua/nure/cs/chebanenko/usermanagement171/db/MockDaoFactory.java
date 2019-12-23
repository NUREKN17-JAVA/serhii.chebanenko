package ua.nure.cs.chebanenko.usermanagement171.db;

import com.mockobjects.dynamic.Mock;

public class MockDaoFactory extends DaoFactory {

	private Mock mockUserDao;
	
	public MockDaoFactory() {
		mockUserDao = new Mock(Dao.class);
	}
	
	public Mock getMockUserDao() {
		return mockUserDao;
	}
	
	public Dao getUserDao() {
		// TODO Auto-generated method stub
		return (Dao) mockUserDao.proxy();
	}

}