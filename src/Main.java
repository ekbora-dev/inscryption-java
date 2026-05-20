import carteAnimal.*;
import gameplay.jeu.*;
import obstacles.Sapin;
import typeCarte.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        Joueur player1 = new Joueur();

        for (int i = 0; i < 4; i++){
            player1.piocher();
        }

        System.out.println(player1.getPlateau().size());
    }
}
