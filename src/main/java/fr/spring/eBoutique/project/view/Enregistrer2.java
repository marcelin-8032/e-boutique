package fr.spring.eBoutique.project.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enregistrer2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField ageField;
	private JTextField emailField;
	private JPasswordField modePasseField;
	private JTextField loginField;
	private JTextField numeroField;
	private JTextField rueField;
	private JTextField villeField;
	private JTextField codePostalField;
	private JButton btnCreer;
	private JComboBox<String> comboBoxRole ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enregistrer2 frame = new Enregistrer2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Enregistrer2() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -35, 841, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 823, 60);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Cr\u00E9er un compte");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 59, 823, 609);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		nomField = new JTextField();
		nomField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nomField.setPreferredSize(new Dimension(20, 40));
		nomField.setBounds(165, 106, 181, 48);
		panel_1.add(nomField);
		nomField.setColumns(10);
		
		prenomField = new JTextField();
		prenomField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prenomField.setPreferredSize(new Dimension(20, 40));
		prenomField.setColumns(10);
		prenomField.setBounds(165, 177, 181, 48);
		panel_1.add(prenomField);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ageField.setPreferredSize(new Dimension(20, 40));
		ageField.setColumns(10);
		ageField.setBounds(165, 248, 181, 48);
		panel_1.add(ageField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setPreferredSize(new Dimension(20, 40));
		emailField.setColumns(10);
		emailField.setBounds(165, 319, 181, 48);
		panel_1.add(emailField);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNom.setBounds(30, 112, 64, 32);
		panel_1.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrenom.setBounds(30, 183, 90, 32);
		panel_1.add(lblPrenom);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(29, 256, 90, 32);
		panel_1.add(lblAge);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(30, 325, 90, 32);
		panel_1.add(lblEmail);
		
		JLabel lblModeDePass = new JLabel("Mode de pass :");
		lblModeDePass.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModeDePass.setBounds(20, 397, 133, 32);
		panel_1.add(lblModeDePass);
		
		JLabel lblRole = new JLabel("Role  :");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRole.setBounds(30, 460, 133, 32);
		panel_1.add(lblRole);
		
		JComboBox comboBoxRole = new JComboBox(new String[] {"Client", "Magasinier", "Admin"});
		comboBoxRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxRole.setBounds(166, 461, 180, 35);
		panel_1.add(comboBoxRole);
		
		JButton btnCreer = new JButton("Cr\u00E9er");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreer.setBackground(Color.GREEN);
		btnCreer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCreer.setBounds(666, 518, 112, 48);
		panel_1.add(btnCreer);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//--------------------
				System.exit(0);
			}
		});
		btnFermer.setBackground(Color.RED);
		btnFermer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFermer.setBounds(498, 518, 112, 48);
		panel_1.add(btnFermer);
		
		modePasseField = new JPasswordField();
		modePasseField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		modePasseField.setPreferredSize(new Dimension(20, 40));
		modePasseField.setBounds(165, 390, 181, 48);
		panel_1.add(modePasseField);
		
		loginField = new JTextField();
		loginField.setPreferredSize(new Dimension(20, 40));
		loginField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginField.setColumns(10);
		loginField.setBounds(165, 35, 181, 48);
		panel_1.add(loginField);
		
		JLabel lblUserName = new JLabel("Login :");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserName.setBounds(29, 41, 112, 32);
		panel_1.add(lblUserName);
		
		numeroField = new JTextField();
		numeroField.setPreferredSize(new Dimension(20, 40));
		numeroField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numeroField.setColumns(10);
		numeroField.setBounds(608, 122, 181, 48);
		panel_1.add(numeroField);
		
		rueField = new JTextField();
		rueField.setPreferredSize(new Dimension(20, 40));
		rueField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rueField.setColumns(10);
		rueField.setBounds(608, 183, 181, 48);
		panel_1.add(rueField);
		
		villeField = new JTextField();
		villeField.setPreferredSize(new Dimension(20, 40));
		villeField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		villeField.setColumns(10);
		villeField.setBounds(608, 248, 181, 48);
		panel_1.add(villeField);
		
		codePostalField = new JTextField();
		codePostalField.setPreferredSize(new Dimension(20, 40));
		codePostalField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		codePostalField.setColumns(10);
		codePostalField.setBounds(608, 319, 181, 48);
		panel_1.add(codePostalField);
		
		JLabel lblNumero = new JLabel("Numero :");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumero.setBounds(484, 122, 112, 32);
		panel_1.add(lblNumero);
		
		JLabel lblRue = new JLabel("Rue :");
		lblRue.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRue.setBounds(484, 185, 112, 32);
		panel_1.add(lblRue);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVille.setBounds(484, 256, 112, 32);
		panel_1.add(lblVille);
		
		JLabel lblCodePostal = new JLabel("Code Postal :");
		lblCodePostal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCodePostal.setBounds(461, 327, 135, 32);
		panel_1.add(lblCodePostal);
		
		JLabel lblNewLabel_1 = new JLabel("Adresse :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(621, 72, 133, 16);
		panel_1.add(lblNewLabel_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-------------------------
				Identification2 identif= new Identification2();
				identif.setVisible(true);
				dispose();
			}
		});
		
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnnuler.setBackground(Color.LIGHT_GRAY);
		btnAnnuler.setBounds(329, 518, 112, 48);
		panel_1.add(btnAnnuler);
	}
//------------------------------------------------------------

	public JTextField getPrenomField() {
		return prenomField;
	}

	public JTextField getAgeField() {
		return ageField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public JPasswordField getModePasseField() {
		return modePasseField;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JTextField getNumeroField() {
		return numeroField;
	}

	public JTextField getRueField() {
		return rueField;
	}

	public JTextField getVilleField() {
		return villeField;
	}

	public JTextField getCodePostalField() {
		return codePostalField;
	}

	public JTextField getNomField() {
		return nomField;
	}

	public JButton getBtnCreer() {
		return btnCreer;
	}

	public JComboBox<String> getComboBoxRole() {
		return comboBoxRole;
	}

}
