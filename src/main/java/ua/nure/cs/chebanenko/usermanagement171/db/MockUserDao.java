package ua.nure.cs.chebanenko.usermanagement171.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ua.nure.cs.chebanenko.usermanagement171.domain.User;

public class MockUserDao implements Dao {
	private Long id = (long) 0;
	private Map users = new HashMap();
	
	
	public User create(User user) throws DatabaseException {
		// TODO Auto-generated method stub
		Long currentId = new Long(++id);
		user.setId(currentId);
		users.put(currentId, user);
		return user;
	}

	
	public void update(User user) throws DatabaseException {
		// TODO Auto-generated method stub
		Long currentId = user.getId();
		users.remove(currentId);
		users.put(currentId, user);
	}

	
	public void delete(User user) throws DatabaseException {
		// TODO Auto-generated method stub
		Long currentId = user.getId();
		users.remove(currentId);
	}

	
	public User find(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		return (User) users.get(id);
	}

	
	public Collection findAll() throws DatabaseException {
		// TODO Auto-generated method stub
		return users.values();
	}

	
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		// TODO Auto-generated method stub

	}

	
	public Object create(Object entity) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void update(Object entity) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Object entity) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

}