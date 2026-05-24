package gameplay.jeu;

import typeCarte.Animal;
import typeCarte.Carte;

import java.util.ArrayList;

public class Robot extends Joueur{
    public Robot(){
        super();
    }

    public void jouerTour(){
        if (getMain().isEmpty()){
            piocher();
        }


        int position = -1;

        for (int i = 0; i < getPlateau().length; i++){
            if (getPlateau()[i] == null){
                position = i;
                break;
            }
        }

        if (position == -1){
            return;
        }

        Animal carte = getMain().get(0); // Carte à poser

        int cout = carte.getGouttesSang();
        int total = 0;
        ArrayList<Carte> carteASacrifier = new ArrayList<>();

        if (carte.getGouttesSang() == 0){
            poserCarte(carte, position);
        } else {
            for (int i = 0; i < getPlateau().length; i++){
                if (getPlateau()[i] != null && cout > total){
                    total += getPlateau()[i].getGouttesSang();
                    carteASacrifier.add(getPlateau()[i]);
                }
            }

            if (total >= cout){
                for (int i = 0; i < getPlateau().length; i++){
                    if (getPlateau()[i] == carteASacrifier.get(i) && getPlateau()[i] != null){
                        getPlateau()[i] = null;
                        position = i;
                    }
                }
                poserCarte(carte, position);
            }
        }


    }

    @Override
    public String toString() {
        return "Robot{}";
    }
}
