package gameplay.jeu;

import typeCarte.Carte;

import java.util.Scanner;

public class Partie {
    private int m_differenceScore = 0;
    public Partie(){

    }

    public void demarrerPartieSansObstacle(){
        Robot robot = new Robot();
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

            robot.jouerTour();
            robot.attaquer(player);

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
            Scanner scanner = new Scanner(System.in);
            System.out.print("vous@partie:~$ ");
            String choix = scanner.next();

            if (choix.equals("fin")){
                System.out.println("Fin du tour");
                break;
            } else if (choix.equals("piocher")){
                player.piocher();
            } else if (choix.equals("placer")){
                System.out.println("format attendu : <numeroCarte> <cellule>");
                Scanner sn = new Scanner(System.in);
                System.out.print("vous@partie:~$ ");
                String valeur = sn.nextLine();

                String[] parties = valeur.split(" ");

                int cellule = Integer.parseInt(parties[0]);
                int carte = Integer.parseInt(parties[1]);

                player.poserCarte(player.getMain().get(cellule), carte);
                player.getMain().remove(carte);
                player.attaquer(robot);
            }

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
