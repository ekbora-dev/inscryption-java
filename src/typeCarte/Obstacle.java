package typeCarte;

public abstract class Obstacle {
    private int m_vie;
    private String m_nom;

    public Obstacle (int PointVie, String nom) {
        this.m_vie = PointVie;
        this.m_nom = nom;
    }
}
