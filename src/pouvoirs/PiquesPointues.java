package pouvoirs;

import gameplay.jeu.Joueur;
import typeCarte.Animal;

public class PiquesPointues extends Pouvoir {
    public PiquesPointues() {
        super("Piques pointues");
    }

    @Override
    public void onDefense(Animal carte, Joueur joueur, Joueur adversaire) {
        for (int i = 0; i < joueur.getPlateau().length; i++) {
            // Si la carte est présente et que la carte correspond a celui en argument
            if (joueur.getPlateau()[i].isPresent() && joueur.getPlateau()[i].get() == carte) {
                // S'il y a une carte en face, on inflige 1 d'attaque
                if (adversaire.getPlateau()[i].isPresent()) {
                    adversaire.getPlateau()[i].get().infligerDegats(1); // 1 dégât fixe
                }
                break;
            }
        }
    }
}