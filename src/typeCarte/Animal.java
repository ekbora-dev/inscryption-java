package typeCarte;

import pouvoirs.Pouvoir;

import java.util.Optional;

public class Animal extends Carte{
    private Optional<Pouvoir> m_pouvoir;
    public Animal(String nom, int pointAttaque, int pointDeVie, int gouttesDeSang, int os, boolean volant, Optional<Pouvoir> pvr){
        super(nom, pointDeVie, pointAttaque, gouttesDeSang, os, volant);
        m_pouvoir = pvr;
    }

    @Override
    public boolean isSacrifiable(){
        return true;
    }

    public Optional<Pouvoir> getPouvoir(){
        return m_pouvoir;
    }
}
