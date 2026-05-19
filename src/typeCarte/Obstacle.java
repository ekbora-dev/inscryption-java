package typeCarte;

public abstract class Obstacle extends Carte {
    private int m_vie;
    private String m_nom;

    public Obstacle (int pointDeVie, String nom) {
        super(nom, pointDeVie);
    }
}
