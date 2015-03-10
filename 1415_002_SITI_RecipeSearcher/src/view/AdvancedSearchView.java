package view;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import controller.AdvancedSearchController;

public class AdvancedSearchView extends JPanel
{
	private static final long serialVersionUID = 4L;
	private JTextField textField;
	private JTable table;
	private JTable table2;
	private DefaultTableModel model, model2;
	private DefaultComboBoxModel model3, model4, model5, model6, model7;
	final String labels[] = { "", "less than 30 mins", "between 30-60 mins", "more than 60 mins"};
	final String labels2[] = { "", "Suitable for diabetics", "Suitable for celiacs", "Suitable for vegetarians", "Suitable for vegans"};
	final String labels3[] = { "", "1 star", "2 stars", "3 stars", "4 stars", "5 stars"};
	final String labels4[] = { "", "Easy", "Medium", "Hard"};
	final String labels5[] = { "", "Appetizer", "Breakfast & Brunch", "Chicken", "Main Dish"};
	private AdvancedSearchController controller;
	
	public AdvancedSearchView(AdvancedSearchController controller)
	{
		setBackground(new Color(210, 225, 240));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setPreferredSize( Toolkit.getDefaultToolkit().getScreenSize());
		this.setLayout(null);
		
		this.controller = controller;
		
		JLabel lblNewLabel = new JLabel("Advanced searcher");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(504, 70, 283, 50);
		lblNewLabel.setForeground(new Color(77, 34, 4));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search by title:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(120, 130, 200, 50);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(120, 180, 600, 20);
		add(textField);
		textField.setColumns(10);
		this.model = new DefaultTableModel();
		this.model.addColumn("Ingredient name");
		this.model.addColumn("Total amount");
		this.model.addColumn("Unit");
		
		this.model2 = new DefaultTableModel();
		this.model2.addColumn("Ingredient name");
		this.model2.addColumn("Total amount");
		this.model2.addColumn("Unit");
		table2 = new JTable(model2);
		table2.setFillsViewportHeight(true);

		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(746, 304, 400, 200);
		add(scrollPane_1);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBackground(new Color(255, 102, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(519, 304, 41, 34);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Add ingredient that appears on the plate");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(120, 250, 294, 50);
		add(lblNewLabel_2);
		
		JButton button = new JButton("+");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 102, 0));
		button.setBounds(1145, 304, 41, 34);
		add(button);
		
		JLabel lblAddIngredientThat = new JLabel("Add ingredient that does not appear on the plate");
		lblAddIngredientThat.setFont(new Font("Arial", Font.BOLD, 15));
		lblAddIngredientThat.setBounds(746, 250, 353, 50);
		add(lblAddIngredientThat);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(120, 304, 400, 200);
		add(scrollPane);
		
		model3 = new DefaultComboBoxModel(labels);
		JComboBox comboBox2 = new JComboBox(model3);
		comboBox2.setBounds(61, 707, 149, 20);
		add(comboBox2);
		
		model4 = new DefaultComboBoxModel(labels2);
		JComboBox comboBox = new JComboBox(model4);
		comboBox.setBounds(299, 707, 140, 20);
		add(comboBox);
		
		model5 = new DefaultComboBoxModel(labels3);
		JComboBox comboBox_1 = new JComboBox(model5);
		comboBox_1.setBounds(554, 707, 140, 20);
		add(comboBox_1);
		
		model6 = new DefaultComboBoxModel(labels4);
		JComboBox comboBox_2 = new JComboBox(model6);
		comboBox_2.setBounds(793, 707, 140, 20);
		add(comboBox_2);
		
		model7 = new DefaultComboBoxModel(labels5);
		JComboBox comboBox_3 = new JComboBox(model7);
		comboBox_3.setBounds(1033, 707, 140, 20);
		add(comboBox_3);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(255, 102, 0));
		btnSearch.setBounds(581, 882, 94, 34);
		btnSearch.setActionCommand("Search");
		btnSearch.addActionListener(this.controller);
		add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(255, 102, 0));
		btnBack.setBounds(61, 882, 94, 34);
		btnBack.setActionCommand("back");
		btnBack.addActionListener(this.controller);
		add(btnBack);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Arial", Font.BOLD, 14));
		lblTime.setBounds(61, 682, 33, 14);
		add(lblTime);
		
		JLabel lblAvailability = new JLabel("availability");
		lblAvailability.setFont(new Font("Arial", Font.BOLD, 14));
		lblAvailability.setBounds(299, 683, 84, 14);
		add(lblAvailability);
		
		JLabel lblStars = new JLabel("Stars");
		lblStars.setFont(new Font("Arial", Font.BOLD, 14));
		lblStars.setBounds(553, 683, 41, 14);
		add(lblStars);
		
		JLabel lblDificulty = new JLabel("Dificulty");
		lblDificulty.setFont(new Font("Arial", Font.BOLD, 14));
		lblDificulty.setBounds(793, 682, 63, 14);
		add(lblDificulty);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(1033, 682, 63, 14);
		add(lblCategory);
		
		JButton button_1 = new JButton("-");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(255, 102, 0));
		button_1.setBounds(519, 334, 41, 34);
		add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(255, 102, 0));
		button_2.setBounds(1145, 334, 41, 34);
		add(button_2);
	}
}