package gameplay.jeu;

import carteAnimal.*;
import factory.CarteFactory;
import typeCarte.Animal;

import java.util.Stack;

public class Pioche {
    Joueur m_joueur;
    Stack<Animal> m_pioche = new Stack<>();
    public Pioche(Joueur player){
        m_joueur = player;
    }

    public void initPioche(){
        m_pioche.push(CarteFactory.createEcureuil());
        m_pioche.push(CarteFactory.createEcureuil());
        m_pioche.push(CarteFactory.createPunaise());
        m_pioche.push(CarteFactory.createChat());
        m_pioche.push(CarteFactory.createGrizzly());
        m_pioche.push(CarteFactory.createMoineau());
        m_pioche.push(CarteFactory.createCoyote());
        m_pioche.push(CarteFactory.createLouveteau());
        m_pioche.push(CarteFactory.createLoup());
        m_pioche.push(CarteFactory.createHermine());
        m_pioche.push(CarteFactory.createEcureuil());
        m_pioche.push(CarteFactory.createCorbeau());
        m_pioche.push(CarteFactory.createEcureuil());
        m_pioche.push(CarteFactory.createEcureuil());
        m_pioche.push(CarteFactory.createEcureuil());
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
