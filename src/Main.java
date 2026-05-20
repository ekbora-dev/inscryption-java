import carteAnimal.*;
import gameplay.affichage.Affichage;
import obstacles.Sapin;
import typeCarte.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        ArrayList<Carte> mesCartes = new ArrayList<>();
        ArrayList<Carte> sesCartes = new ArrayList<>();
        Animal ecu = new Ecureuil();
        Animal chat = new Chat();

        // Cartes sur le plateau
        for (int i = 0; i < 3; i++) {
            mesCartes.add(ecu);
            sesCartes.add(chat);
        }

        for (int i = 0; i < 4; i++){
            Affichage aff = new Affichage(new Grizzly());
            aff.showCarte();
        }

        mesCartes.add(new Grizzly());
        sesCartes.add(new Sapin());

        // Attaque des cartes
        for (int i = 0; i < 4; i++) {
            mesCartes.get(i).attaquer(sesCartes.get(i));
            sesCartes.get(i).attaquer(mesCartes.get(i));
        }

        for (int i = 0; i < 4; i++) {
            if (mesCartes.get(i).getPV() > 0) {
                System.out.println(mesCartes.get(i).getNom() + " gagne la case " + i);
            } else {
                System.out.println(sesCartes.get(i).getNom() + " gagne la case " + i);
            }
        }

    }
}
