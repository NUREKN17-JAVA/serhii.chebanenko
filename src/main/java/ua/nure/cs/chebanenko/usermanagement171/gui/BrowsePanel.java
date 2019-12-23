package ua.nure.cs.chebanenko.usermanagement171.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ua.nure.cs.chebanenko.usermanagement171.db.DatabaseException;
import ua.nure.cs.chebanenko.usermanagement171.domain.User;

public class BrowsePanel extends JPanel implements ActionListener {
	private MainFrame parent;
	
	private JPanel buttonPanel;

    private JButton addButton;

    private JButton detailsButton;

    private JButton deleteButton;

    private JButton editButton;

    private JScrollPane tablePanel;

    private JTable userTable;
	

	public BrowsePanel(MainFrame frame) {
		parent = frame;
        initialize();
	}

	private void initialize() {
        this.setName("browsePanel"); 
        this.setLayout(new BorderLayout());
        this.add(getTablePanel(), BorderLayout.CENTER);
        this.add(getButtonsPanel(), BorderLayout.SOUTH);
    }
	
	 private JScrollPane getTablePanel() {
	        if (tablePanel == null) {
	            tablePanel = new JScrollPane(getUserTable());
	        }
	        return tablePanel;
	    }
	 
	 private JTable getUserTable() {
	        if (userTable == null) {
	            userTable = new JTable();
	            userTable.setName("userTable"); 
	        }
	        return userTable;
	    }
	
	 private JPanel getButtonsPanel() {
	        if (buttonPanel == null) {
	            buttonPanel = new JPanel();
	            buttonPanel.add(getAddButton(), null);
	            buttonPanel.add(getEditButton(), null);
	            buttonPanel.add(getDeleteButton(), null);
	            buttonPanel.add(getDetailsButton(), null);
	        }
	        return buttonPanel;
	    }
	 
	 private JButton getAddButton() {
	        if (addButton == null) {
	            addButton = new JButton();
	            addButton.setText("Добавить"); 
	            addButton.setName("addButton"); 
	            addButton.setActionCommand("add");
	            addButton.addActionListener(this);
	        }
	        return addButton;
	    }
	 
	 private JButton getEditButton() {
	        if (editButton == null) {
	            editButton = new JButton();
	            editButton.setText("Редактировать"); 
	            editButton.setName("editButton"); 
	            editButton.setActionCommand("edit"); 
	            editButton.addActionListener(this);
	        }
	        return editButton;
	    }
	 
	 private JButton getDeleteButton() {
	        if (deleteButton == null) {
	            deleteButton = new JButton();
	            deleteButton.setText("Удалить"); 
	            deleteButton.setName("deleteButton"); 
	            deleteButton.setActionCommand("delete"); 
	            deleteButton.addActionListener(this);
	        }
	        return deleteButton;
	    }
	 
	 private JButton getDetailsButton() {
	        if (detailsButton == null) {
	            detailsButton = new JButton();
	            detailsButton.setText("Детали"); 
	            detailsButton.setName("detailsButton"); 
	            detailsButton.setActionCommand("details"); 
	            detailsButton.addActionListener(this);
	        }
	        return detailsButton;
	    }
	 
	 public void initTable() {
			UserTableModel model;
			try {
				model = new UserTableModel(parent.getUserDao().findAll());
			} catch (DatabaseException e) {
				model = new UserTableModel(new ArrayList());
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			//userTable.setModel(model);
			getUserTable().setModel(model);
		}

	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if ("add".equalsIgnoreCase(actionCommand)) {
			this.setVisible(false);
			parent.showAddPanel();
		}
		else if ("edit".equalsIgnoreCase(actionCommand)) {
			this.setVisible(false);
			parent.showEditPanel(userTable.getSelectedRow());
		}
		else if ("details".equalsIgnoreCase(actionCommand)) {
			this.setVisible(false);
			parent.showDetailsPanel(userTable.getSelectedRow());
		}
		else if ("delete".equalsIgnoreCase(actionCommand)) {
			this.setVisible(false);
			parent.showDeletePanel(userTable.getSelectedRow());
		}
	}
	 
	 
}
