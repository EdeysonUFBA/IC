package userInterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import writeRDFPBL.Author;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class ContextUI extends JPanel {
	String structures[]={"atomic", "collection", "linear", "hierarchical", "networked"};
	String aggregations[]={"1", "2", "3", "4" };
	
	private JLabel lblOtherPlatformRequirements;
	protected JTextField txtOtherPlatformRequirements;

	private JLabel lblCopyrightAndOtherRestrictions;
	protected JTextField txtCopyrightAndOtherRestrictions;

	private JLabel lblCost;
	protected JTextField txtCost;

	private JLabel lblMetaMetadataLanguage;
	protected JTextField txtMetaMetadataLanguage;

	private JLabel lblLanguage;
	protected JTextField txtLanguage;

	private JLabel lblCopyright;
	protected JTextField txtCopyright;

	private JLabel lblTitle;
	protected JTextField txtTitle;

	private JLabel lblType;
	protected JTextField txtType;

	private JLabel lblCreationDate;
	protected JTextField txtCreationDate;

	private JLabel lblEducationalContext;
	protected JTextField txtEducationalContext;

	private JLabel lblLearningResourceType;
	protected JTextField txtLearningResourceType;

	private JLabel lblEducationalDescription;
	protected JTextField txtEducationalDescription;
	
	private JLabel lblAggregationLevel;
	protected JComboBox cmbAggregationLevel;

	private JLabel lblStructure;
	protected JComboBox cmbStructure;
	private JTextField txtTaskTitle;

	public ContextUI() {
		setToolTipText("Context Properties");
		setLayout(null);

		lblOtherPlatformRequirements = new JLabel("Other Platform Requirements");
		lblOtherPlatformRequirements.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtherPlatformRequirements.setBounds(10, 123, 200, 14);
		add(lblOtherPlatformRequirements);

		txtOtherPlatformRequirements = new JTextField();
		txtOtherPlatformRequirements.setBounds(10, 145, 259, 20);
		add(txtOtherPlatformRequirements);
		txtOtherPlatformRequirements.setColumns(10);

		lblCopyrightAndOtherRestrictions = new JLabel("Copyright and Other Restrictions");
		lblCopyrightAndOtherRestrictions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCopyrightAndOtherRestrictions.setBounds(318, 123, 200, 14);
		add(lblCopyrightAndOtherRestrictions);

		txtCopyrightAndOtherRestrictions = new JTextField();
		txtCopyrightAndOtherRestrictions.setBounds(318, 145, 260, 20);
		add(txtCopyrightAndOtherRestrictions);
		txtCopyrightAndOtherRestrictions.setColumns(10);

		lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCost.setBounds(10, 172, 200, 14);
		add(lblCost);

		txtCost = new JTextField();
		txtCost.setBounds(10, 194, 259, 20);
		add(txtCost);
		txtCost.setColumns(10);

		lblMetaMetadataLanguage = new JLabel("Meta Metadata Language");
		lblMetaMetadataLanguage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMetaMetadataLanguage.setBounds(318, 172, 200, 14);
		add(lblMetaMetadataLanguage);

		txtMetaMetadataLanguage = new JTextField();
		txtMetaMetadataLanguage.setBounds(318, 194, 260, 20);
		add(txtMetaMetadataLanguage);
		txtMetaMetadataLanguage.setColumns(10);

		lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLanguage.setBounds(10, 221, 200, 14);
		add(lblLanguage);

		txtLanguage = new JTextField();
		txtLanguage.setBounds(10, 243, 259, 20);
		add(txtLanguage);
		txtLanguage.setColumns(10);

		lblCopyright = new JLabel("Copyright");
		lblCopyright.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCopyright.setBounds(318, 221, 200, 14);
		add(lblCopyright);

		txtCopyright     = new JTextField();
		txtCopyright.setBounds(318, 243, 260, 20);
		add(txtCopyright);
		txtCopyright.setColumns(10);

		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setBounds(10, 270, 200, 14);
		add(lblTitle);

		txtTitle = new JTextField();
		txtTitle.setBounds(10, 292, 259, 20);
		add(txtTitle);
		txtTitle.setColumns(10);

		lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(318, 270, 200, 14);
		add(lblType);

		txtType = new JTextField();
		txtType.setBounds(318, 292, 260, 20);
		add(txtType);
		txtType.setColumns(10);

		lblAggregationLevel = new JLabel("Aggregation Level");
		lblAggregationLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAggregationLevel.setBounds(10, 319, 200, 14);
		add(lblAggregationLevel);

		lblStructure = new JLabel("Structure");
		lblStructure.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStructure.setBounds(318, 319, 200, 14);
		add(lblStructure);

		lblCreationDate = new JLabel("Creation Date");
		lblCreationDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCreationDate.setBounds(10, 368, 200, 14);
		add(lblCreationDate);

		txtCreationDate = new JTextField();
		txtCreationDate.setBounds(10, 390, 259, 20);
		add(txtCreationDate);
		txtCreationDate.setColumns(10);

		lblEducationalContext = new JLabel("Educational Context");
		lblEducationalContext.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEducationalContext.setBounds(318, 368, 200, 14);
		add(lblEducationalContext);

		txtEducationalContext = new JTextField();
		txtEducationalContext.setBounds(318, 390, 260, 20);
		add(txtEducationalContext);
		txtEducationalContext.setColumns(10);

		lblLearningResourceType = new JLabel("Learning Resource Type");
		lblLearningResourceType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLearningResourceType.setBounds(10, 417, 200, 14);
		add(lblLearningResourceType);

		txtLearningResourceType = new JTextField();
		txtLearningResourceType.setBounds(10, 439, 259, 20);
		add(txtLearningResourceType);
		txtLearningResourceType.setColumns(10);

		lblEducationalDescription = new JLabel("Educational Description");
		lblEducationalDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEducationalDescription.setBounds(318, 417, 200, 14);
		add(lblEducationalDescription);

		txtEducationalDescription = new JTextField();
		txtEducationalDescription.setBounds(318, 439, 260, 20);
		add(txtEducationalDescription);
		txtEducationalDescription.setColumns(10);


		cmbStructure = new JComboBox(structures);
		cmbStructure.setBounds(318, 340, 260, 22);
		add(cmbStructure);

		cmbAggregationLevel = new JComboBox(aggregations);
		cmbAggregationLevel.setBounds(10, 340, 259, 22);
		add(cmbAggregationLevel);
		
		JLabel lblTaskTitle = new JLabel("Task Title");
		lblTaskTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTaskTitle.setBounds(256, 11, 85, 14);
		add(lblTaskTitle);
		
		txtTaskTitle = new JTextField();
		txtTaskTitle.setBounds(10, 30, 568, 20);
		add(txtTaskTitle);
		txtTaskTitle.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 61, 630, 2);
		add(separator);
		
		JLabel lblLOM = new JLabel("Learning Object Metadata");
		lblLOM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLOM.setBounds(211, 74, 283, 20);
		add(lblLOM);
		
		setBounds(100, 100, 638, 558);

	}
}
