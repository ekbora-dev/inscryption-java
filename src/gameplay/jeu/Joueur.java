package gameplay.jeu;

import typeCarte.*;

import java.util.*;

public class Joueur {
    private final Pioche m_pioche = new Pioche(this);
    private final ArrayList<Animal> m_mainJoueur = new ArrayList<>();
    private final Optional<Carte>[] m_plateau = new Optional[4];
    private int m_scoreJoueur = 0;
    protected int m_os = 0;

    public Joueur(){
        for (int i = 0; i < m_plateau.length; i++) {
            m_plateau[i] = Optional.empty();
        }

        m_pioche.initPioche();
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

    public int getOsJoueur(){
        return m_os;
    }

    public void piocher(){
        m_pioche.piocher();
    }

    public int getSizePioche(){
        return m_pioche.getPioche().size();
    }

    public Stack<Animal> getPioche(){
        return m_pioche.getPioche();
    }

    public void poserCarte(Animal carte, int cellule) throws IndexOutOfBoundsException {
        if (carte.getOs() > 0){
            boolean cartePosable = poserCarteOs(carte);

            if (cartePosable) {
                placerCarte(carte, cellule);
                m_os -= carte.getOs();
            } else {
                return;
            }
        }

        if (carte.getGouttesSang() > 0) {
            boolean cartePosable = poserCarteSang(carte);

            if (cartePosable){
                placerCarte(carte, cellule);
                return; // On sort de la fonction pour éviter de placer une carte en double
            } else {
                return;
            }
        }

        placerCarte(carte, cellule);
    }

    public void attaquer(Joueur other){
        for (int i = 0; i < m_plateau.length; i++){
            if (m_plateau[i].isEmpty()) {
                continue;
            }

            Carte attaquant = m_plateau[i].get();

            if (attaquant.getVolant() || other.m_plateau[i].isEmpty()) {
                m_scoreJoueur += attaquant.getAttaque();
                continue;
            }

            Carte defenseur = other.m_plateau[i].get();
            attaquant.attaquer(defenseur);

            if (defenseur.getPV() <= 0) {
                other.m_plateau[i] = Optional.empty();
                other.m_os++;
            }
        }
    }

    public void placerCarte(Animal carte, int cellule) throws IndexOutOfBoundsException{
        try {
            if (m_plateau[cellule].isPresent()) {
                System.out.println("Case occupé !");
                return;
            }
            m_plateau[cellule] = Optional.of(carte);
            m_mainJoueur.remove(carte);
        }
        catch (IndexOutOfBoundsException err){
            throw new IndexOutOfBoundsException("Vous sortez du plateau, le plateau va de 0 à 3");
        }
    }

    private boolean poserCarteOs(Animal carte) throws IndexOutOfBoundsException {
        if (m_os >= carte.getOs()){
            return true;
        } else {
            int nbCarteASacrifier = 0;
            int sacrificeRestant;

            int carteSacrifiableTotal = 0;

            for (Optional<Carte> casePlateau : m_plateau) {
                if (casePlateau.isPresent() && casePlateau.get().isSacrifiable()) {
                    carteSacrifiableTotal++;
                }
            }

            if (carteSacrifiableTotal < carte.getOs() - m_os){
                System.out.println("Impossible de poser cette carte, vous n'avez pas assez de carte à sacrifier");
                return false;
            }
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

    // Fonction qui permet de demander à l'utilisateur la carte à sacrifier (retourne le nombre de carte(s) à sacrifier restante(s))
    private int sacrificeCarte(Animal carte, int nbCarteASacrifier, int sacrificeRestant) throws IndexOutOfBoundsException {
        Scanner sn = new Scanner(System.in);
        System.out.println("Attention, la carte " + carte.getNom() + " nécessite 1 ou plusieurs sacrifices ! Carte à sacrifier restante(s) : " + sacrificeRestant);
        System.out.print("Saisir l'indice de la carte à sacrifier : ");
        int index = Integer.parseInt(sn.next());
        try {
            if (m_plateau[index].isEmpty()) {
                System.out.println("Cette case est vide !");
            } else if (!m_plateau[index].get().isSacrifiable()) {
                System.out.println("Vous ne pouvez pas sacrifier un obstacle !");
            } else {
                m_plateau[index] = Optional.empty();
                m_os++;
                nbCarteASacrifier++;
            }
        }
        catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Vous sortez du plateau ! Le plateau va de 0 à 3 !");
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Veuillez saisir en respectant le format de saisie indiqué !");
        }

        return nbCarteASacrifier;
    }

    private boolean poserCarteSang(Animal carte) throws IndexOutOfBoundsException {
        int carteSacrifiableTotal = 0;
        for (Optional<Carte> casePlateau : m_plateau) {
            if (casePlateau.isPresent() && casePlateau.get().isSacrifiable()) {
                carteSacrifiableTotal++;
            }
        }

        if (carteSacrifiableTotal < carte.getGouttesSang()){
            System.out.println("Impossible de poser cette carte, vous n'avez pas assez de carte à sacrifier");
            return false;
        }

        int nbCarteASacrifier = 0;
        int sacrificeRestant;
        while (nbCarteASacrifier < carte.getGouttesSang()) {
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
