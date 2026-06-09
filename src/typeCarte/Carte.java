package typeCarte;

import pouvoirs.Pouvoir;

import java.util.ArrayList;
import java.util.Optional;

public abstract class Carte {
    private String m_nom;
    private final int m_pointAttaque;
    private int m_pointDeVie;
    private final int m_gouttesDeSang;
    private final int m_os;
    private final boolean m_volant;
    private ArrayList<Optional<Pouvoir>> m_pouvoir = new ArrayList<>();

    public Carte (String nom, int PV) {
        this(nom, PV, 0, 0, 0,false, null);
    }

    public Carte (String nom, int PV, int attaque, int gouttesSang, int os, boolean volant, Pouvoir pvr) {
        m_pointDeVie = PV;
        m_nom = nom;
        m_pointAttaque = attaque;
        m_gouttesDeSang = gouttesSang;
        m_os = os;
        m_volant = volant;
        m_pouvoir.add(Optional.ofNullable(pvr));

        if (m_pouvoir.get(0).isPresent()) {
            switch (m_pouvoir.get(0).get()) {
                case NOMBREUSES_VIES:
                    m_nom += " - Nombreuses vies";
                    break;
                case CROISSANCE:
                    m_nom += " - Croissance";
                    break;
                case PUANT:
                    m_nom += " - Puant";
                    break;
                case COUREUR:
                    m_nom += " - Coureur";
                    break;
                case CONTACT_MORTEL:
                    m_nom += " - Contact mortel";
                    break;
                case PIQUES_POINTUES:
                    m_nom += " - Piques pointues";
            }
        }
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

    public boolean getVolant(){
        return m_volant;
    }

    public void attaquer(Carte other){
        other.m_pointDeVie -=  this.m_pointAttaque;
        if (other.m_pointDeVie < 0){
            other.m_pointDeVie = 0;
        }
    }

    public void setPouvoir(Pouvoir pvr){
        m_pouvoir.set(0, Optional.of(pvr));
    }

    public void addPouvoir(Animal carte){
        if (carte.getPouvoir().isPresent())
            m_pouvoir.add(Optional.of(carte.getPouvoir().get()));
    }

    public Optional<Pouvoir> getPouvoir(){
        return m_pouvoir.get(0);
    }

    public boolean isSacrifiable(){
        return false;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "m_nom='" + m_nom + '\'' +
                ", m_pointAttaque=" + m_pointAttaque +
                ", m_pointDeVie=" + m_pointDeVie +
                ", m_gouttesDeSang=" + m_gouttesDeSang +
                ", m_os=" + m_os +
                ", m_volant=" + m_volant +
                '}';
    }
}
