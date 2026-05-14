import carteAnimal.*;
import typeCarte.Animal;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Animal> mesCartes = new ArrayList<Animal>();
        ArrayList<Animal> sesCartes = new ArrayList<Animal>();
        Animal ecu = new Ecureuil();
        Animal chat = new Chat();

        // Cartes sur le plateau
        for (int i = 0; i < 3; i++){
            mesCartes.add(ecu);
            sesCartes.add(chat);
        }

        mesCartes.add(new Grizzly());
        sesCartes.add(new Moineau());

        // Attaque des cartes
        for (int i = 0; i < 4; i++){
            mesCartes.get(i).attaquer(sesCartes.get(i));
            sesCartes.get(i).attaquer(mesCartes.get(i));
        }

        for (int i = 0; i < 4; i++){
            if (mesCartes.get(i).getPV() > 0){
                System.out.println(mesCartes.get(i).getNom() + " gagne la case " + i);
            } else {
                System.out.println(sesCartes.get(i).getNom() + " gagne la case " + i);
            }
        }
    }
}
