package ua.nure.cs.chebanenko.usermanagement171.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final int FRAME_HEIGHT = 600;
    private static final int FRAME_WIDTH = 800;
    
    private JPanel contentPanel;
    private JPanel browsePanel;
	private AddPanel addPanel;
    
    
	public MainFrame() {
        super();
        initialize();
    }
	
	private void initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Управление пользователями"); //$NON-NLS-1$
        this.setContentPane(getContentPanel());
        
    }
	
	private JPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(getBrowsePanel(), BorderLayout.CENTER);
        }
        return contentPanel;
    }
	
	private JPanel getBrowsePanel() {
        if (browsePanel == null) {
            browsePanel = new BrowsePanel(this);
        }
        return browsePanel;
    }
	
	

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

	public void showAddPanel() {
        showPanel(getAddPanel());
	}

	private void showPanel(JPanel panel) {
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
	}

	private AddPanel getAddPanel() {
		if (addPanel == null) {
            addPanel = new AddPanel(this);
        }
        return addPanel;
	}
	
	public void showBrowsePanel() {
        showPanel(getBrowsePanel());
        
    }

}
