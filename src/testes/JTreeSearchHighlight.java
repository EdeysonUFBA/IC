package testes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;



public class JTreeSearchHighlight {
	    private JTree tree;
	    private DefaultTreeModel treeModel;
	    private JTextField searchField;

	    public JTreeSearchHighlight() {
	        JFrame frame = new JFrame("Searchable JTree Demo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Cria a raiz da árvore
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
	        treeModel = new DefaultTreeModel(root);
	        tree = new JTree(treeModel);

	        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Node a");
	        root.add(node3);
	        DefaultMutableTreeNode subnode = new DefaultMutableTreeNode("Node ab");
	        node3.add(subnode);
	        
	        node3 = new DefaultMutableTreeNode("Node e");
	        root.add(node3);
	        subnode = new DefaultMutableTreeNode("Node ea");
	        node3.add(subnode);	        
	        
	        node3 = new DefaultMutableTreeNode("Node ee");
	        root.add(node3);
	        subnode = new DefaultMutableTreeNode("Node eea");
	        node3.add(subnode);
	        
	        node3 = new DefaultMutableTreeNode("Node de");
	        root.add(node3);
	        node3 = new DefaultMutableTreeNode("Node ed");
	        root.add(node3);
	        node3 = new DefaultMutableTreeNode("Node ewq");
	        root.add(node3);
	        node3 = new DefaultMutableTreeNode("Node fe");
	        root.add(node3);
	        node3 = new DefaultMutableTreeNode("Node cal");
	        root.add(node3);
	        
	        // Cria uma barra de pesquisa
	        JPanel searchPanel = new JPanel();
	        searchField = new JTextField(20);
	        JButton clearButton = new JButton("Limpar");

	        searchPanel.add(new JLabel("Pesquisar: "));
	        searchPanel.add(searchField);
	        searchPanel.add(clearButton);

	        frame.add(searchPanel, BorderLayout.NORTH);
	        frame.add(new JScrollPane(tree), BorderLayout.CENTER);

	        // Define ação para o campo de pesquisa
	        searchField.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                filterTree();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                filterTree();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                filterTree();
	            }
	        });

	        // Define ação para o botão de limpar
	        clearButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                searchField.setText("");
	            }
	        });

	        frame.setSize(400, 300);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    private void filterTree() {
	        String searchText = searchField.getText().trim().toLowerCase();

	        DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
	        int childCount = root.getChildCount();

	        for (int i = 0; i < childCount; i++) {
	            DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);
	            String nodeText = node.toString().toLowerCase();

	            if (nodeText.contains(searchText)) {
	                tree.expandPath(new TreePath(node.getPath()));
	            } else {
	                tree.collapsePath(new TreePath(node.getPath()));
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new JTreeSearchHighlight();
	            }
	        });
	    }
	}
