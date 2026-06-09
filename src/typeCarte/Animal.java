package typeCarte;

import pouvoirs.Pouvoir;

public class Animal extends Carte{
    public Animal(String nom, int pointAttaque, int pointDeVie, int gouttesDeSang, int os, boolean volant, Pouvoir pvr){
        super(nom, pointDeVie, pointAttaque, gouttesDeSang, os, volant, pvr);
    }

    @Override
    public boolean isSacrifiable(){
        return true;
    }
}
