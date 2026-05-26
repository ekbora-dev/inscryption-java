package gameplay.jeu;

import carteAnimal.*;
import typeCarte.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Joueur {
    private final Stack<Animal> m_pioche = new Stack<>();
    private final ArrayList<Animal> m_mainJoueur = new ArrayList<>();
    private final Carte[] m_plateau = new Carte[4];
    private int m_scoreJoueur = 0;

    public Joueur(){
        for (int i = 0; i < 10; i++){
            m_pioche.push(new Ecureuil());
        }

        for (int i = 10; i < 15; i++){
            m_pioche.push(new Punaise());
        }
    }

    public int getScoreJoueur(){
        return m_scoreJoueur;
    }

    public Carte[] getPlateau(){
        return m_plateau;
    }
    public ArrayList<Animal> getMain(){
        return m_mainJoueur;
    }

    public void afficherCarte(){
        for (int i = 0; i < m_plateau.length; i++){
            if (m_plateau[i] == null){
                System.out.println("Case n°" + i + " - Pas de carte -");
                continue;
            }
            if (m_plateau[i].getVolant()){
                System.out.println("Case n°" + i + " - " + m_plateau[i].getNom() + " : PV : " + m_plateau[i].getPV() + " - Att : " + m_plateau[i].getAttaque() + " - Volante");
            } else {
                System.out.println("Case n°" + i + " - " + m_plateau[i].getNom() + " : PV : " + m_plateau[i].getPV() + " - Att : " + m_plateau[i].getAttaque());
            }
        }
    }

    public void afficherMain(){
        System.out.println("Votre main");
        for (int i = 0; i < m_mainJoueur.size(); i++){
            Animal carteActuelle = m_mainJoueur.get(i);
            System.out.println("\t" + i + ". " + carteActuelle.getNom() +" PV: " + carteActuelle.getPV() + " Att: " + carteActuelle.getAttaque() + " Gouttes de sang: " + carteActuelle.getGouttesSang() + " Os : " + carteActuelle.getOs() + " Volante : " + (carteActuelle.getVolant() ? "Oui" : "Non"));
        }
    }

    public boolean piocher(){
        if (m_pioche.isEmpty()){
            return false;
        }
        m_mainJoueur.add(m_pioche.pop());
        return true;
    }

    public boolean poserCarte(Carte carte, int cellule) {
        if (m_plateau[cellule] != null) {
            return false;
        }

        if (carte.getGouttesSang() > 0) {
            int i = 0;
            while (i < carte.getGouttesSang()) {
                int index;
                Scanner sn = new Scanner(System.in);
                System.out.print("Choisissez les cartes à sacrifier de gauche (0) à droite (3)");
                index = Integer.parseInt(sn.next());
                i += m_plateau[index].getGouttesSang();

                m_plateau[index] = null;
            }
        }

        m_plateau[cellule] = carte;
        return true;
    }

    public void attaquer(Joueur other){
        for (int i = 0; i < m_plateau.length; i++){
            if (m_plateau[i] != null){
                if (other.m_plateau[i] != null){
                    m_plateau[i].attaquer(other.m_plateau[i]);
                    if (other.m_plateau[i].getPV() <= 0){
                        other.m_plateau[i] = null;
                    }
                } else{
                    m_scoreJoueur += m_plateau[i].getAttaque();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "m_pioche=" + m_pioche +
                ", m_mainJoueur=" + m_mainJoueur +
                ", m_plateau=" + Arrays.toString(m_plateau) +
                ", m_scoreJoueur=" + m_scoreJoueur +
                '}';
    }
}
