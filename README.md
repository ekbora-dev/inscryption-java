# Inscryption Java

Un jeu en Java inspiré d'Inscryption.

Ce tutoriel explique comment récupérer le projet et le lancer sur ta machine, même si tu n'as jamais utilisé Java ou Git.

## Prérequis

Avant de commencer, tu as besoin de deux choses installées sur ton ordinateur :

- **Git**, pour récupérer (cloner) le projet. Télécharge-le sur [git-scm.com](https://git-scm.com/downloads).
- **Java Development Kit (JDK) version 11 ou supérieure**. Télécharge-le par exemple sur [Adoptium](https://adoptium.net/) (choisis la version 11 ou plus récente).

Pour vérifier que tout est bien installé, ouvre un terminal (ou l'invite de commandes sur Windows) et tape :

```bash
git --version
java -version
javac -version
```

Si chaque commande t'affiche un numéro de version sans erreur, c'est bon.

## 1. Cloner le projet

Ouvre un terminal, place-toi dans le dossier où tu veux télécharger le projet, puis tape :

```bash
git clone https://github.com/ekbora-dev/inscryption-java.git
```

Cela crée un dossier `inscryption-java` contenant tout le code du jeu. Déplace-toi ensuite dans ce dossier :

```bash
cd inscryption-java
```

## 2. Compiler le projet

Le code source se trouve dans le dossier `src/`. Le projet contient déjà un dossier `out/` à la racine, destiné à recevoir les fichiers compilés. Depuis la racine du projet, tape :

```bash
javac -d out $(find src -name "*.java")
```

> **Sur Windows**, la commande `find` n'existe pas dans l'invite de commandes classique. Utilise plutôt PowerShell et la commande suivante :
> ```powershell
> javac -d out (Get-ChildItem -Recurse -Filter *.java -Path src).FullName
> ```

Cette commande compile tous les fichiers `.java` du dossier `src/` et place les fichiers `.class` générés dans le dossier `out/`.

## 3. Lancer le jeu

Une fois la compilation terminée sans erreur, lance le jeu avec :

```bash
java -cp out Main
```

Le jeu devrait alors démarrer.

## Résumé des commandes

```bash
git clone https://github.com/ekbora-dev/inscryption-java.git
cd inscryption-java
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Problèmes fréquents

**`javac` ou `java` n'est pas reconnu comme une commande**
Le JDK n'est pas installé ou n'est pas ajouté au PATH de ton système. Réinstalle le JDK en suivant les instructions d'installation, ou recherche "ajouter Java au PATH" pour ton système d'exploitation.

**Erreur `Could not find or load main class Main`**
Vérifie que tu lances bien la commande `java -cp out Main` depuis la racine du projet (le dossier qui contient `out/`), et que la compilation à l'étape 2 s'est terminée sans erreur.

**Erreurs lors de la compilation**
Assure-toi d'avoir bien Java 11 ou une version plus récente (`java -version`), et que tu es bien dans le dossier racine du projet lors de l'exécution des commandes.
