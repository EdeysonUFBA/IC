package treeView;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class GraphView {

    public static void main(String[] args) {
        // Create the root node
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");

        // Add child nodes
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Child 3");

        rootNode.add(child1);
        rootNode.add(child2);
        rootNode.add(child3);

        DefaultMutableTreeNode grandchild1 = new DefaultMutableTreeNode("Grandchild 1");
        child1.add(grandchild1);

        // Add more nodes and connections as needed

        // Create the JTree
        JTree tree = new JTree(rootNode);

        // Create the frame and add the JTree
        JFrame frame = new JFrame("Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tree);
        // Set up the frame and show it
        frame.pack();
        frame.setVisible(true);
    }
}