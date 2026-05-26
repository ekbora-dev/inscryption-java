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

    public String[] getDeckLines() {
        return new String[]{
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
    }

    // Retourne le dessin de la pioche
    // Retourne le dessin de la carte sous forme de lignes
    public String[] getCarteLines() {
        // Gestion de la taille du nom pour éviter de déformer le cadre (ex: max 9 caractères)
        String nom = m_carte.getNom();
        if (nom.length() > 9) nom = nom.substring(0, 9);
        else nom = String.format("%-9s", nom); // Aligne à gauche et remplit d'espaces

        return new String[]{
                "0-------------0",
                "| " + nom + "   |",
                "|-------------|",
                String.format("|PV =  %-7d|", m_carte.getPV()),
                String.format("|GTE = %-7d|", m_carte.getGouttesSang()),
                String.format("|ATQ = %-7d|", m_carte.getAttaque()),
                String.format("|OS =  %-7d|", m_carte.getOs()),
                String.format("|VOL = %-7b|", m_carte.getVolant()),
                "|             |",
                "0-------------0"
        };
    }
}
