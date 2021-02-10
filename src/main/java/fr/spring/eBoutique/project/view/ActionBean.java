package fr.spring.eBoutique.project.view;


public abstract class ActionBean {

	private Application application;
	//protected final Logger logger = LogManager.getLogger(ActionBean.class);
	public static boolean seConnecter(String login, String password) {
		
		String message="action 'se connecter' a �t� activ�e.";
		System.out.println(message);
//		Logger.info(message);
		
		return false;
	}

	public static void creerCompte(String nom, String prenom, String age, String role,String telephone, String login, String email, String password,
									String numero, String rue, String ville, String codePostal) {
		
//		boolean isExistEmail=getUtilisateurByEmail(email);
//		if (isExistEmail) {
		
			System.out.println("action 'cr�er compte' a �t� activ�e.");
		
//			return false;
			
			
//			Adresse adresse = new Adresse();
//			adresse.setNumero(numero);
//			adresse.setRue(application.getTextFieldRue().getText());
//			adresse.setVille(application.getTextFieldVille().getText());
//			adresse.setCodePostal(application.getTextCodePostal.getText());
//			
			
			
	

	
	}

}
