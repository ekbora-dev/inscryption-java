package gameplay.jeu;

import factory.CarteFactory;
import gameplay.affichage.Affichage;
import obstacles.Rocher;
import typeCarte.Carte;

import java.util.Optional;
import java.util.Scanner;

public class Partie {
    private int m_differenceScore = 0;
    public Partie(){

    }

    public String demarrerPartie() throws Exception {
        Joueur player = new Joueur();
        Robot robot = new Robot(player);


        Carte[] carteAuCentre = new Carte[4];

        for (int i = 0; i < 4; i++){
            robot.piocher();
            player.piocher();
        }

        player.getPlateau()[2] = Optional.of(CarteFactory.createRocher());
        robot.getPlateau()[1] = Optional.of(CarteFactory.createSapin());

        // Ce while correspond à 1 tour complet (Robot + Joueur).
        while (true){
            System.out.println("Différence de score (balance) : " + m_differenceScore);

            // On récupère la valeur absolue du score pour déterminer si la partie est terminé ou pas
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

            Affichage.afficherPlateau(robot.getPlateau());
            System.out.println("================================");
            for (int i = 0; i < carteAuCentre.length; i++){
                System.out.println("Carte du centre");
            }
            System.out.println("================================");
            Affichage.afficherPlateau(player.getPlateau());
            Affichage.afficherMain(player.getMain());
            System.out.println("Carte dans la pioche : " + player.getSizePioche());

            System.out.println("Actions possible");
            System.out.println("[fin] Fin de votre tour");
            System.out.println("[piocher] Piocher 1 carte");
            System.out.println("[placer] Placer une carte sur une cellule");
            boolean tour = true;
            boolean piocher = false;

            // Tour du joueur
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
                            Affichage.afficherMain(player.getMain());
                        }
                        break;
                    case "placer":
                        try{
                            System.out.println("Format attendu : <cellule> <numéroCarte>");
                            Scanner sn = new Scanner(System.in);
                            System.out.print("vous@partie:~$ ");
                            String valeur = sn.nextLine();

                            String[] parties = valeur.split(" ");

                            int cellule = Integer.parseInt(parties[0]);
                            int carte = Integer.parseInt(parties[1]);
                            player.poserCarte(player.getMain().get(carte), cellule);
                            break;
                        }
                        catch (IndexOutOfBoundsException e){
                            System.out.println("Vous sortez du plateau ! Annulation de l'action");
                        }
                }
            }
            player.attaquer(robot);
            m_differenceScore = player.getScoreJoueur() - robot.getScoreJoueur();
        }
    }

    @Override
    public String toString() {
        return "Partie{" +
                "m_differenceScore=" + m_differenceScore +
                '}';
    }
}
