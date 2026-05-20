package gameplay.jeu;

import carteAnimal.Ecureuil;
import typeCarte.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Joueur {
    private Stack<Carte> m_pioche = new Stack<>();
    private ArrayList<Carte> m_mainJoueur = new ArrayList<>();
    private final Carte[] m_plateau = new Carte[4];
    private int m_scoreJoueur = 0;

    public Joueur(){
        for (int i = 0; i < 15; i++){
            m_pioche.add(new Ecureuil());
        }
    }

    public int getScoreJoueur(){
        return m_scoreJoueur;
    }

    public Carte[] getPlateau(){
        return m_plateau;
    }
    public ArrayList<Carte> getMain(){
        return m_mainJoueur;
    }

    public void afficherCarte(){
        for (int i = 0; i < m_plateau.length; i++){
            if (m_plateau[i] == null){
                System.out.println("- Pas de carte -");
                continue;
            }
            System.out.println(m_plateau[i].getNom());
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
        int carteSacrifiable = m_plateau.length;
        if (m_plateau[cellule] != null) {
            return false;
        }

        if (carte.getGouttesSang() > 0) {
            int i = 0;
            while (i < carte.getGouttesSang()) {
                int index;
                Scanner sn = new Scanner(System.in);
                System.out.print("Choisissez les cartes à sacrifier");
                index = Integer.parseInt(sn.next());
                i += m_plateau[index].getGouttesSang();

                m_plateau[index] = null;

            }
        }

        m_plateau[cellule] = carte;
        return true;
    }
}
