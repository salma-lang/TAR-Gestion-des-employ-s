## TAR:Gestion des employés
## Introduction: 
Ce projet consiste en la création d'une application Java utilisant JDBC pour la gestion des employés (managers et développeurs) au sein d'une entreprise. Il permet la création, la lecture, la mise à jour et la suppression (CRUD) d'informations stockées dans une base de données, tout en gérant la hiérarchie entre les employés.

##  Prérequis :
Java

JDBC

MySQL (via phpMyAdmin)

Eclipse nebeans

## Fonctionnalités:
1. Connexion à la base de données : La classe connexion gère la connexion à la base de données à l'aide d'un fichier base.properties contenant les informations de configuration.
2. Modélisation des employés : -Classe Personne pour les informations de base des employés (id, nom, salaire).
   
                               -Classe Manager pour représenter un manager, incluant une liste de développeurs.
   

                               -Classe Developpeur pour représenter les développeurs.

4. Opérations CRUD : Utilisation des interfaces DAO pour gérer les opérations CRUD sur les objets Manager et Developpeur.
5. Hiérarchie des employés : L'application permet de représenter la relation hiérarchique entre les managers et les développeurs.

## Étapes d'installation:
## 1. Création d’un fichier properties nommé base:
La première étape consiste à créer un fichier de configuration nommé base.properties pour stocker les informations de connexion à la base de données. Ce fichier contient les paramètres essentiels comme l'URL de la base de données, le nom d'utilisateur, et le mot de passe. Pour cela, dans Netbeans, un clic droit sur le projet permet de sélectionner "New" puis "Other", après quoi "Properties File" est choisi pour créer le fichier de configuration. Ce fichier est ensuite rempli avec les détails de connexion, ce qui facilitera la gestion centralisée des paramètres de connexion dans l'application.
## 2. Création d’une classe de connexion:
Ensuite, une classe connexion est créée pour établir la connexion à la base de données. Cette classe lit les informations du fichier base.properties et les utilise pour créer une connexion à la base de données via JDBC. Elle contient des méthodes statiques pour ouvrir le fichier de configuration, charger le driver JDBC, et se connecter à la base de données à l'aide de DriverManager.getConnection(). Cette approche permet de réutiliser facilement la connexion à travers l'application sans avoir à reconfigurer les paramètres à chaque fois.
## 3. Création des classes Personne, Manager, et Développeur:
Trois classes principales sont définies pour modéliser les employés :
-Personne :La classe de base qui représente un employé avec des attributs comme l'identifiant, le nom, et le salaire.
-Manager : Hérite de la classe Personne et inclut des méthodes pour gérer une liste de développeurs sous sa responsabilité.
-Développeur : Hérite également de Personne et conserve les caractéristiques de base tout en adaptant la méthode d'affichage.
Ces classes permettent de représenter les employés sous forme d'objets avec les relations hiérarchiques entre managers et développeurs.
## 
Voici une explication des étapes du projet en paragraphes détaillés :

1. Création d’un fichier properties nommé base
La première étape consiste à créer un fichier de configuration nommé base.properties pour stocker les informations de connexion à la base de données. Ce fichier contient les paramètres essentiels comme l'URL de la base de données, le nom d'utilisateur, et le mot de passe. Pour cela, dans l'IDE, un clic droit sur le projet permet de sélectionner "New" puis "Other", après quoi "Properties File" est choisi pour créer le fichier de configuration. Ce fichier est ensuite rempli avec les détails de connexion, ce qui facilitera la gestion centralisée des paramètres de connexion dans l'application.

2. Création d’une classe de connexion
Ensuite, une classe connexion est créée pour établir la connexion à la base de données. Cette classe lit les informations du fichier base.properties et les utilise pour créer une connexion à la base de données via JDBC. Elle contient des méthodes statiques pour ouvrir le fichier de configuration, charger le driver JDBC, et se connecter à la base de données à l'aide de DriverManager.getConnection(). Cette approche permet de réutiliser facilement la connexion à travers l'application sans avoir à reconfigurer les paramètres à chaque fois.

3. Création des classes Personne, Manager, et Développeur
Trois classes principales sont définies pour modéliser les employés :

Personne : La classe de base qui représente un employé avec des attributs comme l'identifiant, le nom, et le salaire.
Manager : Hérite de la classe Personne et inclut des méthodes pour gérer une liste de développeurs sous sa responsabilité.
Développeur : Hérite également de Personne et conserve les caractéristiques de base tout en adaptant la méthode d'affichage.
Ces classes permettent de représenter les employés sous forme d'objets avec les relations hiérarchiques entre managers et développeurs.

## 4. Création d’une interface IDao:
Une interface générique IDao est définie pour standardiser les opérations de manipulation des données. Elle contient des méthodes abstraites comme create, update, delete, getById, et getAll, qui facilitent les opérations CRUD. Cette interface sert de contrat pour les classes de service, leur permettant de manipuler les objets (managers et développeurs) de manière cohérente avec une abstraction des détails de l'implémentation des requêtes SQL.
## 5. Création des classes ManagerService et DéveloppeurService:
Ces deux classes implémentent l'interface IDao pour fournir des fonctionnalités spécifiques à la gestion des objets Manager et Développeur. Elles contiennent des méthodes qui interagissent directement avec la base de données en utilisant des requêtes SQL. Par exemple, la méthode create() permet d'insérer de nouveaux managers ou développeurs, tandis que update() et delete() permettent de modifier ou supprimer les enregistrements existants.
## 6. Création d’une classe Entreprise pour tester les opérations CRUD:
Une classe Entreprise est développée pour tester la fonctionnalité CRUD (Create, Read, Update, Delete) des services. Dans cette classe, des objets Manager et Développeur sont créés, modifiés, et affichés. La méthode afficherHierarchie() permet de représenter la hiérarchie des employés, en partant du directeur général jusqu'aux développeurs, tout en respectant les relations de gestion. Cette classe permet de valider que les opérations sur la base de données fonctionnent correctement et que la hiérarchie des employés est bien gérée.
## 7. Conclusion et validation:
Après l'exécution des tests dans la classe Entreprise, les résultats sont vérifiés, à la fois dans netbeans et dans phpMyAdmin, pour s'assurer que les enregistrements sont correctement créés et affichés. Le programme est capable de gérer les relations hiérarchiques entre les managers et les développeurs, et d'exécuter les opérations CRUD avec succès.
