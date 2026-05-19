package typeCarte;

public abstract class Carte {
    private String m_nom;
    private int m_pointAttaque;
    private int m_pointDeVie;
    private int m_gouttesDeSang;
    private int m_os;
    private boolean m_volant;

    public Carte (String nom, int PV) {
        this(nom, PV, 0, 0, 0,false);
    }

    public Carte (String nom, int PV, int attaque, int gouttesSang, int os, boolean volant) {
        m_pointDeVie = PV;
        m_nom = nom;
        m_pointAttaque = attaque;
        m_gouttesDeSang = gouttesSang;
        m_os = os;
        m_volant = volant;
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

    public void attaquer(Carte other){
        System.out.println(this.getNom() + " attaque " + other.getNom() + " !");
        other.m_pointDeVie -=  this.m_pointAttaque;
        if (other.m_pointDeVie < 0){
            other.m_pointDeVie = 0;
        }
    };
}
