package typeCarte;

public abstract class Animal extends Carte{
    private String m_nom;
    private int m_pointAttaque;
    private int m_pointDeVie;
    private int m_gouttesDeSang;
    private int m_os;
    private boolean m_volant;

    public Animal(String nom, int pointAttaque, int pointDeVie, int gouttesDeSang, int os, boolean volant){
        super(nom, pointDeVie);
        m_pointAttaque = pointAttaque;
        m_gouttesDeSang = gouttesDeSang;
        m_os = os;
        m_volant = volant;
    }

    @Override
    public int getAttaque(){
        return m_pointAttaque;
    }

    @Override
    public int getGouttesSang(){
        return m_gouttesDeSang;
    }

    @Override
    public int getOs(){
        return m_os;
    }



}
