package com.filesearchengine.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.filesearchengine.controller.BaseController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class DesktopUI extends JFrame {

	public static JPanel contentPane;
	public static JTextField textField;
	//private static JPanel leftPanel;
	private static JLabel lblEnterSearchString;
	private static JButton btnClearAllFiles ;
	public static JButton btnNewButton;
	public static JButton btnAddFilesdir;
	public static JButton btnTokenize;
	public static JButton btnPorterStemmer;
	public static JButton btnInvertedIndex;
	public static JButton btnSort;
	public static JButton btnEnterSearchString;
	public static JButton btnRemoveSpecialChar;
	public static JButton btnSpellCheck;
	public static JButton btnTfidfTransform;
	public static JButton btnWordOccurence;
	public static JButton btnFindBestMatched;
	public static ImagePanel leftPanel;
	
	public static JLabel lblResult;
	public static JScrollPane scrollPane_1;
	public static JTextArea textArea;
	public static JPanel panel;
	public static JPanel panel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesktopUI frame = new DesktopUI();
					frame.setTitle("Advanced Computing-Search Engine");
					frame.setVisible(true);
					frame.getContentPane().setBackground(Color.WHITE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DesktopUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\wp-image-142784204.gif"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1231, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		leftPanel = new JPanel();
//		leftPanel.setBackground(new Color(0, 102, 0));
		leftPanel = new ImagePanel(new ImageIcon(".\\t1.jpg").getImage());
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(leftPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1196, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(leftPanel, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
					.addContainerGap())
		);;
		leftPanel.setLayout(null);
		
		
		btnClearAllFiles = new JButton("CLEAR ALL FILES");
		btnClearAllFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(false);
				textField.setVisible(false);
				
				textArea.setText(BaseController.buttonClearAllFIlesClicked());
			}
		});
		btnClearAllFiles.setBounds(15, 81, 210, 52);
		leftPanel.add(btnClearAllFiles);
		btnClearAllFiles.setBackground(Color.WHITE);
		
		btnNewButton = new JButton("ADD FILES-URL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(false);
				textField.setVisible(false);
				textArea.setText(BaseController.buttonAddFilesUrlClicked());;
			}
		});
		btnNewButton.setBounds(15, 159, 210, 52);
		leftPanel.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		
		btnAddFilesdir = new JButton("ADD FILES-DIR");
		btnAddFilesdir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(false);
				textField.setVisible(false);
				textArea.setText(BaseController.buttonAddFilesDirClicked());
			}
		});
		btnAddFilesdir.setBounds(15, 227, 210, 52);
		leftPanel.add(btnAddFilesdir);
		btnAddFilesdir.setBackground(Color.WHITE);
		
		btnTokenize = new JButton("TOKENIZE");
		btnTokenize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(false);
				textField.setVisible(false);
				textArea.setText(BaseController.buttonTokenizeClicked());;
			}
		});
		btnTokenize.setBounds(15, 295, 210, 52);
		leftPanel.add(btnTokenize);
		btnTokenize.setBackground(Color.WHITE);
		
		btnPorterStemmer = new JButton("PORTER STEMMER");
		btnPorterStemmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(false);
				textField.setVisible(false);
				textArea.setText(BaseController.buttonPorterStemmerClicked());;
			}
		});
		btnPorterStemmer.setBounds(15, 363, 210, 52);
		btnPorterStemmer.setBackground(Color.WHITE);
		leftPanel.add(btnPorterStemmer);
		
		btnInvertedIndex = new JButton("INVERTED INDEX");
		btnInvertedIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(false);
				textField.setVisible(false);
				textArea.setText(BaseController.buttonInvertedIndexClicked());;
			}
		});
		btnInvertedIndex.setBounds(15, 431, 210, 52);
		leftPanel.add(btnInvertedIndex);
		btnInvertedIndex.setBackground(Color.WHITE);
		
		btnSort = new JButton("SORT");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(false);
				textField.setVisible(false);
				textArea.setText(BaseController.buttonSortClicked());;
			}
		});
		btnSort.setBounds(15, 499, 210, 46);
		leftPanel.add(btnSort);
		btnSort.setBackground(Color.WHITE);
		
		btnEnterSearchString = new JButton("SEARCH STRING");
		btnEnterSearchString.setBackground(Color.WHITE);
		btnEnterSearchString.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(true);
				textField.setVisible(true);
				textArea.setText(BaseController.buttonSearchStringClicked());;
			}
		});
		btnEnterSearchString.setBounds(240, 81, 210, 52);
		leftPanel.add(btnEnterSearchString);
		
		btnRemoveSpecialChar = new JButton("REMOVE SPECIAL CHAR");
		btnRemoveSpecialChar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(true);
				textField.setVisible(true);
				textArea.setText(BaseController.buttonRemoveSpecialCharClicked());;
			}
		});
		btnRemoveSpecialChar.setBackground(Color.WHITE);
		btnRemoveSpecialChar.setBounds(240, 159, 210, 52);
		leftPanel.add(btnRemoveSpecialChar);
		
		btnSpellCheck = new JButton("SPELL CHECK");
		btnSpellCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(true);
				textField.setVisible(true);
				textArea.setText(BaseController.buttonSpellCheckClicked());;
			}
		});
		btnSpellCheck.setBackground(Color.WHITE);
		btnSpellCheck.setBounds(240, 227, 210, 52);
		leftPanel.add(btnSpellCheck);
		
		btnTfidfTransform = new JButton("TF-IDF TRANSFORM");
		btnTfidfTransform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(true);
				textField.setVisible(true);
				textArea.setText(BaseController.buttonTfIdfTransformClicked());;
			}
		});
		btnTfidfTransform.setBackground(Color.WHITE);
		btnTfidfTransform.setBounds(240, 295, 210, 52);
		leftPanel.add(btnTfidfTransform);
		
		btnWordOccurence = new JButton("WORD OCCURENCE");
		btnWordOccurence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(true);
				textField.setVisible(true);
				textArea.setText(BaseController.buttonWordOccurenceClicked());;
			}
		});
		btnWordOccurence.setBackground(Color.WHITE);
		btnWordOccurence.setBounds(240, 364, 210, 52);
		leftPanel.add(btnWordOccurence);
		
		btnFindBestMatched = new JButton("FIND BEST MATCHED");
		btnFindBestMatched.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEnterSearchString.setVisible(true);
				textField.setVisible(true);
				textArea.setText(BaseController.buttonFindBestMatchedClicked());;
			}
		});
		btnFindBestMatched.setBackground(Color.WHITE);
		btnFindBestMatched.setBounds(240, 431, 210, 114);
		leftPanel.add(btnFindBestMatched);
		
		panel = new JPanel();
		panel.setBounds(477, 81, 719, 464);
		leftPanel.add(panel);
		panel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 30, 719, 434);
		panel.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		lblResult = new JLabel("RESULT");
		lblResult.setForeground(Color.WHITE);
		lblResult.setBackground(Color.WHITE);
		lblResult.setBounds(0, 0, 69, 20);
		panel.add(lblResult);
		
		panel_1 = new JPanel();
		panel_1.setBounds(532, 16, 523, 49);
		leftPanel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(187, 16, 308, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblEnterSearchString = new JLabel("ENTER SEARCH STRING");
		lblEnterSearchString.setForeground(Color.WHITE);
		lblEnterSearchString.setBackground(Color.WHITE);
		lblEnterSearchString.setBounds(15, 16, 157, 26);
		panel_1.add(lblEnterSearchString);
		panel.setOpaque(false);
		panel_1.setOpaque(false);
		lblEnterSearchString.setVisible(false);
		textField.setVisible(false);
		contentPane.setLayout(gl_contentPane);
		
	}
}
class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	}
