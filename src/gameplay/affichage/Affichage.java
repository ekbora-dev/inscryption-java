package gameplay.affichage;

import typeCarte.Animal;
import typeCarte.Obstacle;

public class Affichage {
    private Animal m_animal ;
    private Obstacle m_obstacle;
    public Affichage(Animal carteA, Obstacle carteO){
        m_animal = carteA;
        m_obstacle = carteO;
    }

    


    public void showCarte(){
        System.out.print ("0-------------0" + "\n" +
                          "|             |\n" +
                          "|-------------|\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "|             |\n" +
                          "0-------------0");

    }
}
