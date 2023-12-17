package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class CompetenceUI extends JPanel {
	private JTextField txtCompetencyStatement;
	private final String dispositions[] = {"Adaptable", "Collaborative",
			"Inventive", "Meticulous", "Passionate", "Proactive", "Professional",
			"Purpose-driven", "Responsible", "Responsive", "Self-directed"};
	
	private enum bloomLevel {Remembering, Understanding, Applying, Analyzing, Evaluating, Creating};
	
	private final String skills[] = {"Remembering", "Understanding", "Applying", "Analyzing", "Evaluating", "Creating"};
	
	private final String[] bloomDefinitions = new String[6];
	private ArrayList<String> bloomVerbs[] = new ArrayList[6];	

	private JList<String> listDispositions;
	private JList<String> listCompetencyDispositions;
	private JList<String> listSkill;
	private JList<String> listVerbs;
	
	private DefaultListModel<String> modelDispositions;
	private DefaultListModel<String> modelCompetencyDispositions;	
	private DefaultListModel<String> modelSkills;
	private DefaultListModel<String> modelVerbs;
		
	
	private JTextField txtSelectedKnowledge;
	private JTextField txtSelectedSkill;
	private JTable table;
	private JTextArea txtHelp;
	
	private String selectedTableKnowledge, selectedTableSkill;
	private JTextField searchField;
    private DefaultMutableTreeNode lastHighlightedNode = null;	
	
	private JTree treeKnowledge;	
	/**
	 * Create the panel.
	 */
	
    private void filterTree() {
        String searchText = searchField.getText().trim().toLowerCase();
      

        Enumeration<?> nodes = ((DefaultMutableTreeNode) treeKnowledge.getModel().getRoot()).breadthFirstEnumeration();
        while (nodes.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) nodes.nextElement();
            String nodeText = node.toString().toLowerCase();

            if (nodeText.contains(searchText)) {
                if (lastHighlightedNode != null) {
                	treeKnowledge.collapsePath(new TreePath(lastHighlightedNode.getPath()));
                }
                treeKnowledge.expandPath(new TreePath(node.getPath()));
                treeKnowledge.scrollPathToVisible(new TreePath(node.getPath()));
                lastHighlightedNode = node;
                break;
            }
        }        
    }


    
	private void defineSkills() {
		bloomDefinitions[bloomLevel.Remembering.ordinal()] = "Exhibit memory of previously learned material by recalling facts, terms, basic concepts, and answers.";
		bloomDefinitions[bloomLevel.Understanding.ordinal()] = "Demonstrate  understanding of facts and ideas by organizing, comparing, translating, interpreting, giving descriptions, and stating main ideas. ";
		bloomDefinitions[bloomLevel.Applying.ordinal()] = "Solve problems to new situations by applying acquired knowledge, facts, techniques and rules in a different way.";
		bloomDefinitions[bloomLevel.Analyzing.ordinal()] = "Examine and break information into parts by identifying motives or causes. Make inferences and find evidence to support generalizations.";
		bloomDefinitions[bloomLevel.Evaluating.ordinal()] = "Present and defend opinions by making judgments about information, validity of ideas, or quality of work based on a set of criteria.  ";
		bloomDefinitions[bloomLevel.Creating.ordinal()] = "Compile information together in a different way by combining elements in a new pattern or proposing alternative solutions.";
		
		String rememberingVerbs [] = {"Choose", "Define", "Find", "How", "Label", "List", "Match", "Name", "Omit", "Recall", "Relate", "Select", "Show", "Spell", "Tell", "What", "When", "Where", "Which", "Who", "Why"};
        bloomVerbs[bloomLevel.Remembering.ordinal()] = new ArrayList<>();
        for (String verb : rememberingVerbs) {
			bloomVerbs[bloomLevel.Remembering.ordinal()].add(verb);
		}
        
		String understandigVerbs [] = {"Classify", "Compare", "Contrast", "Demonstrate", "Explain", "Extend", "Illustrate", "Infer", "Interpret", "Outline", "Rephrase", "Show", "Summarize", "Translate"};
        bloomVerbs[bloomLevel.Understanding.ordinal()] = new ArrayList<>();
        for (String verb : rememberingVerbs) {
			bloomVerbs[bloomLevel.Understanding.ordinal()].add(verb);
		}

		String applyingVerbs[] = {"Apply", "Build", "Choose", "Construct", "Develop", "Experiment with", "Identify", "Interview", "Interpret", "Make use of", "Model", "Organize", "Plan", "Select", "Show", "Solve", "Utilize"};
        bloomVerbs[bloomLevel.Applying.ordinal()] = new ArrayList<>();
        for (String verb : rememberingVerbs) {
			bloomVerbs[bloomLevel.Applying.ordinal()].add(verb);
		}
        
		String analyzingVerbs[] = {"Analyze", "Assume", "Categorize", "Classify", "Compare", "Contrast", "Discover", "Distinguish", "Dissect", "Examine", "Function", "Inference", "Inspect", "Investigate", "Explain", "Function", "Inspect", "Motive", "Relationships", "Simplify", "Survey", "Take part in"};
        bloomVerbs[bloomLevel.Analyzing.ordinal()] = new ArrayList<>();
        for (String verb : rememberingVerbs) {
			bloomVerbs[bloomLevel.Analyzing.ordinal()].add(verb);
		}
        
		String evaluatingVerbs[] = {"Agree", "Appraise", "Assess", "Award", "Choose", "Choose", "Compare", "Conclude", "Criteria", "Criticize", "Decide", "Deduct", "Defend", "Determine", "Disprove", "Estimate", "Evaluate", "Explain", "Happen", "Importance", "Influence", "Interpret", "Judge", "Justify", "Mark", "Maximize", "Minimize", "Modify", "Opinion", "Original", "Perceive", "Prioritize", "Prove", "Rate", "Recommend", "Rule on", "Select", "Support", "Test", "Value"};
        bloomVerbs[bloomLevel.Evaluating.ordinal()] = new ArrayList<>();
        for (String verb : rememberingVerbs) {
			bloomVerbs[bloomLevel.Evaluating.ordinal()].add(verb);
		}
        
		String creatingVerbs[] = {"Adapt", "Build", "Change", "Build", "Combine", "Compile", "Compose", "Construct", "Create", "Delete", "Design", "Develop", "Discuss", "Elaborate", "Estimate", "Formulate", "Imagine", "Improve", "Invent", "Make up", "Plan", "Predict", "Propose", "Solution", "Solve", "Suppose", "Test", "Theory"};
        bloomVerbs[bloomLevel.Creating.ordinal()] = new ArrayList<>();
        for (String verb : rememberingVerbs) {
			bloomVerbs[bloomLevel.Creating.ordinal()].add(verb);
		}		
	}
	
	public CompetenceUI() {
		setLayout(null);
		defineSkills();
		
		searchField = new JTextField();
		searchField.setText("\"\"");
		searchField.setBounds(280, 250, 86, 20);
		add(searchField);
		searchField.setColumns(10);		

		modelDispositions = new DefaultListModel<>();
		modelCompetencyDispositions = new DefaultListModel<>();
		modelSkills = new DefaultListModel<>();
		modelVerbs = new DefaultListModel<>();		
		
		JLabel lblCompetencyStatement = new JLabel("Competency Statement");
		lblCompetencyStatement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCompetencyStatement.setBounds(10, 11, 147, 14);
		add(lblCompetencyStatement);

		txtCompetencyStatement = new JTextField();
		txtCompetencyStatement.setBounds(167, 8, 572, 20);
		add(txtCompetencyStatement);
		txtCompetencyStatement.setColumns(10);

		JLabel lblDispositions = new JLabel("Dispositions");
		lblDispositions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDispositions.setBounds(10, 64, 80, 14);
		add(lblDispositions);

		for (String disposition : dispositions) {
			modelDispositions.addElement(disposition);
		}
		
		for (String skill : skills) {
			modelSkills.addElement(skill);
		}		

		// Cria as JLists
		listDispositions = new JList<>(modelDispositions);
		listCompetencyDispositions = new JList<>(modelCompetencyDispositions);  
		listSkill = new JList<>(modelSkills);		
		listSkill.setToolTipText("Bloom Taxonomy Levels");
		listVerbs = new JList(modelVerbs);
		
		
		JScrollPane scrollPaneDispositions = new JScrollPane(listDispositions);
		scrollPaneDispositions.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDispositions.setBounds(10, 89, 75, 108);	
		scrollPaneDispositions.setSize(150, 150);		
		add(scrollPaneDispositions);

		listVerbs.setBounds(620, 284, 119, 147);
		add(listVerbs);
		
		
		JLabel lblCompetencyDisposition = new JLabel("Competency Dispositions");
		lblCompetencyDisposition.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCompetencyDisposition.setBounds(239, 64, 147, 14);
		add(lblCompetencyDisposition);

		JScrollPane scrollPaneCompetencyDispositions = new JScrollPane(listCompetencyDispositions);
		scrollPaneCompetencyDispositions.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneCompetencyDispositions.setBounds(239, 90, 147, 149);	
		scrollPaneCompetencyDispositions.setSize(150, 150);		
		add(scrollPaneCompetencyDispositions);

		//JTree treeKnowledge = new ACMCCS2012Tree();
		treeKnowledge = new ACMCS2013Tree();
		JScrollPane scrollPaneTreeKnowledge = new JScrollPane(treeKnowledge);
		scrollPaneTreeKnowledge.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPaneTreeKnowledge.setBounds(10, 281, 376, 150);
		add(scrollPaneTreeKnowledge);

		JLabel lblSelectedKnowledge = new JLabel("Selected Knowledge");
		lblSelectedKnowledge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectedKnowledge.setBounds(10, 442, 147, 14);
		add(lblSelectedKnowledge);

		txtSelectedKnowledge = new JTextField();
		txtSelectedKnowledge.setEditable(false);
		txtSelectedKnowledge.setBounds(10, 458, 376, 20);
		add(txtSelectedKnowledge);
		txtSelectedKnowledge.setColumns(10);
		
		JLabel lblComputerKnowledge = new JLabel("Computer Knowledge (ACM CS BoK 2013)");
		lblComputerKnowledge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComputerKnowledge.setBounds(10, 256, 260, 14);
		add(lblComputerKnowledge);
		
		//JList<String> listSkill = new JList<String>((ListModel) null);
		listSkill.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listSkill.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSkill.setBounds(454, 281, 131, 148);
		add(listSkill);
		
		JLabel lblSkills = new JLabel("Skills");
		lblSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSkills.setBounds(454, 256, 46, 14);
		add(lblSkills);
		
		JLabel lblNewLabel = new JLabel("Selected Skill");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(454, 442, 108, 14);
		add(lblNewLabel);
		
		txtSelectedSkill = new JTextField();
		txtSelectedSkill.setEditable(false);
		txtSelectedSkill.setBounds(454, 458, 131, 20);
		add(txtSelectedSkill);
		txtSelectedSkill.setColumns(10);
		
        String[] columns = new String[] {"Knowledge", "Skill"};
        Object[][] data = new Object[][] {};
        table = new JTable(data, columns);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Knowledge", "Skill"
        	}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(255);

		
        JScrollPane scrollPaneTreeKS = new JScrollPane(table);
        scrollPaneTreeKS.setBounds(10, 489, 575, 176);
		scrollPaneTreeKS.setBorder(new LineBorder(new Color(0, 0, 0)));        
        add(scrollPaneTreeKS);
		DefaultTableModel tableKSModel = (DefaultTableModel) table.getModel();
		
        JButton btnAddPair = new JButton("Add Pair");
        btnAddPair.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAddPair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String knowledge = txtSelectedKnowledge.getText();
                String skill = txtSelectedSkill.getText();
                
                // Verificar se os dados já existem na tabela
                for (int i = 0; i < tableKSModel.getRowCount(); i++) {
                    String existingKnowledge = tableKSModel.getValueAt(i, 0).toString();
                    String existingSkill = tableKSModel.getValueAt(i, 1).toString();
                    
                    if (existingKnowledge.equals(knowledge) && existingSkill.equals(skill)) {
                        // Os dados já existem na tabela, não precisa adicionar novamente
                        return;
                    }
                }
                
                // Os dados não existem na tabela, adicionar nova linha
                tableKSModel.addRow(new Object[]{knowledge, skill});
            }
        });
        btnAddPair.setBounds(620, 457, 108, 23);
        add(btnAddPair);
        
        JButton btnRemovePair = new JButton("Remove Pair");
        btnRemovePair.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemovePair.setBounds(620, 489, 108, 23);
        add(btnRemovePair);
        
        btnRemovePair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter o índice da linha selecionada
                int selectedRow = table.getSelectedRow();
                
                // Certifique-se de que uma linha foi selecionada
                if (selectedRow == -1) {
                    return;
                }
                
                // Remover a linha selecionada do modelo de tabela
                tableKSModel.removeRow(selectedRow);
            }
        });        
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Certifique-se de que uma linha foi selecionada e não apenas deselecionada
                if (e.getValueIsAdjusting() || table.getSelectedRow() == -1) {
                    return;
                }
                
                // Obter os valores das colunas da linha selecionada
                selectedTableKnowledge = table.getValueAt(table.getSelectedRow(), 0).toString();
                selectedTableSkill = table.getValueAt(table.getSelectedRow(), 1).toString();
            }
        });        

        treeKnowledge.getSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {
					@Override
					public void valueChanged(TreeSelectionEvent e) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode)
								treeKnowledge.getLastSelectedPathComponent();

						if (node == null) return;

						Object nodeInfo = node.getUserObject();
						if (!node.isRoot()) {
							String acmItem = (String)nodeInfo;
							txtSelectedKnowledge.setText(acmItem);
						}
					}
				});

        listSkill.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                  txtSelectedSkill.setText(listSkill.getSelectedValue().toString());
                  String help = listSkill.getSelectedValue().toString() + ": " + bloomDefinitions[listSkill.getSelectedIndex()];
                  txtHelp.setText(help);
                }
            }
        });		

		// Adiciona um ListSelectionListener para a lista de disposições
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Obtém todos os itens selecionados na lista de disposições
				List<String> selectedValuesList = listDispositions.getSelectedValuesList();

				// Remove os itens selecionados do modelo da lista de disposições
				for (String selectedValue : selectedValuesList) {
					modelDispositions.removeElement(selectedValue);
				}

				// Adiciona os itens selecionados ao modelo da lista de disposições de competência
				for (String selectedValue : selectedValuesList) {
					modelCompetencyDispositions.addElement(selectedValue);
				}
			}
		};

		// Verifica se o ListSelectionListener já está registrado na lista antes de adicioná-lo
		boolean isListenerRegistered = false;
		ListSelectionListener[] listeners = listDispositions.getListSelectionListeners();
		for (ListSelectionListener listener : listeners) {
			if (listener == listSelectionListener) {
				isListenerRegistered = true;
				break;
			}
		}

		if (!isListenerRegistered) {
			// Adiciona o ListSelectionListener à lista de disposições
			listDispositions.addListSelectionListener(listSelectionListener);
		}        

		// Adiciona um ListSelectionListener para a lista de disposições da Competência
		ListSelectionListener listSelectionListenerCompetency = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Obtém todos os itens selecionados na lista de disposições
				List<String> selectedValuesList = listCompetencyDispositions.getSelectedValuesList();

				// Remove os itens selecionados do modelo da lista de disposições
				for (String selectedValue : selectedValuesList) {
					modelCompetencyDispositions.removeElement(selectedValue);
				}

				// Adiciona os itens selecionados ao modelo da lista de disposições de competência
				for (String selectedValue : selectedValuesList) {
					modelDispositions.addElement(selectedValue);
				}
			}
		};
		
	
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

		// Verifica se o ListSelectionListener já está registrado na lista antes de adicioná-lo
		boolean isCompetencyListenerRegistered = false;
		ListSelectionListener[] competencyListeners = listCompetencyDispositions.getListSelectionListeners();
		for (ListSelectionListener listener : competencyListeners) {
			if (listener == listSelectionListenerCompetency) {
				isCompetencyListenerRegistered = true;
				break;
			}
		}

		if (!isCompetencyListenerRegistered) {
			// Adiciona o ListSelectionListener à lista de disposições
			listCompetencyDispositions.addListSelectionListener(listSelectionListenerCompetency);
		}          

		setBounds(100, 100, 771, 820);
		
		txtHelp = new JTextArea();
		txtHelp.setFont(new Font("Arial", Font.PLAIN, 15));
		txtHelp.setLineWrap(true);
		//txtHelp.setWrapStyleWord(true);
		txtHelp.setEditable(false);
		txtHelp.setBounds(10, 680, 713, 55);
		add(txtHelp);
		

	}
	
	
}
