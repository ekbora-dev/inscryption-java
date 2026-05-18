package typeCarte;

public abstract class Animal extends Carte implements Combat{
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

    public void attaquer(Animal other){
        System.out.println(m_nom + " attaque " + other.m_nom + " !");
        other.m_pointDeVie -=  this.m_pointAttaque;
        if (other.m_pointDeVie < 0){
            other.m_pointDeVie = 0;
        }
    }

    public void attaquer(Obstacle other){
        other.subirDegat(this.m_pointAttaque);
    }

    public String getNom(){
        return m_nom;
    }

    public int getPV(){
        return m_pointDeVie;
    }

    public int getAttaque(){
        return m_pointAttaque;
    }

    public int getGouttesSang(){
        return m_gouttesDeSang;
    }

    public int getOs(){
        return m_os;
    }

}
