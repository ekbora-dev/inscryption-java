package gameplay.jeu;

import typeCarte.Animal;

public class Robot extends Joueur{
    private final Joueur m_other;
    public Robot(Joueur other){
        super();
        m_other = other;
    }

    public void jouerTour(){
        System.out.println(getMain().toString());
        if (getMain().isEmpty()){
            piocher();
        }

        int position = -1;

        for (int i = 0; i < getPlateau().length; i++){
            // Vérifier si une carte a un PV nul

            if (getPlateau()[i] == null){
                position = i;
                break;
            }

            if (getPlateau()[i].getPV() == 0){
                getPlateau()[i] = null;
            }
        }


        int carteSacrifiable = 0;
        Animal carte = null;

        for (int i = 0; i < getMain().size(); i++){
            if (getMain().get(i).getGouttesSang() == 0){
                carte = getMain().get(i);
                break;
            }
        }

        for (int i = 0; i < getMain().size(); i++){
            if (getMain().get(i).getGouttesSang() <= carteSacrifiable){
                carte = getMain().get(i);
                break;
            }
        }

        for (int i = 0; i < getPlateau().length; i++){
            if (getPlateau()[i] != null){
                carteSacrifiable++;
                if (carte != null){
                    if (carteSacrifiable == carte.getGouttesSang()){
                        break;
                    }
                }

            }
        }

        if (position == -1) {
            return;
        }

        if (carte != null){
            poserCarteRobot(carte, position);
            System.out.println("Le robot joue son tour");
        } else {
            System.out.println("Le robot passe son tour");
        }
        this.attaquer(m_other);

    }

    public boolean poserCarteRobot(Animal carte, int cellule) {
        if (getPlateau()[cellule] != null) {
            return false;
        }

        if (carte.getGouttesSang() > 0) {
            int nbCarteASacrifier = 0;
            for (int i = 0; i < getPlateau().length; i++){
                if (getPlateau()[i] != null){
                    nbCarteASacrifier++;
                    if (nbCarteASacrifier == carte.getGouttesSang()){
                        break;
                    }
                }
            }

            if (nbCarteASacrifier == carte.getGouttesSang()){
                for (int i = 0; i < nbCarteASacrifier; i++){
                    if (getPlateau()[i] != null){
                        getPlateau()[i] = null;
                    }
                }

                getPlateau()[cellule] = carte;
                getMain().remove(carte);

                return true;
            }
            return false;
        }

        getPlateau()[cellule] = carte;
        getMain().remove(carte);

        return true;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "m_other=" + m_other +
                '}';
    }
}
