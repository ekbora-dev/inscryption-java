package pouvoirs;

import gameplay.jeu.Joueur;
import typeCarte.Animal;
import typeCarte.Carte;

public class Puant extends Pouvoir{
    public Puant(){
        super("Puant");
    }

    @Override
    public void onAttaque(Animal carte, Joueur joueur, Joueur adversaire) {
        for (int i = 0; i < joueur.getPlateau().length; i++){
            // Si notre case est vide, que la carte qui n'a pas
            if (joueur.getPlateau()[i].isEmpty() || joueur.getPlateau()[i].get() != carte || adversaire.getPlateau()[i].isEmpty()) {
                continue;
            }

            // Sinon, on réduit l'attaque
            Carte enFace = adversaire.getPlateau()[i].get();
            if (enFace.isSacrifiable()) {
                enFace.reduireAttaque(1);
            }
        }
    }
}
