package acmCCS2012.version0;

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

public class ACMCCS2012Tree extends JPanel
                      implements TreeSelectionListener {
    private JEditorPane codePane;
    private JTree tree;
    ACMCCSParser rACM;
    
    //Optionally play with line styles.  Possible values are "Angled" (the default), "Horizontal", and "None".
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    
    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;

    public ACMCCS2012Tree() {
        super(new GridLayout(1,0));

        //Create the nodes.
        DefaultMutableTreeNode top =
            new DefaultMutableTreeNode("ACM CCS 2012");
        createNodes(top);

        //Create a tree that allows one selection at a time.
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Listen for when the selection changes.
        tree.addTreeSelectionListener(this);

        if (playWithLineStyle) {
            System.out.println("line style = " + lineStyle);
            tree.putClientProperty("JTree.lineStyle", lineStyle);
        }

        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);

        //Create the HTML viewing pane.
        codePane = new JEditorPane();
        codePane.setEditable(false);

        JScrollPane codeView = new JScrollPane(codePane);

        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(codeView);

        Dimension minimumSize = new Dimension(100, 50);
        codeView.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100); 
        splitPane.setPreferredSize(new Dimension(500, 300));

        //Add the split pane to this panel.
        add(splitPane);
    }

    /** Required by TreeSelectionListener interface. */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        if (!node.isRoot()) {
            ACMCCSConcept acmItem = (ACMCCSConcept)nodeInfo;
            //System.out.println(acmItem.getCode());
            codePane.setText(acmItem.getCode());
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

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode acmTreeNode = null;
	    ACMCCSConcept skosItem, child;
	    
	    rACM = new ACMCCSParser();
	    //ArrayList<String> rootNodes;
	    
	    //rACM.readStatements();
	    //rootNodes = ACMCCSFirstLevelNodes.selectRootNodes();
	    ArrayList<ACMCCSConcept> firstLevelNodes = rACM.getFirstLevelNodes();	    
	    //System.out.println(rootNodes);
	    for (ACMCCSConcept firstLevelNode : firstLevelNodes) {
	    	//skosItem = rACM.getMapaCCS().get(code);
	    	//createHierarchy(top, skosItem);
	    	createHierarchy(top, firstLevelNode);
	    }
     }
        
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }

        //Create and set up the window.
        JFrame frame = new JFrame("ACM Computing Classification System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new ACMCCS2012Tree());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}