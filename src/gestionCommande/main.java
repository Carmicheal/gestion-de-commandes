package gestionCommande;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		ArrayList<Client> colClients;
		Hashtable <String, Article> colArticles;
		Hashtable<String, Commande> colCommandes;
		
		try{
		FileInputStream fichier = new FileInputStream("arrayListClient.txt");
		ObjectInputStream ois = new ObjectInputStream(fichier);
		colClients = (ArrayList<Client>)ois.readObject();
		ois.close();
		}
	catch(java.io.IOException| ClassNotFoundException e2){
		e2.printStackTrace();
		colClients = new ArrayList<Client>();
		}
	
	try{
		FileInputStream fichier = new FileInputStream("hashTableArticle.txt");
		ObjectInputStream ois = new ObjectInputStream(fichier);
		colArticles = (Hashtable<String, Article>) ois.readObject();
		ois.close();
		}
	catch(java.io.IOException| ClassNotFoundException e2){
		e2.printStackTrace();
		colArticles = new Hashtable <String, Article>();
		}
	try{
		FileInputStream fichier = new FileInputStream("hashTableCommande.txt");
		ObjectInputStream ois = new ObjectInputStream(fichier);
		colCommandes = (Hashtable<String, Commande>) ois.readObject();
		ois.close();
		}
	catch(java.io.IOException| ClassNotFoundException e2){
		e2.printStackTrace();
		colCommandes = new Hashtable <String, Commande>();
		}
	
	
		int choixG; // MENU GENERAL
		do{
			System.out.println("1- Gestion Clients.");
			System.out.println("2- Gestion Articles.");
			System.out.println("3- Gestion Commandes.");
			System.out.println("0- Quitter.");
			
			choixG = Lire.i();
			switch(choixG){
				case 1 : int choix; // SOUS-MENU CLIENT
						do{
							System.out.println("1- Ajouter un client.");
							System.out.println("2- Supprimer un client.");
							System.out.println("3- Modifier un client.");
							System.out.println("4- Rechercher un client.");
							System.out.println("5- Lister les clients.");
							System.out.println("0- Quitter.");
							choix = Lire.i();
			
							switch(choix){
								case 1 : Client client1 = new Client();
										client1.saisirClient();
										colClients.add(client1);
										break;
						
								case 2 : System.out.println("Saisir le nom du client à supprimer :");
										String unNom = Lire.S();
										Client cli = Client.rechercheClient(unNom, colClients);
										if(cli==null)
											System.out.println("Client non trouvé.");
										else{
											colClients.remove(cli);
											System.out.println("Client supprimé.");
										}
										break;
						
								case 3 : System.out.println("Saisir le nom du client à modifier :");
										String unNomX = Lire.S();
										Client clientX = Client.rechercheClient(unNomX, colClients);
										if(clientX==null)
											System.out.println("Client non trouvé.");
										else{
											int choixModificationClient; // SOUS-SOUS-MENU MODIFICATION CLIENT
											do{
												System.out.println("1- Modifier l'adresse du client");
												System.out.println("2- Modifier l'adresse e-mail du client");
												System.out.println("3- Modifier le numéro de téléphone du client");
												System.out.println("4- Modifier le numéro de fax du client");
												System.out.println("0- Quitter");
											
												choixModificationClient = Lire.i();
												switch(choixModificationClient){
													case 1 : clientX.saisirAdresse();
															break;
													case 2 : clientX.saisirMail();
															break;
													case 3 : clientX.saisirTel();
															break;
													case 4 : clientX.saisirFax();
															break;
													}
												}while(choixModificationClient != 0);
											}
										break;
						
								case 4 : System.out.println("Saisir le nom du client à rechercher :");
										String unName = Lire.S();
										Client clien = Client.rechercheClient(unName, colClients);
										if(clien==null)
											System.out.println("Client non trouvé.");
										else
											clien.afficherClient();
										break;
						
								case 5 : for(Client clients : colClients){
										clients.afficherClient();
										}
										break;
								}
						}while(choix != 0);
		
						try{
							FileOutputStream fichier = new FileOutputStream("arrayListClient.txt");
							ObjectOutputStream oos = new ObjectOutputStream(fichier);
							oos.writeObject(colClients);
							oos.flush();
							oos.close();
							}
						catch(java.io.IOException e){
							e.printStackTrace();
							}
						break;

		
				case 2 : int choix2; // SOUS-MENU ARTICLE
						do{
							System.out.println("1- Ajouter un article.");
							System.out.println("2- Supprimer un article.");
							System.out.println("3- Modifier le prix unitaire d'un article.");
							System.out.println("4- Modifier la quantité en stock d'un article.");
							System.out.println("5- Rechercher un article.");
							System.out.println("6- Lister les articles.");
							System.out.println("0- Quitter.");
							choix2 = Lire.i();
			
							switch(choix2){
								case 1 : int choix3; // SOUS-SOUS-MENU ARTICLE FABRICATION
									do{
										System.out.println("Voulez vous saisir un article acheté ou fabriqué ?");
										System.out.println("1- Acheté");
										System.out.println("2- Fabriqué");
										System.out.println("0- Quitter");
				 		
										choix3 = Lire.i();
				 			
										switch(choix3){
											case 1 : Article art1 = new Article();
													art1.saisirArticle();
													colArticles.put(art1.getNomArticle(), art1);
													break;
											case 2 : ArticleProduit artProduit1 = new ArticleProduit();
													artProduit1.saisirArticle();
													colArticles.put(artProduit1.getNomArticle(), artProduit1);
													break;
											}
										}while(choix3!=0);
									break;
					
								case 2 : System.out.println("Saisir le nom de l'article à supprimer :");
										String nomArticle = Lire.S();
										try{
											colArticles.remove(nomArticle);
											}
										catch(Exception e){
											System.out.println("L'article n'a pas pu être touvé.");
											}
										break;
					
								case 3 : System.out.println("Saisir le nom de l'article a modifier : ");
										String nomArt = Lire.S();
										if(colArticles.containsKey(nomArt)){
											Article c = colArticles.get(nomArt);
											c.saisirPrixUnitaire();
										}
										break;
										
								case 4 : System.out.println("Saisir le nom de l'article a modifier : ");
										String nomArti = Lire.S();
										if(colArticles.containsKey(nomArti)){
											Article c1 = colArticles.get(nomArti);
											c1.saisirQuantite();
											}
										break;
										
								case 5 : System.out.println("Saisir le nom de l'article à rechercher : ");
										String nomArticles = Lire.S();
										if(colArticles.containsKey(nomArticles)){
											Article c = colArticles.get(nomArticles);
											c.afficherArticle();
										}
										break;
					
								case 6 : Set keySet = colArticles.keySet();
										Iterator it=keySet.iterator();

										while (it.hasNext()){
											Object key=it.next();
											System.out.println("L'article : "+(String)key+" pour un prix unitaire de "+ colArticles.get(key).getPrixUnitaire() + ", avec un stock de " + colArticles.get(key).getStock());
										}
										break;
								}
						}while(choix2 != 0);
		
						try{
							FileOutputStream fichierA = new FileOutputStream("hashTableArticle.txt");
							ObjectOutputStream oos = new ObjectOutputStream(fichierA);
							oos.writeObject(colArticles);
							oos.flush();
							oos.close();
						}
						catch(java.io.IOException e){
							e.printStackTrace();
						}
						break;
				case 3 : int choix4; // SOUS-MENU COMMANDE
						do{
							System.out.println("1- Ajouter une commande.");
							System.out.println("2- Supprimer une commande.");
							System.out.println("3- Lister les commandes.");
							System.out.println("0- Quitter.");
		
							choix4 = Lire.i();
							switch(choix4){
								case 1 : System.out.println("Veuillez choisir un client.");
										for(Client clients : colClients){
											clients.afficherClient();
											}
										String unCli = Lire.S();
										Client client3 = Client.rechercheClient(unCli, colClients);
		
										System.out.println("Veuillez maintenant choisir un article.");
										Set keySet = colArticles.keySet();
										Iterator it=keySet.iterator();

										while (it.hasNext()){
											Object key=it.next();
											if(colArticles.get(key).getStock() > 0)
												System.out.println("L'article : "+(String)key+" pour un prix unitaire de "+ colArticles.get(key).getPrixUnitaire() + ", avec un stock de " + colArticles.get(key).getStock());
											else
												System.out.println("L'article " + (String)key + " est en rupture de stock");
											}
										String unArti = Lire.S();
										Article article3 = colArticles.get(unArti);
										
										System.out.println("Saisir la quantité devant être commandée :");
										int quantiteCommande = Lire.i();;
										if(article3.getStock()-quantiteCommande >= 0)
											article3.changeStock(quantiteCommande);
										else{
											while(article3.getStock()-quantiteCommande < 0){
											System.out.println("Il ne reste que " + article3.getStock() + " " + article3.getNomArticle() + " , veuillez saisir une nouvelle quantité");
											quantiteCommande = Lire.i();
												}
											}
										
										System.out.println("Veuillez choisir un numéro de commande unique.");
										long nbCommande = Lire.l();
					
										Commande commande1 = new Commande(nbCommande, client3, article3, quantiteCommande);
										colCommandes.put(String.valueOf(nbCommande), commande1);
										break;
			
								case 2 : System.out.println("Saisir le numéro de la commande a supprimé.");
										String numCommande = Lire.S();
										try{
											colCommandes.remove(numCommande);
										}
										catch(Exception e){
											System.out.println("L'article n'a pas pu être touvé.");
										}
										break;
			
								case 3 : Set keySetCommande = colCommandes.keySet();
										Iterator itCommande=keySetCommande.iterator();

										while (itCommande.hasNext()){
											Object keyCommande=itCommande.next();
											System.out.println("La commande numéro : " + (String)keyCommande + " dédiée au client " + colCommandes.get(keyCommande).getClient().getNom() + " est une commande de " + colCommandes.get(keyCommande).getQuantiteCommande() + " " + colCommandes.get(keyCommande).getArticle().getNomArticle());
										}
										break;
								}
							}while(choix4!=0);
						try{
							FileOutputStream fichierC = new FileOutputStream("hashTableCommande.txt");
							ObjectOutputStream oos = new ObjectOutputStream(fichierC);
							oos.writeObject(colCommandes);
							oos.flush();
							oos.close();
							}
						catch(java.io.IOException e){
							e.printStackTrace();
							}
						break;
				case 0 : System.out.println("Au revoir.");
						break;
			}
	}while(choixG != 0);
	}
}
