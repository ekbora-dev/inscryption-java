package typeCarte;

public abstract class Carte {
    private int m_vie;
    private String m_nom;

    public Carte (String nom, int PV) {
        m_vie = PV;
        m_nom = nom;
    }

    public int getPV(){
        return m_vie;
    }

    public String getNom(){
        return m_nom;
    }
}
