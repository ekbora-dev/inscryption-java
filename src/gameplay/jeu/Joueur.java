package gameplay.jeu;

import typeCarte.*;

import java.util.ArrayList;
import java.util.Stack;

public class Joueur {
    private Stack<Carte> m_pioche = new Stack<>();
    private ArrayList<Carte> m_mainJoueur = new ArrayList<>();
    private ArrayList<Carte> m_plateau = new ArrayList<>();
    private int m_scoreJoueur = 0;

    public Joueur(){

    }

    public int getScoreJoueur(){
        return m_scoreJoueur;
    }

    public ArrayList<Carte> getPlateau(){
        return m_plateau;
    }
    public ArrayList<Carte> getMain(){
        return m_mainJoueur;
    }

    public boolean piocher(){
        if (m_pioche.isEmpty()){
            return false;
        }
        m_mainJoueur.add(m_pioche.pop());
        return true;
    }

    public boolean poserCarte(Carte carte, int cellule){
        int carteSacrifiable = m_plateau.size();
        if (carteSacrifiable < carte.getGouttesSang()) {
            return false;
        }

        if (m_plateau.get(cellule) != null){
            m_plateau.add(cellule, carte);
        } else {
            return false;
        }
        return true;
    }
}
