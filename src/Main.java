import carteAnimal.*;
import gameplay.affichage.Affichage;

public class Main
{
    public static void main(String[] args) {
       // Partie partie = new Partie();

       // partie.demarrerPartieSansObstacle();

        Affichage aff = new Affichage(new Punaise());
        aff.getCarteLines();


        Affichage aff2 = new Affichage(new Corbeau());
        aff2.getCarteLines();

        Affichage aff3 = new Affichage(new Ecureuil());
        aff3.getCarteLines();

    }
}
