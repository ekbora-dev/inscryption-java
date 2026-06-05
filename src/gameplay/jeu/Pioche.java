package gameplay.jeu;

import carteAnimal.*;
import typeCarte.Animal;

import java.util.Stack;

public class Pioche {
    Joueur m_joueur;
    Stack<Animal> m_pioche = new Stack<>();
    public Pioche(Joueur player){
        m_joueur = player;
    }

    public void initPioche(){
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

    public int getTaillePioche(){
        return m_pioche.size();
    }

    public void piocher(){
        if (m_pioche.isEmpty()){
            System.out.println("Pioche vide !");
            return;
        }
        m_joueur.getMain().add(m_pioche.pop());
    }
}
