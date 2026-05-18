import carteAnimal.*;
import typeCarte.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Carte> mesCartes = new ArrayList<>();
        ArrayList<Carte> sesCartes = new ArrayList<>();
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
            if (mesCartes.get(i) instanceof Combat) {
                Animal c1 = (Animal) mesCartes.get(i);
                Animal c2 = (Animal) sesCartes.get(i);

                c1.attaquer(c2);
                c2.attaquer(c1);
            }
            else {
                if (mesCartes.get(i) instanceof SubisDegat){
                    Obstacle o1 = (Obstacle) mesCartes.get(i);
                    Animal a1 = (Animal) sesCartes.get(i);

                    o1.subirDegat(a1.getAttaque());
                }
            }

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
