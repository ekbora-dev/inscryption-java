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
}
