package gameplay.affichage;

import typeCarte.Animal;
import typeCarte.Carte;

import java.util.ArrayList;
import java.util.Optional;

public class Affichage {
    public Affichage(){}

    public static void afficherPlateau(Optional<Carte>[] cartes){
        for (int i = 0; i < cartes.length; i++){
            if (cartes[i].isPresent()){
                Carte carte = cartes[i].get();
                if (carte.getVolant()){
                    System.out.println("Case n°" + i + " - " + carte.getNom() + " : PV : " + carte.getPV() + " - Att : " + carte.getAttaque() + " - Volante");
                } else {
                    System.out.println("Case n°" + i + " - " + carte.getNom() + " : PV : " + carte.getPV() + " - Att : " + carte.getAttaque());
                }
            } else {
                System.out.println("Case n°" + i + " - Pas de carte -");
            }

        }
    }

    public static void afficherMain(ArrayList<Animal> cartes){
        System.out.println("Votre main");
        for (int i = 0; i < cartes.size(); i++){
            Animal carteActuelle = cartes.get(i);
            System.out.println("\t" + i + ". " + carteActuelle.getNom() +" PV: " + carteActuelle.getPV() + " Att: " + carteActuelle.getAttaque() + " Gouttes de sang: " + carteActuelle.getGouttesSang() + " Os : " + carteActuelle.getOs() + " Volante : " + (carteActuelle.getVolant() ? "Oui" : "Non") + (carteActuelle.getPouvoir().isPresent() ? " - Pouvoir : " + carteActuelle.getPouvoir().get().getNom() : ""));
        }
    }
}