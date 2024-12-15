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

## Étape de conception

Nous avons suivi une **méthode descendante** pour la conception du système. 

1. **Vue globale du système et analyse des besoins**  
   Nous avons commencé par analyser le système dans son ensemble pour identifier ses principales fonctionnalités et contraintes. Cette étape a permis d'identifier les besoins des utilisateurs.
2. **Division récursive du système**  
   Le système a été divisé en parties distinctes :
   - Module de transcription : Gestion du flux audio et conversion de la parole en texte.
   - Module de notifications : Analyse des bruits ambiants et déclenchement d'alertes visuelles.
3. **Détails des modules**  
   Nous avons conçu chaque sous-système séparément, c'est-à-dire que le module de transcription n'a pas eu d'impact sur le module de notification et vice-versa.
   La réalisation des diagrammes UML a donné une vision détaillée de chaque fonctionnalité.
   Cette étape, nous a demandé un investissement important en termes de temps et de ressources. En effet, nous avons effectué de nombreux ajustements au cours de la conception. La création de certains diagrammes nous a permis d’identifier des erreurs ou des omissions dans les diagrammes précédemment réalisés, ce qui nous a conduit à les modifier pour garantir leur cohérence et leur complétude.
   Les diagrammes réalisés sont les suivants :
   - Diagramme de cas d’utilisation
   - Diagramme de séquence
   - Diagramme d’état-transition
   - Diagramme de classes
5. **Développement**  
   Le squelette du système en Java a été basé sur le diagramme de classe. Certains parties de ce dernier ont été ajoutées après le développement. En effet, un module externe permettant l'analyse du son a été utilisé lors du développement.
