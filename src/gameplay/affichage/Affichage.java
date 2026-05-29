package gameplay.affichage;
import java.util.List;
import typeCarte.Carte;



public class Affichage {
    private Carte m_carte ;
    public Affichage(Carte carte){
        m_carte = carte;
    }




    public String[] getPioche(){
        return new String[]{
                "#-------------#",
                "|             |",
                "|    #####    |",
                "|    #   #    |",
                "|    #####    |",
                "|    #        |",
                "|    #        |",
                "|             |",
                "|             |",
                "#-------------#"
        };
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
    public void afficherGrilleDeck(List<Carte> deck) {
        int colonnes = 4;
        int totalCartes = deck.size();

        // On boucle sur le deck en avançant de 4 en 4 (les lignes de la grille)
        for (int i = 0; i < totalCartes; i += colonnes) {

            // On récupère les lignes de texte pour les (jusqu'à) 4 cartes de la ligne actuelle
            int fin = Math.min(i + colonnes, totalCartes);
            List<Carte> sousListe = deck.subList(i, fin);

            // Supposons que chaque carte fait 10 lignes de haut (comme défini dans getCarteLines)
            int hauteurCarte = 10;

            // On affiche la grille ligne de texte par ligne de texte
            for (int ligneTexte = 0; ligneTexte < hauteurCarte; ligneTexte++) {
                StringBuilder ligneComplete = new StringBuilder();

                for (Carte carte : sousListe) {
                    // On met temporairement à jour la carte courante pour utiliser getCarteLines()
                    this.m_carte = carte;
                    String[] lignesCarte = getCarteLines();

                    // On ajoute le bout de la carte + un espace de séparation entre les cartes
                    ligneComplete.append(lignesCarte[ligneTexte]).append("   ");
                }

                // Si la dernière ligne de la grille n'est pas complète,
                // on peut optionnellement afficher du vide (des espaces) pour combler,
                // mais ce n'est pas strictement nécessaire pour un simple affichage.

                System.out.println(ligneComplete);
            }

            // Un espace vertical entre chaque ligne de la grille
            System.out.println();
        }
    }
}
