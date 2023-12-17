package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class AuthorUI extends JPanel {
	private JTextField txtAuthorFullName;
	private JTextField txtAuthorEmail;
	private JTextField txtAuthorURL;
	private JTextField txtKeyword;

	/**
	 * Create the panel.
	 */
	public AuthorUI() {
		setLayout(null);

		String[] columns = new String[] {"Full Name", "e-mail", "URL", "Role" };
		Object[][] data = new Object[][] {};
		JTable authorTable = new JTable(data, columns);
		authorTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Full Name", "e-mail", "URL", "Role"
				}
				));
		authorTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		authorTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		authorTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		authorTable.getColumnModel().getColumn(3).setPreferredWidth(80);		


		JScrollPane scrollPaneAuthorTable = new JScrollPane(authorTable);
		scrollPaneAuthorTable.setBounds(10, 97, 671, 118);
		scrollPaneAuthorTable.setBorder(new LineBorder(new Color(0, 0, 0)));        
		add(scrollPaneAuthorTable);

		columns = new String[] {"Keyword" };
		data = new Object[][] {};
		JTable keywordTable = new JTable(data, columns);
		keywordTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Keyword"
				}
				));
		keywordTable.getColumnModel().getColumn(0).setPreferredWidth(200);

		JScrollPane scrollPaneKeywordTable = new JScrollPane(keywordTable);
		scrollPaneKeywordTable.setBounds(10, 280, 671, 118);
		scrollPaneKeywordTable.setBorder(new LineBorder(new Color(0, 0, 0)));        
		add(scrollPaneKeywordTable);		
		
		
		JLabel label = new JLabel("New label");
		scrollPaneAuthorTable.setColumnHeaderView(label);

		JLabel lblAuthorName = new JLabel("Full Name");
		lblAuthorName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthorName.setBounds(10, 11, 63, 14);
		add(lblAuthorName);

		txtAuthorFullName = new JTextField();
		txtAuthorFullName.setBounds(70, 8, 201, 20);
		add(txtAuthorFullName);
		txtAuthorFullName.setColumns(100);

		JLabel lblAuthorEmail = new JLabel("e-mail");
		lblAuthorEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthorEmail.setBounds(10, 39, 46, 14);
		add(lblAuthorEmail);

		txtAuthorEmail = new JTextField();
		txtAuthorEmail.setBounds(70, 36, 201, 20);
		add(txtAuthorEmail);
		txtAuthorEmail.setColumns(10);

		JLabel lblAuthorURL = new JLabel("URL");
		lblAuthorURL.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthorURL.setBounds(10, 69, 46, 14);
		add(lblAuthorURL);

		txtAuthorURL = new JTextField();
		txtAuthorURL.setBounds(70, 66, 201, 20);
		add(txtAuthorURL);
		txtAuthorURL.setColumns(10);

		JButton btnAddAuthor = new JButton("Add Author");
		btnAddAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddAuthor.setBounds(355, 63, 107, 23);
		add(btnAddAuthor);
		
		JRadioButton rbAuthor = new JRadioButton("Author");
		rbAuthor.setSelected(true);
		rbAuthor.setBounds(325, 7, 73, 23);

		JRadioButton rbContributor = new JRadioButton("Contributor");
		rbContributor.setBounds(403, 7, 135, 23);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbContributor);
		bg.add(rbAuthor);
		add(rbContributor);  
		add(rbAuthor);  		

		DefaultTableModel modelAuthorTable = (DefaultTableModel) authorTable.getModel();
		DefaultTableModel modelKeywordTable = (DefaultTableModel) keywordTable.getModel();

		btnAddAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String FN = txtAuthorFullName.getText();
				String email = txtAuthorEmail.getText();
				String url = txtAuthorURL.getText();

				// Verificar se os dados já existem na tabela
				for (int i = 0; i < modelAuthorTable.getRowCount(); i++) {
					String existingFN = modelAuthorTable.getValueAt(i, 0).toString();
					String existingEmail = modelAuthorTable.getValueAt(i, 1).toString();
					String existingURL = modelAuthorTable.getValueAt(i, 2).toString();

					if (existingFN.equals(FN) && existingEmail.equals(email) && existingURL.equals(url)) {
						// Os dados já existem na tabela, não precisa adicionar novamente
						return;
					}
				}

				// Os dados não existem na tabela, adicionar nova linha
				if (rbAuthor.isSelected())
					modelAuthorTable.addRow(new Object[]{FN, email, url, "Author"});
				else
					modelAuthorTable.addRow(new Object[]{FN, email, url, "Contributor"});
				txtAuthorFullName.setText("");
				txtAuthorEmail.setText("");
				txtAuthorURL.setText("");
			}
		});       
		
		

		JButton btnRemoveAuthor = new JButton("Remove Author");
		btnRemoveAuthor.setHorizontalAlignment(SwingConstants.TRAILING);
		btnRemoveAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveAuthor.setBounds(500, 63, 131, 23);
		add(btnRemoveAuthor);
		
		JLabel lblKeyword = new JLabel("Keyword");
		lblKeyword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKeyword.setBounds(10, 242, 84, 14);
		add(lblKeyword);
		
		txtKeyword = new JTextField();
		txtKeyword.setBounds(70, 239, 201, 20);
		add(txtKeyword);
		txtKeyword.setColumns(10);
		
		JButton btnAddKeyword = new JButton("Add Keyword");
		btnAddKeyword.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddKeyword.setBounds(355, 238, 107, 23);
		add(btnAddKeyword);
		
		JButton btnRemoveKeyword = new JButton("Remove Keyword");
		btnRemoveKeyword.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveKeyword.setBounds(500, 238, 131, 23);
		add(btnRemoveKeyword);

		btnRemoveAuthor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obter o índice da linha selecionada
				int selectedRow = authorTable.getSelectedRow();

				// Certifique-se de que uma linha foi selecionada
				if (selectedRow == -1) {
					return;
				}

				// Remover a linha selecionada do modelo de tabela
				modelAuthorTable.removeRow(selectedRow);
			}
		});    
		
		
		btnAddKeyword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String key = txtKeyword.getText();

				// Verificar se os dados já existem na tabela
				for (int i = 0; i < modelKeywordTable.getRowCount(); i++) {
					String existingKey = modelKeywordTable.getValueAt(i, 0).toString();

					if (existingKey.equals(key)) {
						// Os dados já existem na tabela, não precisa adicionar novamente
						return;
					}
				}

				modelKeywordTable.addRow(new Object[]{key});
				txtKeyword.setText("");
			}
		});  
		
		btnRemoveKeyword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obter o índice da linha selecionada
				int selectedRow = keywordTable.getSelectedRow();

				// Certifique-se de que uma linha foi selecionada
				if (selectedRow == -1) {
					return;
				}

				// Remover a linha selecionada do modelo de tabela
				modelKeywordTable.removeRow(selectedRow);
			}
		}); 
		
		setBounds(100, 100, 756, 484);		
	}
}
