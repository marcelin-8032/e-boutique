package fr.spring.eBoutique.project.view;


import fr.spring.eBoutique.project.model.UserRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Application {

	private JFrame frame;
	private JTextField textNom;
	private JTextField textPrenom;
	private JComboBox<Integer> comboBoxAge;
	private JComboBox<String> comboBoxRole;
	private JTextField textTelephone;
	private JTextField textLogin;
	private JTextField textEmail;
	private JPasswordField textPassword;
	private JTextField textNumero;
	private JTextField textRue;
	private JTextField textVille;
	private JTextField textCodePostal;

	public Application() {
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
//		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 410, 224);
		frame.setLocationRelativeTo(null);
		frame.setTitle("e-Boutique");
		frame.setName("fenetrePrincipale");
		frame.setVisible(true);
		
		frame.getContentPane().add(getPanelAccueil());
	}

	private void setPanel(JPanel panel) {
		frame.setLocationRelativeTo(null);
		frame.getContentPane().removeAll();
	    frame.getContentPane().add(panel);
	    frame.revalidate();
	    frame.repaint();
	}
	
	private JPanel getPanelCommande() {
		frame.setBounds(100, 100, 542, 542);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel labelCommandes = new JLabel("Liste des commandes :");
		labelCommandes.setBounds(44, 33, 143, 16);
		panel.add(labelCommandes);
		
		JComboBox comboBoxCommandes = new JComboBox();
		comboBoxCommandes.setBounds(44, 60, 132, 22);
		panel.add(comboBoxCommandes);
		
		return panel;
	}
	
	private JPanel getPanelAccueil() {

		frame.setBounds(100, 100, 410, 224);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel labelBienvenue1 = new JLabel("Bienvenue dans notre site de commerce en ligne.");
		labelBienvenue1.setBounds(55, 38, 292, 16);
		panel.add(labelBienvenue1);

		JLabel labelBienvenue2 = new JLabel("Vous devez vous connecter pour pouvoir continuer.");
		labelBienvenue2.setBounds(55, 67, 292, 16);
		panel.add(labelBienvenue2);

		JButton buttonContinuer = new JButton("Continuer");
		buttonContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click sur se connecter");
				setPanel(getPanelConnection());
			}
		});
		buttonContinuer.setBounds(87, 107, 97, 25);
		panel.add(buttonContinuer);

		JButton buttonQuitter = new JButton("Quitter");
		buttonQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonQuitter.setBounds(216, 107, 97, 25);
		panel.add(buttonQuitter);

		return panel;
	}

	private JPanel getPanelConnection() {

		frame.setBounds(100, 100, 410, 253);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel labelIsConnected = new JLabel("");
		labelIsConnected.setBounds(100, 120, 220, 16);
		panel.add(labelIsConnected);

		JLabel labelLogin = new JLabel("Login :");
		labelLogin.setBounds(39, 16, 56, 16);
		panel.add(labelLogin);

		JTextField textLogin = new JTextField();
		textLogin.setBounds(39, 35, 150, 22);
		panel.add(textLogin);
		textLogin.setColumns(10);

		JLabel labelPassword = new JLabel("Mot de Passe :");
		labelPassword.setBounds(212, 16, 88, 16);
		panel.add(labelPassword);

		JPasswordField textPassword = new JPasswordField();
		textPassword.setBounds(212, 35, 142, 22);
		panel.add(textPassword);

		JButton buttonSeConnecter = new JButton("Se connecter");
		buttonSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isConnected = ActionBean.seConnecter(textLogin.getText(), textPassword.getText());
				if (isConnected) {
					labelIsConnected.setText("Vous �tes bien connect�");
					labelIsConnected.setForeground(Color.GREEN);
				} else {
					labelIsConnected.setText("Login et/ou Mot de passe incorrects !");
					labelIsConnected.setForeground(Color.RED);
				}
			}
		});
		buttonSeConnecter.setBounds(65, 80, 120, 25);
		panel.add(buttonSeConnecter);

		JButton buttonFermer = new JButton("Fermer");
		buttonFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(getPanelAccueil());
			}
		});
		buttonFermer.setBounds(205, 80, 120, 25);
		panel.add(buttonFermer);
		
		JLabel labelCreerCompte = new JLabel("Cliquez ici pour cr�er un nouveau compte...");
		labelCreerCompte.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				labelCreerCompte.setForeground(Color.MAGENTA);
            }
			@Override
            public void mouseExited(MouseEvent e) {
				labelCreerCompte.setForeground(Color.BLUE);
            }
			@Override
            public void mouseClicked(MouseEvent e) {
				setPanel(getPanelCreerCompte());
            }
		});
		labelCreerCompte.setBounds(50, 160, 300, 16);
		labelCreerCompte.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelCreerCompte.setForeground(Color.BLUE);
		labelCreerCompte.setFont(new Font(labelCreerCompte.getFont().getName(),Font.BOLD, labelCreerCompte.getFont().getSize()));
		panel.add(labelCreerCompte);

		return panel;
	}
	
	private JPanel getPanelCreerCompte() {

		frame.setBounds(100, 100, 510, 600);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel labelInfosCompte = new JLabel("Infos du compte :");
		labelInfosCompte.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfosCompte.setBounds(44, 24, 190, 16);
		panel.add(labelInfosCompte);

		JLabel labelNom = new JLabel("Nom :");
		labelNom.setBounds(44, 53, 56, 16);
		panel.add(labelNom);

		textNom = new JTextField();
		textNom.setBounds(44, 72, 190, 22);
		panel.add(textNom);
		textNom.setColumns(25);

		JLabel labelPrenom = new JLabel("Pr�nom :");
		labelPrenom.setBounds(44, 103, 56, 16);
		panel.add(labelPrenom);

		textPrenom = new JTextField();
		textPrenom.setBounds(44, 122, 190, 22);
		panel.add(textPrenom);
		textPrenom.setColumns(25);

		JLabel labelAge = new JLabel("�ge :");
		labelAge.setBounds(44, 157, 56, 16);
		panel.add(labelAge);
		
		comboBoxAge = new JComboBox<Integer>();
		for (int i=10; i<=99; i++) {
			comboBoxAge.addItem(i);
		}
		comboBoxAge.setBounds(44, 179, 56, 22);
		panel.add(comboBoxAge);

		JLabel labelRole = new JLabel("R�le :");
		labelRole.setBounds(44, 214, 56, 16);
		panel.add(labelRole);
		
		comboBoxRole = new JComboBox<String>();
		for (UserRole userRole : UserRole.values()) {
			comboBoxRole.addItem(userRole.getRole());
		}
		comboBoxRole.setBounds(44, 236, 182, 22);
		panel.add(comboBoxRole);
		
		JLabel labelTelephone = new JLabel("T�l�phone :");
		labelTelephone.setBounds(44, 271, 77, 16);
		panel.add(labelTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setColumns(14);
		textTelephone.setBounds(44, 294, 182, 22);
		panel.add(textTelephone);

		JLabel labelLogin = new JLabel("Login :");
		labelLogin.setBounds(44, 329, 56, 16);
		panel.add(labelLogin);
		
		textLogin = new JTextField();
		textLogin.setColumns(25);
		textLogin.setBounds(44, 348, 182, 22);
		panel.add(textLogin);
		
		JLabel labelEmail = new JLabel("Email :");
		labelEmail.setBounds(44, 379, 56, 16);
		panel.add(labelEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(25);
		textEmail.setBounds(44, 398, 182, 22);
		panel.add(textEmail);
		
		JLabel labelPassword = new JLabel("Mot de passe :");
		labelPassword.setBounds(44, 433, 99, 16);
		panel.add(labelPassword);
		
		textPassword = new JPasswordField();
		textEmail.setColumns(15);
		textPassword.setBounds(44, 453, 182, 22);
		panel.add(textPassword);

		JLabel labelAdresse = new JLabel("Adresse :");
		labelAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdresse.setBounds(271, 24, 190, 16);
		panel.add(labelAdresse);
		
		JLabel labelNumero = new JLabel("Num�ro :");
		labelNumero.setBounds(271, 53, 56, 16);
		panel.add(labelNumero);
		
		textNumero = new JTextField();
		textNumero.setColumns(3);
		textNumero.setBounds(271, 72, 56, 22);
		panel.add(textNumero);
		
		JLabel labelRue = new JLabel("Rue :");
		labelRue.setBounds(271, 103, 56, 16);
		panel.add(labelRue);
		
		textRue = new JTextField();
		textRue.setColumns(25);
		textRue.setBounds(271, 122, 190, 22);
		panel.add(textRue);
		
		JLabel labelVille = new JLabel("Ville :");
		labelVille.setBounds(270, 157, 56, 16);
		panel.add(labelVille);
		
		textVille = new JTextField();
		textVille.setColumns(25);
		textVille.setBounds(270, 176, 190, 22);
		panel.add(textVille);
		
		JLabel labelCodePostal = new JLabel("Code postal :");
		labelCodePostal.setBounds(270, 207, 85, 16);
		panel.add(labelCodePostal);
		
		textCodePostal = new JTextField();
		textCodePostal.setColumns(5);
		textCodePostal.setBounds(270, 226, 190, 22);
		panel.add(textCodePostal);

		JButton buttonValider = new JButton("Cr�er compte");
		buttonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionBean.creerCompte(textNom.getText(), textPrenom.getText(), comboBoxAge.getSelectedItem().toString(),
										comboBoxRole.getSelectedItem().toString(), textTelephone.getText(), textLogin.getText(),
										textEmail.getText(), textPassword.getText(), textNumero.getText(), textRue.getText(),
										textVille.getText(), textCodePostal.getText());
			}
		});
		buttonValider.setBounds(60, 500, 120, 25);
		panel.add(buttonValider);

		JButton buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(getPanelConnection());
			}
		});
		buttonAnnuler.setBounds(190, 501, 120, 25);
		panel.add(buttonAnnuler);
		
		JButton buttonQuitter = new JButton("Quitter");
		buttonQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonQuitter.setBounds(320, 501, 120, 25);
		panel.add(buttonQuitter);

		return panel;
	}
	
}
