package ua.nure.cs.chebanenko.usermanagement171.db;

import java.sql.Connection;  

public interface ConnectionFactory {
	/**
	 * Create connection to database
	 * @return connection to database
	 * @throws DatabaseException
	 */
	Connection createConnection() throws DatabaseException;
}