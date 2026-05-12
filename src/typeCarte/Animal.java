package typeCarte;

public abstract class Animal {
    private String m_nom;
    private int m_pointAttaque;
    private int m_pointDeVie;
    private int m_gouttesDeSang;
    private int m_os;
    private boolean m_volant;

    public Animal(String nom, int pointAttaque, int pointDeVie, int gouttesDeSang, int os, boolean volant){
        m_nom = nom;
        m_pointAttaque = pointAttaque;
        m_pointDeVie = pointDeVie;
        m_gouttesDeSang = gouttesDeSang;
        m_os = os;
        m_volant = volant;
    }
}
