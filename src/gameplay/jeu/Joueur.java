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
            System.out.println("Case occupé !");
            return;
        }

        if (carte.getOs() > 0){
            boolean cartePosable = poserCarteOs(carte);

            if (cartePosable) {
                m_plateau[cellule] = Optional.of(carte);
                m_mainJoueur.remove(carte);
                m_os -= carte.getOs();
            } else {
                return;
            }
        }

        if (carte.getGouttesSang() > 0) {
            boolean cartePosable = poserCarteSang(carte);

            if (cartePosable){
                m_plateau[cellule] = Optional.of(carte);
                m_mainJoueur.remove(carte);
                return; // On sort de la fonction pour éviter de placer une carte en double
            } else {
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

    private boolean poserCarteOs(Carte carte){
        if (m_os >= carte.getOs()){
            return true;
        } else {
            int nbCarteASacrifier = 0;
            int sacrificeRestant;
            while (nbCarteASacrifier < carte.getOs()) {
                sacrificeRestant = carte.getOs() - m_os - nbCarteASacrifier; // On soustrait les os du joueur pour compléter les os manquants
                nbCarteASacrifier = sacrificeCarte(carte, nbCarteASacrifier, sacrificeRestant);
            }

            if (m_os < carte.getOs()){
                System.out.println("Pas assez de sacrifice pour poser la carte");
                return false;
            } else {
                return true;
            }
        }
    }

    private int sacrificeCarte(Carte carte, int nbCarteASacrifier, int sacrificeRestant) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Attention, la carte " + carte.getNom() + " nécessite 1 ou plusieurs sacrifices ! Carte à sacrifier restante(s) : " + sacrificeRestant);
        System.out.print("Saisir l'indice de la carte à sacrifier : ");
        int index = Integer.parseInt(sn.next());
        if (m_plateau[index].isEmpty()){
            System.out.println("Cette case est vide !");
        } else {
            m_plateau[index] = Optional.empty();
            m_os++;
            nbCarteASacrifier++;
        }
        return nbCarteASacrifier;
    }

    private boolean poserCarteSang(Carte carte){
        int carteSacrifiableTotal = 0;
        for (int i = 0; i < m_plateau.length; i++){
            if (m_plateau[i].isPresent()){
                carteSacrifiableTotal += m_plateau[i].get().getGouttesSang();
            }
        }

        if (carteSacrifiableTotal < carte.getGouttesSang()){
            System.out.println("Impossible de poser cette carte, vous n'avez pas assez de carte à sacrifier");
            return false;
        }

        int nbCarteASacrifier = 0;
        int sacrificeRestant;
        while (nbCarteASacrifier < m_plateau.length) {
            sacrificeRestant = carte.getGouttesSang() - nbCarteASacrifier;
            nbCarteASacrifier = sacrificeCarte(carte, nbCarteASacrifier, sacrificeRestant);
        }

        return true;
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
