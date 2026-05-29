package gameplay.jeu;

import typeCarte.Carte;

import java.util.Scanner;

public class Partie {
    private int m_differenceScore = 0;
    public Partie(){

    }

    public String demarrerPartieSansObstacle(){
        Joueur player = new Joueur();
        Robot robot = new Robot(player);


        Carte[] carteAuCentre = new Carte[4];

        for (int i = 0; i < 4; i++){
            robot.piocher();
            player.piocher();
        }


        while (true){
            if (Math.abs(m_differenceScore) >= 5){
                if (player.getScoreJoueur() > robot.getScoreJoueur()){
                    System.out.println("Vous gagnez la partie");
                    return "Vous";
                } else {
                    System.out.println("Le robot a gagné, vous ferez mieux la prochaine fois...");
                    return "Robot";
                }
            }

            robot.jouerTour();

            robot.afficherCarte();
            System.out.println("================================");
            for (int i = 0; i < carteAuCentre.length; i++){
                System.out.println("Carte du centre");
            }
            System.out.println("================================");
            player.afficherCarte();
            player.afficherMain();

            System.out.println("Actions possible");
            System.out.println("[fin] Fin de votre tour");
            System.out.println("[piocher] Piocher 1 carte");
            System.out.println("[placer] Placer une carte sur une cellule");
            boolean tour = true;
            boolean piocher = false;
            while (tour){
                Scanner scanner = new Scanner(System.in);
                System.out.print("vous@partie:~$ ");
                String choix = scanner.next();


                switch (choix) {
                    case "fin":
                        System.out.println("Fin du tour");
                        tour = false;
                        break;
                    case "piocher":
                        if (piocher) {
                            System.out.println("Vous avez déjà pioché !");
                        } else {
                            player.piocher();
                            piocher = true;
                        }
                        break;
                    case "placer":
                        System.out.println("Format attendu : <cellule> <numéroCarte>");
                        Scanner sn = new Scanner(System.in);
                        System.out.print("vous@partie:~$ ");
                        String valeur = sn.nextLine();

                        String[] parties = valeur.split(" ");

                        int cellule = Integer.parseInt(parties[0]);
                        int carte = Integer.parseInt(parties[1]);

                        player.poserCarteRobot(player.getMain().get(carte), cellule);
                        player.getMain().remove(carte);
                        break;
                }
            }
            player.attaquer(robot);
            m_differenceScore = player.getScoreJoueur() - robot.getScoreJoueur();
        }
    }

    public void demarrerPartieAvecObstacle() {
    }

    @Override
    public String toString() {
        return "Partie{" +
                "m_differenceScore=" + m_differenceScore +
                '}';
    }
}
