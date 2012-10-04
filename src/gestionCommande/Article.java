package gestionCommande;

import java.io.Serializable;
/** La classe Article sert a instancier de nouveaux articles.
 * Les articles sont renseignes par leur nom, leur prix a l'unite et leur quantite en stock.
 * La classe Article implemente l'interface Serializable.
 * @author Rouinsard
 */
public class Article implements Serializable{
	private String nomArticle;
	private float prixUnitaire;
	private int qteStock;
	
	/** \brief Methode permettant la saisie d'un article.
	 *  \details Cette methode utilise la classe Lire afin de faire saisir les donnes par l'utilisateur.
	 */
	public void saisirArticle(){
		System.out.println("Veuillez saisir le nom de l'article :");
		this.nomArticle = Lire.S();
		System.out.println("le prix unitaire de cet article : ");
		this.prixUnitaire = Lire.f();
		System.out.println("la quantité en stock de l'article :");
		this.qteStock = Lire.i();
	}
	
	/** \brief Methode permettant d'afficher l'article.
	 *  \details Cette methode permet d'afficher le nom, le prix a l'unite et la quantite en stock de l'article selectionne.
	 */
	public void afficherArticle(){
		System.out.println("L'article " + this.nomArticle + " a un prix unitaire de " + this.prixUnitaire + " euros, la quantité en stock de cet article est de " + this.qteStock);
	}
	
	/** \brief Methode permettant de saisir le prix a l'unite.
	 *  \details Cette methode sert a faire saisir uniquement le prix a l'unite pour ne pas alterer le nom de l'article ou sa quantite.
	 */
	public void saisirPrixUnitaire(){
		System.out.println("Saisir le nouveau prix unitaire de l'article : ");
		this.prixUnitaire = Lire.i();
	}
	
	/** \brief Methode permettant de recuperer le nom de l'article.
	 * @return this.nomArticle	Correspond au nom de l'article.
	 */
	public String getNomArticle(){
		return this.nomArticle;
	}
	
	/** \brief Methode permettant de recuperer le prix unitaire de l'article.
	 * @return this.prixUnitaire	Correspond au prix a l'unite de l'article.
	 */
	public float getPrixUnitaire(){
		return this.prixUnitaire;
	}
	
	/** \brief Methode permettant de recuperer la quantite en stock de l'article.
	 * @return this.qteStock	Correspond a la quantite en stock de l'article.
	 */
	public int getStock(){
		return this.qteStock;
	}
}
