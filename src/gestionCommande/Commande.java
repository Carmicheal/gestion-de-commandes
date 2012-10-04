package gestionCommande;

import java.io.Serializable;

/** La classe Commande sert a instancier de nouvelles commandes.
 * Les commandes sont renseignes par leur numero unique, leur client et l'article commandee par ce client.
 * La classe Commande implemente l'interface Serializable.
 * @author Rouinsard
 */

public class Commande implements Serializable{
	private int numCde;
	private Client leClient;
	private Article larticle;
	
	/** \brief Constructeur de la classe commande.
	 * \details Le constructeur de la classe commande prenant en parametre un numero d'id, un client et un article.
	 * @param num	Un numero de commande unique.
	 * @param cli	Le client effectuant la commande.
	 * @param art	L'article commandee par le client.
	 */
	public Commande(int num, Client cli, Article art){
		this.numCde = num;
		this.leClient = cli;
		this.larticle = art;
	}
	
	/** \brief Methode permettant d'afficher la commande.
	 * \details Cette methode affiche le numero unique de la commande, puis recupere le nom du client grace a la methode geNom() de la classe Client, ainsi que le nom de l'article et le prix a l'unite de celui-ci via les methodes getNomArticle() et getPrixUniraite() de la classe Article.
	 */
	public void afficherCommande(){
		System.out.print("La commande numéro : " + this.numCde);
		System.out.print(" ayant pour client " + this.leClient.getNom());
		System.out.println(" est de " + this.larticle.getNomArticle() + " au prix unitaire de " + this.larticle.getPrixUnitaire() + " euros.");
	}
	
	/** \brief Methode permettant de recuperer le numero de commande.
	 * @return this.numCde 	Correspond au numero de la commande.
	 */
	public int getNum(){
		return this.numCde;
	}
	
	/** \brief Methode permettant de recuperer le client de la commande.
	 * @return this.leClient Correspond au client de la commande.
	 */
	public Client getClient(){
		return this.leClient;
	}
	
	/** \brief Methode permettant de recuperer l'article de la commande.
	 * @return this.larticle	Correspond a l'article de la commande.
	 */
	public Article getArticle(){
		return this.larticle;
	}
}
