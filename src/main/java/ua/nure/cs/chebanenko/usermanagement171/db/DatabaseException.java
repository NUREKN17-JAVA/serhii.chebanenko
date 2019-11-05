package ua.nure.cs.chebanenko.usermanagement171.db;

import java.sql.SQLException;

public class DatabaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public DatabaseException(SQLException e) {
		super(e);
	}

	public DatabaseException(String string ) {
		super(string);
	}
}

