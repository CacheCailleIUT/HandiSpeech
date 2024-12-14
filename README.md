# HandiSpeech

HandiSpeech est un projet innovant visant à faciliter la vie des personnes malentendantes en leur offrant une solution pratique pour suivre des conversations de groupe et recevoir des alertes visuelles sur les sons de leur environnement.

## Objectif

Le projet vise à développer un prototype de système d’aide à la communication et à la perception sonore dans des environnements limités, comme une salle de réunion ou un espace de travail collaboratif. Les principales fonctionnalités incluent :

- **Transcription en temps réel** : convertir la parole en texte pour permettre aux utilisateurs de suivre des conversations.
- **Alertes visuelles** : notifier les utilisateurs en cas de bruit ambiant spécifique (alarme, appel de nom, etc.).

Le projet est principalement développé en **Java**.

## Fonctionnalités

1. **Transcription en temps réel**
    - Analyse vocale pour identifier les dialogues en cours.
    - Affichage en direct du texte correspondant.

2. **Reconnaissance des bruits**
    - Détection de sons prédéfinis (ex. : alarmes, notifications).
    - Notification visuelle pour attirer l’attention de l’utilisateur.

3. **Interface utilisateur intuitive**
    - Une interface claire et simple d’utilisation pour accéder aux transcriptions et alertes.

## Installation

### Prérequis

- **Java 17** ou version supérieure
- **Maven** (facultatif pour la gestion des dépendances)
- Un système d'exploitation compatible (Windows, macOS, Linux)

### Instructions

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/CacheCailleIUT/HandiSpeech.git
   ```

2. Accédez au répertoire du projet :
   ```bash
   cd HandiSpeech
   ```

3. Compilez le projet :
   ```bash
   javac -d bin src/**/*.java
   ```

4. Exécutez l’application :
   ```bash
   java -cp bin Main
   ```

## Utilisation

1. **Lancez l’application.**
2. Attendre quelques secondes que le système se lance.
3. Placez le dispositif dans un environnement de groupe pour observer les transcriptions en temps réel.

## Technologies utilisées

- **Java** : langage principal pour la logique backend.
- **Bibliothèques Sphinx4** : pour la reconnaissance vocale.

## Contributeurs

- **Gabriel Monczewski** : [GitHub](https://github.com/CacheCailleIUT)
- **Jodie Monterde** : [GitHub](https://github.com/JoMonterde)
- **Romain Courbaize** : [GitHub](https://github.com/romaincourbaize)
- **Maxime Froissant** : [GitHub](https://github.com/froissam)