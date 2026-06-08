package gameplay.jeu;

import typeCarte.*;

import java.util.Optional;

public class Robot extends Joueur{
    private final Joueur m_other;
    public Robot(Joueur other){
        super();
        m_other = other;
    }

    public Optional<Carte>[] tourProchain() {
        // Copie du plateau actuel
        Optional<Carte>[] plateauSuivant = new Optional[4];

        for (int i = 0; i < getPlateau().length; i++){
            plateauSuivant[i] = Optional.empty();
        }

        // Copie du plateau
        for (int i = 0; i < getPlateau().length; i++) {
            plateauSuivant[i] = getPlateau()[i];
        }

        // Même logique que jouerTour() mais sur plateauSuivant
        int position = -1;
        for (int i = 0; i < plateauSuivant.length; i++) {
            if (plateauSuivant[i].isEmpty()) {
                position = i;
                break;
            }
        }

        if (position == -1) return plateauSuivant;

        int carteSacrifiable = 0;
        Optional<Animal> carte = Optional.empty();

        // On compte le nombre de cartes sacrifiable
        for (Optional<Carte> c : plateauSuivant) {
            if (c.isPresent()) carteSacrifiable++;
        }

        // On prend la carte le moins cher possible
        for (int i = 0; i < getMain().size(); i++) {
            if (getMain().get(i).getGouttesSang() == 0) {
                carte = Optional.of(getMain().get(i));
                break;
            }
        }

        for (int i = 0; i < getMain().size(); i++) {
            if (getMain().get(i).getGouttesSang() <= carteSacrifiable) {
                carte = Optional.of(getMain().get(i));
                break;
            }
        }

        // On simule le placement sur plateauSuivant
        if (carte.isPresent()) {
            plateauSuivant[position] = Optional.of(carte.get());
        }

        return plateauSuivant;
    }

    public void jouerTour(){
        if (getMain().isEmpty()){
            piocher();
        }

        int position = -1;
        for (int i = 0; i < getPlateau().length; i++){
            if (getPlateau()[i].isEmpty()){
                position = i;
                break;
            }
        }

        int carteSacrifiable = 0;
        Optional<Animal> carte = Optional.empty();

        // Nombre de cartes sacrifiable
        for (int i = 0; i < getPlateau().length; i++){
            if (getPlateau()[i].isPresent()) carteSacrifiable++;
        }

        // On prend la carte le moins cher possible
        for (int i = 0; i < getMain().size(); i++){
            if (getMain().get(i).getGouttesSang() == 0){
                carte = Optional.of(getMain().get(i));
                break;
            }
        }

        for (int i = 0; i < getMain().size(); i++){
            if (getMain().get(i).getGouttesSang() <= carteSacrifiable){
                carte = Optional.of(getMain().get(i));
                break;
            }
        }

        if (position == -1) return;

        // Si on a une carte alors, on la place
        if (carte.isPresent()){
            poserCarteRobot(carte.get(), position);
            System.out.println("Le robot joue son tour");
        }

        // On attaque le joueur adverse
        this.attaquer(m_other);
    }

    public void poserCarteRobot(Animal carte, int cellule) {
        if (getPlateau()[cellule].isPresent()) {
            return;
        }

        // Si la carte qu'on pose est gratuite alors, on la pose
        if (carte.getGouttesSang() == 0 && carte.getOs() == 0) {
            placerCarte(carte, cellule);
        }


        if (carte.getGouttesSang() > 0) {
            boolean sacrifice = sacrificeRobot(carte);

            // Si la fonction renvoie true (sacrifice possible et fait), alors on pose la carte
            if (sacrifice) {
                placerCarte(carte, cellule);

            }
        } else if (getOsJoueur() >= carte.getOs()) {
            placerCarte(carte, cellule);
        } else {
            boolean os = osRobot(carte);

            // Si la fonction renvoie true (nombre d'os suffisant pour poser la carte), alors on pose la carte
            if (os) {
                placerCarte(carte, cellule);
            }
        }
    }

    private boolean sacrificeRobot(Animal carte){
        int nbCarteASacrifier = 0;
        for (int i = 0; i < getPlateau().length; i++){
            if (getPlateau()[i].isPresent()){
                nbCarteASacrifier++;
                if (nbCarteASacrifier == carte.getGouttesSang()){
                    break;
                }
            }
        }

        if (nbCarteASacrifier == carte.getGouttesSang()){
            for (int i = 0; i < nbCarteASacrifier; i++){
                if (getPlateau()[i].isPresent()){
                    getPlateau()[i] = Optional.empty();
                    m_os++;
                }
            }

            return true;
        }
        return false;
    }

    // Fonction permettant de faire des sacrifices pour récupérer des os
    private boolean osRobot(Animal carte){
        for (int i = 0; i < getPlateau().length; i++){
            if (getPlateau()[i].isPresent()){
                getPlateau()[i] = Optional.empty();
                m_os++;
            }

            if (m_os == carte.getOs()) {
                m_os -= carte.getOs();
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "m_other=" + m_other +
                '}';
    }
}
