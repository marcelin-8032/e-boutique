package fr.spring.eBoutique.project.view;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Identification extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
//------------------------------------------------------------
	private Connection connexion= null;
//------------------------------------------------------------------	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identification frame = new Identification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Identification() {
//-----------------------------------------------------------------		
		if (connexion == null) {
			try {
				connexion= DataSourceConnexion.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//------------------------------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 414);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.RED);
		panel.setBounds(0, 0, 534, 66);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Identifiez-vous");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setForeground(Color.GRAY);
		panel_1.setBounds(0, 64, 534, 309);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		loginField = new JTextField();
		loginField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginField.setBounds(176, 57, 214, 46);
		panel_1.add(loginField);
		loginField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(95, 55, 69, 46);
		panel_1.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Mode de Pass :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(29, 123, 135, 46);
		panel_1.add(lblPassword);
		
		JButton ButtonLogin = new JButton("Se Connecter");
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//------------------------------------------------------------------------------------------
				String login = loginField.getText();
                String password = passwordField.getText();
                try {
                	PreparedStatement st = connexion.prepareStatement("Select login, password from utilisateur where login=? and password=?");
                    st.setString(1, login);
                    st.setString(2, password);
      
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        Identification idnt= new Identification();
                        idnt.setTitle("Welcome to your private page");
                        idnt.setVisible(true);
                        JOptionPane.showMessageDialog(ButtonLogin, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(ButtonLogin, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }	
			}
//----------------------------------------------------------------
		});
		ButtonLogin.setForeground(Color.GRAY);
		ButtonLogin.setBackground(Color.GREEN);
		ButtonLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		ButtonLogin.setBounds(335, 206, 146, 39);
		panel_1.add(ButtonLogin);
		
		JButton btnCancel2 = new JButton("Fermer");
		btnCancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel2.setBackground(Color.RED);
		btnCancel2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel2.setForeground(Color.BLACK);
		btnCancel2.setBounds(129, 206, 107, 39);
		panel_1.add(btnCancel2);
		
		JLabel VarCreateAcount = new JLabel("Nouveau client ? Commencer ici");
		VarCreateAcount.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		VarCreateAcount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Enregistrer enreg;
				try {
					enreg = new Enregistrer();
					enreg.setVisible(true);
					enreg.pack();
					enreg.setLocationRelativeTo(null);
					enreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Identification.this.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		VarCreateAcount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		VarCreateAcount.setFont(new Font("Tahoma", Font.BOLD, 13));
		VarCreateAcount.setForeground(Color.WHITE);
		VarCreateAcount.setBounds(163, 268, 363, 16);
		panel_1.add(VarCreateAcount);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordField.setBounds(176, 123, 214, 46);
		panel_1.add(passwordField);
	}


	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}


}
