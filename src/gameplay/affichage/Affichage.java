package gameplay.affichage;

import typeCarte.Animal;
import typeCarte.Carte;
import typeCarte.Obstacle;

public class Affichage {
    private Carte m_carte ;
    public Affichage(Carte carte){
        m_carte = carte;
    }

    


    public void showCarte(){
        System.out.print ("0-------------0" + "\n" +
                          "| " + m_carte.getNom()+ "        |\n" +
                          "|-------------|\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "0-------------0\n\n");

    }

    public void placeDeck() {
        String[] lignesCarte = {
                "#-------------#",
                "|             |",
                "|             |",
                "|             |",
                "|             |",
                "|             |",
                "|             |",
                "|             |",
                "|             |",
                "#-------------#"
        };

        int nbLigneGrille = 3;
        int nbColonneGrille = 4;
        String espaceEntreCartes = "   ";

        for (int grilleLigne = 0; grilleLigne < nbLigneGrille; grilleLigne++) {
            for (int i = 0; i < lignesCarte.length; i++) {
                for (int grilleCol = 0; grilleCol < nbColonneGrille; grilleCol++) {
                    System.out.print(lignesCarte[i] + espaceEntreCartes);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void pioche() {
         String[] pioch = {
                "[=============]" ,
                        "|             |",
                        "|    #####    |",
                        "|    #   #    |",
                        "|    #####    |",
                        "|    #        |",
                        "|    #        |",
                        "|             |",
                        "|             |",
                        "[=============]"};

    }
}



