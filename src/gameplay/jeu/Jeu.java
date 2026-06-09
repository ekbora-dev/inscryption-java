package gameplay.jeu;

public class Jeu {

    public void demarrerJeu() throws Exception {
        String vainqueur;
        int compteurRobot = 0;
        int compteurJoueur = 0;
        for (int i = 0; i < 3; i++){
            int numPartie = i+1;
            System.out.println("=====DEBUT DE LA PARTIE n°" + numPartie + "=====");
            Partie partie = new Partie(numPartie);
            vainqueur = partie.demarrerPartie();

            if (vainqueur.equals("Robot")){
                compteurRobot++;
            } else if (vainqueur.equals("Vous")) {
                compteurJoueur++;
            } else {
                System.out.println("Égalité !");
            }
        }

        if (compteurJoueur > compteurRobot){
            System.out.println("Vous avez gagnez le jeu !");
        } else if (compteurRobot > compteurJoueur) {
            System.out.println("Vous avez perdu le jeu ! Le robot s'en est bien sorti");
        } else {
            System.out.println("Egalité !");
        }
    }
}
