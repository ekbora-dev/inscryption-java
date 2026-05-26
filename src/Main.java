import carteAnimal.*;
import gameplay.affichage.Affichage;

public class Main
{
    public static void main(String[] args) {
       // Partie partie = new Partie();

       // partie.demarrerPartieSansObstacle();

        Affichage aff = new Affichage(new Punaise());
        aff.showCarte();


    }
}
