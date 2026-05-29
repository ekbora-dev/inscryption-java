import carteAnimal.*;
import gameplay.affichage.Affichage;
import typeCarte.Carte;
import java.util.List;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
       // Partie partie = new Partie();

       // partie.demarrerPartieSansObstacle();

        List<Carte> monDeck = new ArrayList<Carte>();
    // ... ajoute tes 12 cartes (ou moins, le code s'adapte s'il y en a 11 ou 5) ...

        if(!monDeck.isEmpty()){
            Affichage affichage = new Affichage(monDeck.get(0));
            affichage.afficherGrilleDeck(monDeck);
        } else {
            System.out.print("\nça marche pas");
        }

    }
}
