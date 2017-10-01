	************************************
*****         	ProxiBanqueSI		       *****
	************************************

Nom de l'application :
		
		ProxiBanqueV4_NVBC


Concepteurs/d�veloppeurs:

		Brice ADELIN
		Cyril RABINEAU
		Nabil BOUAOULI
		Van-anh HOANG


Date : Vendredi 8 Septembre 2017

Version : version 4 de ProxiBanqueSI



	************************************ 
*****      	     Fichiers fournis :	        *****
	************************************

Le dossier Spring/Eclipse "ProxiBanqueV4_NVBC" du projet contient dans le r�pertoire "documents" :

1) Le document PDF "Proxibanque-v1-PROJET-UML-JAVA-JSE" : �nonc� du premier projet r�alis� et qui d�crit les fonctionnalit�s de l'application que demandent le client. Ses fonctionnalit�s sont communes pour l'ensemble des projets r�alis�s.

2) Le document PDF "Proxibanque-v4-PROJET-JSF-SPRING-JPA-MAVEN-GIT-LOG4J-WS" : �nonc� du projet final

3) Le fichier "readme.txt".

4) Le fichier "proxibanquev4nvbc.sql", qui est le script permettant la cr�ation d'une base de donn�es initiale de clients.

5) Le fichier "tomcat-users.xml" permettant de param�trer la s�curit� du server Tomcat.




	************************************
*****  	   Description de l'application :   	*****
	************************************

ProxibanqueSI est une application bancaire.
Apr�s connexion � ProxibanqueSI, le conseiller de client�le peut cr�er, lire ou modifier les informations relatives � un client. 
Le logiciel permet �galement au conseiller de r�cup�rer une liste de clients, une liste des comptes ou d'effectuer un virement de compte � compte.*
Les fonctionnalit�s impl�ment�es sont donc :
- Cr�er un client et ses comptes (courant et �pargne) associ�s.
- Lister les clients.
- Voir les informations relatives � un client.
- Modifier les informations relatives � un client.
- Supprimer un client.
- Lister l'ensemble des comptes des clients.
- Voir les informations des comptes pour un client.
- Modifier les informations des comptes pour un client.
- Effectuer un virement de compte � compte (tout virement effectu� est enregistr� dans la base de donn�es).




	************************************
*****  	  Installation de l'IDE Eclipse :       *****
	************************************

Il est n�cessaire d'installer La version Java Edition Entreprise (JEE) de l'IDE Eclipse (Eclipse IDE for Java EE Developers), afin de pouvoir faire fonctionner l'application.
1) T�l�charger Eclipse IDE for Java EE Developers - release Oxygen : http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygenrc2
2) Extraire la fichier .zip t�l�charg�.



	************************************
*****  	 Installation de Spring Tool Suite :    *****
	************************************

Le projet ayant �t� r�alis� avec le Framework Spring, il est n�cessaire d'installer ce framework.
1) T�l�charger Spring Tool Suite (STS) : https://spring.io/tools
2) Extraire la fichier .zip t�l�charg�.
3) Lancer sts-bundle\sts-$version_de_la_release$\STS.exe afin de d�marrer spring.





	************************************
*****  	    Importer la base de donn�es   	*****
	************************************

Pour importer la base de donn�es, veuillez suivre les �tapes suivantes :

1) Enregistrez le fichier proxibanquev4nvbc.sql sur votre PC.

T�l�charger la version du logiciel XAMPP correspondant � votre syst�me d'exploitation (Windows, Linux...) � l'adresse suivante : https://www.apachefriends.org/fr/index.html

2) Installer XAMPP, en s�lectionnant les modules Apache, MySQL, Tomcat, FileZilla et Mercury.

3) Ouvrir XAMPP, et d�marrer les modules Apache et MySQL.

4) Appuyez sur le bouton Admin du module MySQL, une page de gestion des bases de donn�es s'ouvre dans votre navigateur par d�faut.

5) Cr�er une base de donn�e avec pour nom : proxibanquev4nvbc.sql

5) Pour cette base de donn�e, importer le script "proxibanquev4nvbc.sql".

6) Ex�cuter le script afin de g�n�rer la base de donn�es.

7) Laisser XAMPP allum�.


	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:

1) Copier le dossier "ProxiBanqueV4_NVBC" et coller ce dossier dans le "workspace" de Spring

2) Faire "File -> Import" puis "Maven -> Existing Maven Projects", s�lectionner le dossier "ProxiBanqueV4_NVBC" et appuyer sur "ok", et enfin "Finish".
Cela importera le dossier "ProxiBanqueV4_NVBC" dans Spring.

3) Dans la vue "Package Explorer", d�rouler le projet "ProxiBanqueV4_NVBC". Puis s�lectionner le fichier "pom.xml", faire ALT + F5, dans la fen�tre ouverte, cocher "Force Update of Snapshots/Releases" puis cliquer sur "OK".
Attendre que la mise � jour Maven soit termin�e.

4) Dans la vue "Package Explorer", d�rouler le dossier "Servers", puis d�rouler le dossier "Pivotal tc Server Developer Edition v3.1-config" et remplacer le fichier "tomcat-users.xml" par le fichier du m�me nom, pr�sent dans le fichier RAR.

5) Dans la vue "Package Explorer", s�lectionner le projet "ProxiBanqueV4_NVBC", puis clic-droit "Run As -> Run on Server".
(Si n�cessaire, s�lectionner le serveur a utilis� : "Pivotal tc Server Developer Edition v3.1" dans "localhost")
L'application se lance !!!

6) Copier dans votre navigateur web le lien : 

7) Pour se connecter � l'application :
- login : conseiller
- mot de passe : conseiller




	************************************ 
*****      	     Bugs connus :  	        *****
	************************************

- La modification des informations des comptes pour un client ne fonctionne pas.

- Lorsqu'on se d�connecte de l'application via le bouton "D�connexion", lorsque l'on veut se reconnecter, cela ne marche pas.
