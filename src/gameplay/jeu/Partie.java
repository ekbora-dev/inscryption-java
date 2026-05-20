package gameplay.jeu;

public class Partie {
    private int m_differenceScore = 0;
    public Partie(){

    }

    public void demarrerPartie(){
        Joueur robot = new Joueur();
        Joueur player = new Joueur();

        for (int i = 0; i < 4; i++){
            robot.piocher();
            robot.piocher();
        }

        boolean partie = true;

        while (partie){
            if (m_differenceScore == 5){
                partie = false;
            }


        }
    }
}
