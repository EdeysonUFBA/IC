package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CompetencyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompetencyFrame frame = new CompetencyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CompetencyFrame() {
		ArrayList<Rectangle> arrayBounds = new ArrayList<Rectangle>();
		
		setTitle("Competency");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 806, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		  
		setContentPane(contentPane);
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel contextPanel = new ContextUI();
		tabbedPane.addTab("Context Properties", contextPanel);
		contentPane.add(tabbedPane, BorderLayout.CENTER);	
		setBounds(contextPanel.getBounds());
		arrayBounds.add(contextPanel.getBounds());
		
		JPanel authorPanel = new AuthorUI();
		tabbedPane.addTab("Author Properties", authorPanel);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		//setBounds(authorPanel.getBounds());		
		arrayBounds.add(authorPanel.getBounds());		
		
		JPanel competencyPanel = new CompetenceUI();
		tabbedPane.addTab("Competency", competencyPanel);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		arrayBounds.add(competencyPanel.getBounds());			
		
	    ChangeListener changeListener = new ChangeListener() {
	        public void stateChanged(ChangeEvent changeEvent) {
	          JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
	          int index = sourceTabbedPane.getSelectedIndex();
	          JPanel p = (JPanel) sourceTabbedPane.getComponentAt(index);
	          //System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index) + " " + arrayBounds.get(index));
	  		setBounds(arrayBounds.get(index));
	        }
	      };	
	      
      tabbedPane.addChangeListener(changeListener);	      
	}

}
