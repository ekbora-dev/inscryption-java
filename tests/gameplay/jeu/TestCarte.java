package gameplay.jeu;

import factory.CarteFactory;
import org.junit.Test;
import typeCarte.*;

import static org.junit.Assert.*;

public class TestCarte {
    @Test
    public void initialisationCarte(){
        Animal carte = CarteFactory.createChat();

        assertSame("Chat", carte.getNom());
    }

    @Test
    public void attaqueCarte(){
        Animal her = CarteFactory.createHermine();
        Animal ecu = CarteFactory.createEcureuil();

        her.attaquer(ecu);
        assertSame(0, ecu.getPV());
    }

    @Test
    public void pouvoirPuant(){
        Joueur joueur = new Joueur();
        Joueur adversaire = new Joueur();

        Animal punaise = CarteFactory.createPunaise();
        joueur.getMain().add(punaise);
        joueur.placerCarte(punaise, 0);

        Animal loup = CarteFactory.createLoup();
        adversaire.getMain().add(loup);
        adversaire.placerCarte(loup, 0);

        int attaqueAvant = loup.getAttaque();

        joueur.attaquer(adversaire);

        assertEquals(attaqueAvant - 1, loup.getAttaque());
    }

    @Test
    public void pouvoirPiquesPointues() {
        Joueur joueur = new Joueur();
        Joueur adversaire = new Joueur();

        Animal porcEpic = CarteFactory.createPorcEpic();
        joueur.getMain().add(porcEpic);
        joueur.placerCarte(porcEpic, 0);

        Animal loup = CarteFactory.createLoup();
        adversaire.getMain().add(loup);
        adversaire.placerCarte(loup, 0);

        int pvAvant = loup.getPV();

        adversaire.attaquer(joueur);

        assertEquals(pvAvant - 1, loup.getPV());
    }
}
