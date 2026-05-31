import carteAnimal.*;
import gameplay.affichage.Affichage;
import gameplay.jeu.*;
import typeCarte.*;

public class Main
{
    public static void main(String[] args) {
       // Partie partie = new Partie();
        // partie.demarrerPartieSansObstacle();


        Affichage aff = new Affichage(new Chat());

        aff.Gameplay();
    }
}
