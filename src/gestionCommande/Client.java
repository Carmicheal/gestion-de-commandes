package gestionCommande;

import java.io.Serializable;
import java.util.ArrayList;
/** La classe Client sert a instancier de nouveaux clients.
 * Les clients sont renseignes par leur nom et leur adresse.
 * La classe Client implemente l'interface Serializable.
 * @author Rouinsard
 */
public class Client implements Serializable{
	private String nomClient;
	private String adrClient;
	private String adrEmail;
	private String telClient;
	private String faxClient;
	
	/** \brief Methode permettant la saisie du client par l'utilisateur.
	 * 	\details La saisie utilise la classe Lire, afin que l'utilisateur puisse saisir les donnees.
	 */
	public void saisirClient(){
		System.out.println("Saisir le nom du client :");
		this.nomClient = Lire.S();
		System.out.println("Saisir l'adresse de ce client :");
		this.adrClient = Lire.S();
		System.out.println("Saisir l'adresse mail du client :");
		this.adrEmail = Lire.S();
		System.out.println("Saisir le numéro de téléphone du client au format internationnal : ");
		this.telClient = Lire.S();
		System.out.println("Saisir le numéro de fax du client au format internationnal : ");
		this.faxClient = Lire.S();
	}
	
	/**
	 * \brief Methode permettant l'affichage du client.
	 */
	public void afficherClient(){
		System.out.println("Le client " + this.getNom() + " habite au " + this.getAdresse() + ".");
	}
	
	/**
	 * \brief Methode permettant de saisir uniquement l'adresse du client.
	 * 	\details Permet de saisir uniquement l'adresse du client afin de pouvoir modifier celle-ci sans alterer les autres attributs du client. Cette methode utilise egalement la classe Lire.
	 */
	public void saisirAdresse(){
		System.out.println("Saisir la nouvelle adresse du client : ");
		this.adrClient = Lire.S();
	}
	
	/** \brief Methode permettant de saisir uniquement l'adresse e-mail du client.
	 */
	public void saisirMail(){
		System.out.println("Saisir la nouvelle adresse e-mail du client :");
		this.adrEmail = Lire.S();
	}
	
	/** \brief Methode permettant de saisir uniquement le numero de telephone du client.
	 */
	public void saisirTel(){
		System.out.println("Saisir le nouveau numéro de téléphone du client (au format internationnal) :");
		this.telClient = Lire.S();
	}
	
	/** \brief Methode permettant de saisir uniquement le numero de fax du client.
	 */
	public void saisirFax(){
		System.out.println("Saisir le numéro de fax du client (au format internationnal) : ");
		this.faxClient = Lire.S();
	}
	
	/** \brief Methode permettant de recuperer le nom du client.
	 * @return this.nomClient	Correspond au nom du client.
	 */
	public String getNom(){
		return this.nomClient;
	}
	
	/** \brief Methode permettant de recuperer l'adresse du client.
	 * @return this.adrClient	Correspond a l'adresse du client.
	 */
	public String getAdresse(){
		return this.adrClient;
	}
	
	/** \brief Methode permettant de recuperer l'adresse e-mail du client.
	 * @return this.adrEmail	Correspond a l'adresse e-mail du client.
	 */
	public String getMail(){
		return this.adrEmail;
	}
	
	/** \brief Methode permettant de recuperer le numero de telephone du client.
	 * @return this.telClient	Correspond au numero de telephone du client.
	 */
	public String getTel(){
		return this.telClient;
	}
	
	/** \brief Methode permettant de recuperer le numero de fax du client.
	 * @return this.faxClient	Correspond au numero de fax du client.
	 */
	public String getFax(){
		return this.faxClient;
	}
	
	/** \brief Methode permettant de rechercher un client dans une collection.
	 * 	\details Cette methode recherche un client a partir de son nom dans une collection passee en parametre, puis la fonction renvoie un client ou null si aucun client n'a pu etre trouvee.
	 * @param unNom		Correspond au nom du client que l'on recherche.
	 * @param unTabClient	Correspond a la collection dans laquelle on recherche le client.
	 * @return	Client
	 */
	public static Client rechercheClient(String unNom, ArrayList<Client> unTabClient){
		for (int i = 0; i < unTabClient.size(); i++){
			if(unTabClient.get(i).getNom().equals(unNom))
				return unTabClient.get(i);
		}
		return null;
	}
	
}
