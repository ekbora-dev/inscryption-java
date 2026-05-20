package gameplay.jeu;

import typeCarte.Carte;

import java.util.Scanner;

public class Partie {
    private int m_differenceScore = 0;
    public Partie(){

    }

    public void demarrerPartieSansObstacle(){
        Joueur robot = new Joueur();
        Joueur player = new Joueur();

        Carte[] carteAuCentre = new Carte[4];

        for (int i = 0; i < 4; i++){
            robot.piocher();
            player.piocher();
        }

        boolean partie = true;

        while (partie){
            if (m_differenceScore == 5){
                partie = false;
            }

            robot.poserCarte(robot.getMain().get(2), 1);
            robot.poserCarte(robot.getMain().get(0), 0);

            robot.afficherCarte();
            System.out.println("================================");
            for (int i = 0; i < carteAuCentre.length; i++){
                System.out.println("Carte au centre xd");
            }
            System.out.println("================================");
            player.afficherCarte();
            System.out.println("Actions possible");
            System.out.println("[fin] Fin de votre tour");
            System.out.println("[piocher] Piocher 1 carte");
            System.out.println("[placer <numeroCarte> <cellule>] Placer une carte sur une cellule");
            Scanner scanner = new Scanner(System.in);
            System.out.print("vous@partie:~$ ");
            String choix = scanner.next();

            if (choix.equals("fin")){
                System.out.println("Fin du tour");
                break;
            } else if (choix.equals("piocher")){
                player.piocher();
                System.out.println("Actions possible");
                System.out.println("[fin] Fin de votre tour");
                System.out.println("[placer <numeroCarte> <cellule>] Placer une carte sur une cellule");
                scanner = new Scanner(System.in);
                System.out.print("vous@partie:~$ ");
                choix = scanner.next();
            }

        }
    }
    public void demarrerPartieAvecObstacle() {
    }
}
