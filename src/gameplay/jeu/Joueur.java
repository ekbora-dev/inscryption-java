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
    private int os = 0;

    public Joueur(){
        m_pioche.push(new Ecureuil());
        m_pioche.push(new Ecureuil());
        m_pioche.push(new Punaise());
        m_pioche.push(new Chat());
        m_pioche.push(new Grizzly());
        m_pioche.push(new Moineau());
        m_pioche.push(new Coyote());
        m_pioche.push(new Louveteau());
        m_pioche.push(new Loup());
        m_pioche.push(new Hermine());
        m_pioche.push(new Ecureuil());
        m_pioche.push(new Corbeau());
        m_pioche.push(new Ecureuil());
        m_pioche.push(new Ecureuil());
        m_pioche.push(new Ecureuil());
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

    public boolean poserCarteRobot(Carte carte, int cellule) {
        if (m_plateau[cellule] != null) {
            return false;
        }

        if (carte.getGouttesSang() > 0) {
            int nbCarteASacrifier = 0;
            while (nbCarteASacrifier < carte.getGouttesSang()) {
                Scanner sn = new Scanner(System.in);
                afficherMain();
                System.out.println("Attention, la carte " + carte.getNom() + " nécessite 1 ou plusieurs sacrifice ! Carte à sacrifier restante(s) : " + nbCarteASacrifier);
                System.out.print("Saisir l'indice de la carte à sacrifier : ");
                int index = Integer.parseInt(sn.next());
                if (m_plateau[index] == null){
                    System.out.println("Cette case est déja vide !");
                } else {
                    m_plateau[index] = null;
                    nbCarteASacrifier++;
                }
            }

            if (nbCarteASacrifier >= carte.getGouttesSang()){
                m_plateau[cellule] = carte;
                return true;
            }
            else {
                return false;
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
