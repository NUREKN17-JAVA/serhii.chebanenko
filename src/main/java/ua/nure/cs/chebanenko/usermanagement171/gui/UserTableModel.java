package ua.nure.cs.chebanenko.usermanagement171.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import org.hsqldb.User;

public class UserTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 4495195235059200823L;
    private static final String[] COLUMN_NAMES = {"ID", "Имя", "Фамилия"}; 
    private static final Class<?>[] COLUMN_CLASSES = {Long.class, String.class, String.class};
    private List<User> users = null;
    
    public UserTableModel(Collection<User> users) {
        this.users = new ArrayList<>(users);
    }
    
    public int getRowCount() {
        return users.size();
    }

    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    public Class getColumnClass(int columnIndex) {
		return COLUMN_CLASSES[columnIndex];
	}
	
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {	
		User user = (User) users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return user.getId(); 
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName();
		}
		return -1;
	}
	
	public User getValueAt(int rowIndex) {	
		return (User) users.get(rowIndex);
	}
	public void addUsers(Collection users) {
		this.users.addAll(users);
	}
	public void clearUsers() {
		this.users = new ArrayList();
	}
}

