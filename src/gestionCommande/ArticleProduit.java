package gestionCommande;

/** La classe ArticleProduit sert a instancier de nouveaux articles, ces articles sont ceux fabriques par l'entreprise.
 * Les articles sont renseignes par leur nom, leur prix a l'unite et leur quantite en stock en plus du cout de fabrication.
 * La classe ArticleProduit herite de la classe Article.
 * @author Rouinsard
 */
public class ArticleProduit extends Article{
	private float coutFabrication;
	
	/** \brief Methode recuperant le cout de fabrication de l'article.
	 * @return this.coutFabrication		Correspond au cout de fabrication de l'article.
	 */
	public float getCoutFabrication(){
		return this.coutFabrication;
	}
	
	/** \brief Methode permettant la saisie d'un nouvel article.
	 * \details Cette methode utilise la classe Lire.
	 * \details La saisie d'un nouvel article se fait a partir d'un super permettant d'acceder a la methode saisirArticle de la classe Article auquel on ajoute un cout de fabrication.
	 */
	public void saisirArticle(){
		super.saisirArticle();
		System.out.println("Saisir le coût de fabrication de cet article :");
		this.coutFabrication = Lire.f();
	}
	
	/** \brief Methode permettant d'afficher les informations de l'article.
	 * \details On utilise un super.afficherArticle de la classe Article.
	 */
	public void afficherArticle(){
		super.afficherArticle();
		System.out.println("L'article a un coût de fabrication de : " + this.coutFabrication + " euros.");
	}
}
