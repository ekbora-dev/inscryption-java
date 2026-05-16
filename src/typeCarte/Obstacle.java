package typeCarte;

public abstract class Obstacle {
    private int m_vie;
    private String m_nom;

    public Obstacle (int PointVie, String nom) {
        m_vie = PointVie;
        m_nom = nom;
    }
}
