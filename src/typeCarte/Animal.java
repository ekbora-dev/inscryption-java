package typeCarte;

public abstract class Animal extends Carte{
    public Animal(String nom, int pointAttaque, int pointDeVie, int gouttesDeSang, int os, boolean volant){
        super(nom, pointDeVie, pointAttaque, gouttesDeSang, os, volant);
    }
}
