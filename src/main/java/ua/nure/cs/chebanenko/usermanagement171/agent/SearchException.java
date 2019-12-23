package ua.nure.cs.chebanenko.usermanagement171.agent;

import ua.nure.cs.chebanenko.usermanagement171.db.DatabaseException;

public class SearchException extends Exception {

	public SearchException(DatabaseException e) {
		// TODO Auto-generated constructor stub
		e.printStackTrace();
	}
	
}