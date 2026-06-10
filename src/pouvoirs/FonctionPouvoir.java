package pouvoirs;

import gameplay.jeu.Joueur;
import typeCarte.Animal;

public interface FonctionPouvoir {
    String getNom();
    void onAttaque(Animal carte, Joueur joueur, Joueur adversaire);
    void onDefense(Animal carte, Joueur joueur, Joueur adversaire);
}
