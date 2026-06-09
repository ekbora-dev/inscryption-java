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
        Optional<Carte>[] plateauSuivant = new Optional[4];

        for (int i = 0; i < getPlateau().length; i++){
            plateauSuivant[i] = Optional.empty();
        }

        for (int i = 0; i < getPlateau().length; i++) {
            plateauSuivant[i] = getPlateau()[i];
        }

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

        for (Optional<Carte> c : plateauSuivant) {
            if (c.isPresent()) carteSacrifiable++;
        }

        for (int i = 0; i < getMain().size(); i++) {
            Animal c = getMain().get(i);
            if (c.getGouttesSang() == 0 && c.getOs() == 0) {
                carte = Optional.of(c);
                break;
            }
        }

        if (carte.isEmpty()) {
            for (int i = 0; i < getMain().size(); i++) {
                Animal c = getMain().get(i);
                if (c.getGouttesSang() > 0 && c.getGouttesSang() <= carteSacrifiable) {
                    carte = Optional.of(c);
                    break;
                }
            }
        }

        if (carte.isEmpty()) {
            for (int i = 0; i < getMain().size(); i++) {
                Animal c = getMain().get(i);
                if (c.getOs() > 0 && c.getOs() <= getOsJoueur()) {
                    carte = Optional.of(c);
                    break;
                }
            }
        }

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

        for (int i = 0; i < getPlateau().length; i++){
            if (getPlateau()[i].isPresent()) carteSacrifiable++;
        }

        // Carte totalement gratuite
        for (int i = 0; i < getMain().size(); i++){
            Animal c = getMain().get(i);
            if (c.getGouttesSang() == 0 && c.getOs() == 0){
                carte = Optional.of(c);
                break;
            }
        }

        if (carte.isEmpty()){
            for (int i = 0; i < getMain().size(); i++){
                Animal c = getMain().get(i);
                if (c.getGouttesSang() > 0 && c.getGouttesSang() <= carteSacrifiable){
                    carte = Optional.of(c);
                    break;
                }
            }
        }

        if (carte.isEmpty()){
            for (int i = 0; i < getMain().size(); i++){
                Animal c = getMain().get(i);
                if (c.getOs() > 0 && c.getOs() <= getOsJoueur()){
                    carte = Optional.of(c);
                    break;
                }
            }
        }

        if (position != -1) {
            if (carte.isPresent()){
                poserCarteRobot(carte.get(), position);
                System.out.println("Le robot joue son tour");
            } else {
                System.out.println("Le robot passe son tour");
            }
        }

        this.attaquer(m_other);
    }

    public void poserCarteRobot(Animal carte, int cellule) {
        if (getPlateau()[cellule].isPresent()) return;

        // Carte gratuite (pas de sang, pas d'os)
        if (carte.getGouttesSang() == 0 && carte.getOs() == 0) {
            placerCarte(carte, cellule);
            return;
        }

        // Carte payée en sang
        if (carte.getGouttesSang() > 0) {
            if (sacrificeRobot(carte)) {
                placerCarte(carte, cellule);
            }
            return;
        }

        // Carte payée en os
        if (carte.getOs() > 0) {
            if (getOsJoueur() >= carte.getOs()) {
                placerCarte(carte, cellule);
            } else if (osRobot(carte)) {
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
