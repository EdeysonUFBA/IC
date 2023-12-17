package userInterface;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import acmCCS2012.ACMCCSConcept;
import acmCCS2012.ACMCCSFirstLevelNodes;
import acmCCS2012.ACMCCSParser;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.net.URL;
import java.util.ArrayList;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ACMCCS2012Tree extends JTree{

    ACMCCSParser rACM;
    
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    
    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;
    private static DefaultMutableTreeNode top = new DefaultMutableTreeNode("ACM CCS 2012");;

    public ACMCCS2012Tree() {
        super(top);
        createNodes(top);

        this.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

    }

    private void createNodes(DefaultMutableTreeNode top) {
	    rACM = new ACMCCSParser();
	    ArrayList<ACMCCSConcept> firstLevelNodes = rACM.getFirstLevelNodes();	    
	    for (ACMCCSConcept firstLevelNode : firstLevelNodes) {
	    	createHierarchy(top, firstLevelNode);
	    }
     }
    
	private void createHierarchy(DefaultMutableTreeNode treeNode, ACMCCSConcept skosItem) {
		ACMCCSConcept child;
		
        DefaultMutableTreeNode acmTreeNode = new DefaultMutableTreeNode(skosItem);     
        treeNode.add(acmTreeNode);
        
		if (skosItem.getNarrower().size() > 0) {
		    for (String code : skosItem.getNarrower()) {
		    	child = rACM.getMapaCCS().get(code);
		    	createHierarchy(acmTreeNode, child);
		    }			
		}
	}


}