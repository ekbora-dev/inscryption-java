package pouvoirs;

import gameplay.jeu.Joueur;
import typeCarte.Animal;

public abstract class Pouvoir implements FonctionPouvoir {

    private String m_nom;

    public Pouvoir(String nom){
        m_nom = nom;
    }

    @Override
    public String getNom() {
        return m_nom;
    }

    // Pouvoir appelé si on attaque
    @Override
    public void onAttaque(Animal carte, Joueur joueur, Joueur adversaire) {

    }

    // Pouvoir appelé si on est attaqué
    @Override
    public void onDefense(Animal carte, Joueur joueur, Joueur adversaire) {

    }
}
