package gameplay.jeu;

public class Jeu {

    public void demarrerJeuSansObstacle(){
        String vainqueur;
        int compteurRobot = 0;
        int compteurJoueur = 0;
        for (int i = 0; i < 3; i++){
            Partie partie = new Partie();
            vainqueur = partie.demarrerPartieSansObstacle();

            if (vainqueur.equals("Robot")){
                compteurRobot++;
            } else {
                compteurJoueur++;
            }
        }

        if (compteurJoueur > compteurRobot){
            System.out.println("Vous avez gagnez !");
        } else {
            System.out.println("Vous avez perdu ! Le robot s'en est bien sorti");
        }
    }
}
