package typeCarte;

public abstract class Obstacle extends Carte implements SubisDegat{
    private int m_vie;
    private String m_nom;

    public Obstacle (int pointDeVie, String nom) {
        super(nom, pointDeVie);
    }

    public void subirDegat(int degat){
        m_vie -= degat;
        if (m_vie < 0){
            m_vie = 0;
        }
    }
}
