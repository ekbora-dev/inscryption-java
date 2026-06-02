package gameplay.jeu;

import carteAnimal.*;
import typeCarte.*;

import java.util.*;

public class Joueur {
    private final Stack<Animal> m_pioche = new Stack<>();
    private final ArrayList<Animal> m_mainJoueur = new ArrayList<>();
    private final Optional<Carte>[] m_plateau = new Optional[4];
    private int m_scoreJoueur = 0;
    protected int m_os = 0;

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

        for (int i = 0; i < m_plateau.length; i++) {
            m_plateau[i] = Optional.empty();
        }
    }

    public int getScoreJoueur(){
        return m_scoreJoueur;
    }

    public Optional<Carte>[] getPlateau(){
        return m_plateau;
    }
    public ArrayList<Animal> getMain(){
        return m_mainJoueur;
    }

    public void afficherCarte(){
        for (int i = 0; i < m_plateau.length; i++){
            if (m_plateau[i].isPresent()){
                Carte carte = m_plateau[i].get();
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

    public void afficherMain(){
        System.out.println("Votre main");
        for (int i = 0; i < m_mainJoueur.size(); i++){
            Animal carteActuelle = m_mainJoueur.get(i);
            System.out.println("\t" + i + ". " + carteActuelle.getNom() +" PV: " + carteActuelle.getPV() + " Att: " + carteActuelle.getAttaque() + " Gouttes de sang: " + carteActuelle.getGouttesSang() + " Os : " + carteActuelle.getOs() + " Volante : " + (carteActuelle.getVolant() ? "Oui" : "Non"));
        }
    }

    public int getOsJoueur(){
        return m_os;
    }

    public int getTaillePioche(){
        return m_pioche.size();
    }

    public void piocher(){
        if (m_pioche.isEmpty()){
            return;
        }
        m_mainJoueur.add(m_pioche.pop());
    }

    public void poserCarte(Animal carte, int cellule) {
        if (m_plateau[cellule].isPresent()) {
            return;
        }


        if (carte.getOs() > 0){
            if (m_os >= carte.getOs()){
                m_plateau[cellule] = Optional.of(carte);
                m_mainJoueur.remove(carte);
            } else {
                int nbCarteASacrifier = 0;
                int sacrificeRestant;
                while (nbCarteASacrifier < carte.getOs()) {
                    sacrificeRestant = carte.getOs() - m_os - nbCarteASacrifier;
                    Scanner sn = new Scanner(System.in);
                    System.out.println("Attention, la carte " + carte.getNom() + " nécessite 1 ou plusieurs sacrifices ! Carte à sacrifier restante(s) : " + sacrificeRestant);
                    System.out.print("Saisir l'indice de la carte à sacrifier : ");
                    int index = Integer.parseInt(sn.next());
                    if (m_plateau[index].isEmpty()){
                        System.out.println("Cette case est déja vide !");
                    } else {
                        m_plateau[index] = Optional.empty();
                        m_os++;
                        nbCarteASacrifier++;
                    }
                }
            }
        }

        if (carte.getGouttesSang() > 0) {
            int nbCarteASacrifier = 0;
            int sacrificeRestant;
            while (nbCarteASacrifier < carte.getGouttesSang()) {
                sacrificeRestant = carte.getGouttesSang() - nbCarteASacrifier;
                Scanner sn = new Scanner(System.in);
                System.out.println("Attention, la carte " + carte.getNom() + " nécessite 1 ou plusieurs sacrifices ! Carte à sacrifier restante(s) : " + sacrificeRestant);
                System.out.print("Saisir l'indice de la carte à sacrifier : ");
                int index = Integer.parseInt(sn.next());
                if (m_plateau[index].isEmpty()){
                    System.out.println("Cette case est déja vide !");
                } else {
                    m_plateau[index] = Optional.empty();
                    m_os++;
                    nbCarteASacrifier++;
                }
            }

            if (nbCarteASacrifier >= carte.getGouttesSang()){
                m_plateau[cellule] = Optional.of(carte);
                m_mainJoueur.remove(carte);
                return;
            }
        }

        m_plateau[cellule] = Optional.of(carte);
        m_mainJoueur.remove(carte);
    }

    public void attaquer(Joueur other){
        for (int i = 0; i < m_plateau.length; i++){
            if (m_plateau[i].isPresent()){
                Carte carte = m_plateau[i].get();
                if (other.m_plateau[i].isPresent()) {
                    if (carte.getVolant()) {
                        m_scoreJoueur += carte.getAttaque();
                    } else {
                        carte.attaquer(other.m_plateau[i].get());
                        if (other.m_plateau[i].get().getPV() <= 0) {
                            other.m_plateau[i] = Optional.empty();
                            other.m_os++;
                        }
                    }
                } else{
                    m_scoreJoueur += m_plateau[i].get().getAttaque();
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
