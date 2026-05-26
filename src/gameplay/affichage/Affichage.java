package gameplay.affichage;

import typeCarte.Carte;



public class Affichage {
    private Carte m_carte ;
    public Affichage(Carte carte){
        m_carte = carte;
    }




    public void showCarte(){
        System.out.print ("0-------------0" + "\n" +
                          "| " + m_carte.getNom()+ "    |\n" +
                          "|-------------|\n" +
                          "|PV =  "+ m_carte.getPV()+ "      |\n" +
                          "|GTE = " + m_carte.getGouttesSang() + "      |\n" +
                          "|ATQ = " + m_carte.getAttaque() + "      |\n" +
                          "|OS =  " + m_carte.getOs() +"      |\n" +
                          "|VOL = " + m_carte.getVolant() + "  |\n" +
                          "|             |\n" +
                          "0-------------0\n\n");

    }

    public void placeDeck() {
        System.out.print(
                "#-------------#" + "\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "#-------------#\n\n");

    }


    public void pioche(){
        System.out.print(
                "[=============]" + "\n" +
                        "|             |\n" +
                        "|    #####    |\n" +
                        "|    #   #    |\n" +
                        "|    #####    |\n" +
                        "|    #        |\n" +
                        "|    #        |\n" +
                        "|             |\n" +
                        "|             |\n" +
                        "[=============]");
        ;
    }
}
