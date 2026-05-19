package gameplay.jeu;

import typeCarte.*;

import java.util.ArrayList;
import java.util.Stack;

public class Joueur {
    private Stack<Carte> m_pioche = new Stack<>();
    private ArrayList<Carte> m_mainJoueur = new ArrayList<>();
    private ArrayList<Carte> m_plateau = new ArrayList<>();
    private int m_scoreJoueur;

    public Joueur(){

    }

    public int getScoreJoueur(){
        return m_scoreJoueur;
    }

    public ArrayList<Carte> 

    public boolean piocher(){
        if (m_pioche.isEmpty()){
            return false;
        }
        m_mainJoueur.add(m_pioche.pop());
        return true;
    }
}
