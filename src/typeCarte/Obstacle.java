package typeCarte;

public abstract class Obstacle {
    private int m_vie;
    private String m_nom;

    public Obstacle (int PointVie, String nom) {
        m_vie = PointVie;
        m_nom = nom;
    }

    public int getPV(){
        return m_vie;
    }

    public String getNom(){
        return m_nom;
    }

    public void subirDegat(int degat){
        m_vie -= degat;
        if (m_vie < 0){
            m_vie = 0;
        }
    }
}
