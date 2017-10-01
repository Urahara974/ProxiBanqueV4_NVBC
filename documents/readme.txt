	************************************
*****         	ProxiBanqueSI		       *****
	************************************

Nom de l'application :
		
		ProxiBanqueV4_NVBC


Concepteurs/développeurs:

		Brice ADELIN
		Cyril RABINEAU
		Nabil BOUAOULI
		Van-anh HOANG


Date : Vendredi 8 Septembre 2017

Version : version 4 de ProxiBanqueSI



	************************************ 
*****      	     Fichiers fournis :	        *****
	************************************

Le dossier Spring/Eclipse "ProxiBanqueV4_NVBC" du projet contient dans le répertoire "documents" :

1) Le document PDF "Proxibanque-v1-PROJET-UML-JAVA-JSE" : énoncé du premier projet réalisé et qui décrit les fonctionnalités de l'application que demandent le client. Ses fonctionnalités sont communes pour l'ensemble des projets réalisés.

2) Le document PDF "Proxibanque-v4-PROJET-JSF-SPRING-JPA-MAVEN-GIT-LOG4J-WS" : énoncé du projet final

3) Le fichier "readme.txt".

4) Le fichier "proxibanquev4nvbc.sql", qui est le script permettant la création d'une base de données initiale de clients.

5) Le fichier "tomcat-users.xml" permettant de paramétrer la sécurité du server Tomcat.




	************************************
*****  	   Description de l'application :   	*****
	************************************

ProxibanqueSI est une application bancaire.
Après connexion à ProxibanqueSI, le conseiller de clientèle peut créer, lire ou modifier les informations relatives à un client. 
Le logiciel permet également au conseiller de récupérer une liste de clients, une liste des comptes ou d'effectuer un virement de compte à compte.*
Les fonctionnalités implémentées sont donc :
- Créer un client et ses comptes (courant et épargne) associés.
- Lister les clients.
- Voir les informations relatives à un client.
- Modifier les informations relatives à un client.
- Supprimer un client.
- Lister l'ensemble des comptes des clients.
- Voir les informations des comptes pour un client.
- Modifier les informations des comptes pour un client.
- Effectuer un virement de compte à compte (tout virement effectué est enregistré dans la base de données).




	************************************
*****  	  Installation de l'IDE Eclipse :       *****
	************************************

Il est nécessaire d'installer La version Java Edition Entreprise (JEE) de l'IDE Eclipse (Eclipse IDE for Java EE Developers), afin de pouvoir faire fonctionner l'application.
1) Télécharger Eclipse IDE for Java EE Developers - release Oxygen : http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygenrc2
2) Extraire la fichier .zip téléchargé.



	************************************
*****  	 Installation de Spring Tool Suite :    *****
	************************************

Le projet ayant été réalisé avec le Framework Spring, il est nécessaire d'installer ce framework.
1) Télécharger Spring Tool Suite (STS) : https://spring.io/tools
2) Extraire la fichier .zip téléchargé.
3) Lancer sts-bundle\sts-$version_de_la_release$\STS.exe afin de démarrer spring.





	************************************
*****  	    Importer la base de données   	*****
	************************************

Pour importer la base de données, veuillez suivre les étapes suivantes :

1) Enregistrez le fichier proxibanquev4nvbc.sql sur votre PC.

Télécharger la version du logiciel XAMPP correspondant à votre système d'exploitation (Windows, Linux...) à l'adresse suivante : https://www.apachefriends.org/fr/index.html

2) Installer XAMPP, en sélectionnant les modules Apache, MySQL, Tomcat, FileZilla et Mercury.

3) Ouvrir XAMPP, et démarrer les modules Apache et MySQL.

4) Appuyez sur le bouton Admin du module MySQL, une page de gestion des bases de données s'ouvre dans votre navigateur par défaut.

5) Créer une base de donnée avec pour nom : proxibanquev4nvbc.sql

5) Pour cette base de donnée, importer le script "proxibanquev4nvbc.sql".

6) Exécuter le script afin de générer la base de données.

7) Laisser XAMPP allumé.


	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:

1) Copier le dossier "ProxiBanqueV4_NVBC" et coller ce dossier dans le "workspace" de Spring

2) Faire "File -> Import" puis "Maven -> Existing Maven Projects", sélectionner le dossier "ProxiBanqueV4_NVBC" et appuyer sur "ok", et enfin "Finish".
Cela importera le dossier "ProxiBanqueV4_NVBC" dans Spring.

3) Dans la vue "Package Explorer", dérouler le projet "ProxiBanqueV4_NVBC". Puis sélectionner le fichier "pom.xml", faire ALT + F5, dans la fenêtre ouverte, cocher "Force Update of Snapshots/Releases" puis cliquer sur "OK".
Attendre que la mise à jour Maven soit terminée.

4) Dans la vue "Package Explorer", dérouler le dossier "Servers", puis dérouler le dossier "Pivotal tc Server Developer Edition v3.1-config" et remplacer le fichier "tomcat-users.xml" par le fichier du même nom, présent dans le fichier RAR.

5) Dans la vue "Package Explorer", sélectionner le projet "ProxiBanqueV4_NVBC", puis clic-droit "Run As -> Run on Server".
(Si nécessaire, sélectionner le serveur a utilisé : "Pivotal tc Server Developer Edition v3.1" dans "localhost")
L'application se lance !!!

6) Copier dans votre navigateur web le lien : 

7) Pour se connecter à l'application :
- login : conseiller
- mot de passe : conseiller




	************************************ 
*****      	     Bugs connus :  	        *****
	************************************

- La modification des informations des comptes pour un client ne fonctionne pas.

- Lorsqu'on se déconnecte de l'application via le bouton "Déconnexion", lorsque l'on veut se reconnecter, cela ne marche pas.
