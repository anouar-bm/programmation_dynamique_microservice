# TP: Injection des Dépendances

Ce projet est un travail pratique (TP) du cours **Architecture des Composants d'Entreprise**. Il démontre l'implémentation de l'injection de dépendances en Java en utilisant plusieurs approches. Il met l'accent sur le couplage faible des composants à travers des interfaces et démontre le câblage dynamique des dépendances.

## Structure du Projet

Le projet est organisé en trois packages principaux:

- **dao** - Couche d'Accès aux Données
- **metier** - Couche de Logique Métier
- **presentation** - Couche de Présentation

### Couche DAO

La couche d'accès aux données est responsable de la récupération des données:

- `IDao`: Une interface qui définit le contrat pour l'accès aux données avec une méthode `getValue()`
- `DaoImpl`: Une implémentation de l'interface `IDao` qui retourne une valeur fixe (100)

### Couche Métier

La couche de logique métier contient la logique principale de l'application:

- `IMetier`: Une interface définissant le contrat pour les opérations métier avec une méthode `calcul()`
- `MetierImpl`: Une implémentation de l'interface `IMetier` qui effectue des calculs en utilisant les données de l'implémentation `IDao` injectée

### Couche de Présentation

La couche de présentation démontre comment câbler les dépendances:

- `Presentation2`: Une classe qui démontre l'injection de dépendances dynamique en utilisant la réflexion et un fichier de configuration

## Approche d'Injection de Dépendances

Ce projet démontre l'injection de dépendances dynamique par réflexion:

### Câblage Dynamique (Utilisant la Réflexion)

Dans `Presentation2`, l'application:
1. Lit les noms de classes depuis un fichier de configuration (`config.txt`)
2. Instancie les classes dynamiquement en utilisant la réflexion
3. Injecte l'implémentation DAO dans l'implémentation Métier en utilisant la réflexion

Cette approche permet de changer les implémentations sans modifier ni recompiler le code.

## Configuration

L'application utilise un fichier de configuration texte simple (`config.txt`) qui contient:
- Ligne 1: `org.example.dao.DaoImpl` - L'implémentation DAO à utiliser
- Ligne 2: `org.example.metier.MetierImpl` - L'implémentation Métier à utiliser

Pour changer les implémentations, il suffit de modifier ces classes dans le fichier de configuration.

## Exécution de l'Application

Pour exécuter l'application:

1. Assurez-vous que le fichier `config.txt` contient les noms de classes d'implémentation corrects
2. Exécutez la classe `Presentation2`

Le résultat attendu sera le calcul effectué par `MetierImpl` utilisant la valeur fournie par `DaoImpl` (dans ce cas: 2 * 100 = 200).

## Avantages de cette Architecture

- **Couplage Faible**: Les composants dépendent d'abstractions (interfaces) plutôt que d'implémentations concrètes
- **Testabilité**: Facilité à mocker les dépendances pour les tests unitaires
- **Flexibilité**: Les implémentations peuvent être échangées sans modifier le code client
- **Piloté par Configuration**: Le comportement de l'application peut être modifié via des fichiers de configuration

## Dépendances

- Kit de Développement Java (JDK) 23
- Maven pour la gestion des dépendances