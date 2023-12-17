package testes;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import acmCCS2012.ACMCCSConcept;
import acmCCS2012.ACMCCSParser;

public class TreeACMCCS2012 {

	private JTree treeACM = null;
	private TreeModel treeModel;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeACMCCS2012 window = new TreeACMCCS2012();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TreeACMCCS2012() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTree treeACM = new JTree();
		treeACM.setModel(null);
	    DefaultMutableTreeNode skosMainTree = new
	            DefaultMutableTreeNode("ACM CCS 2012");
	    DefaultMutableTreeNode mediaTitleNode = new DefaultMutableTreeNode("");
	    DefaultMutableTreeNode universeTitleNode = new
	            DefaultMutableTreeNode("");		
		
	    ACMCCSParser rACM = new ACMCCSParser();
	    rACM.readStatements();
	    rACM.showHash();
	    
	    HashMap<String, ACMCCSConcept> mapaCCS = rACM.getMapaCCS();
	    
	    Set<String> keys = mapaCCS.keySet();
	    Collection<ACMCCSConcept> values = mapaCCS.values();
	    
	    ArrayList<Map.Entry<String,ACMCCSConcept>> copy = new
	            ArrayList<Map.Entry<String, ACMCCSConcept>>();
	    
	    copy.addAll(mapaCCS.entrySet());	
	    
	    for (Map.Entry<String,ACMCCSConcept> e : copy){

	        mediaTitleNode = new DefaultMutableTreeNode(e.getKey());

	        universeTitleNode = new DefaultMutableTreeNode(e.getValue());

	        skosMainTree.add(universeTitleNode);

	        universeTitleNode.add(mediaTitleNode);

	    }

	    treeACM.setModel(new DefaultTreeModel(skosMainTree));	    
	    
		treeACM.setBounds(10, 11, 440, 492);
		frame.getContentPane().add(treeACM);
	}
}
