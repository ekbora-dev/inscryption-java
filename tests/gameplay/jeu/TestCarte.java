package gameplay.jeu;

import carteAnimal.Chat;
import factory.CarteFactory;
import org.junit.Test;
import typeCarte.*;
import carteAnimal.*;

import static org.junit.Assert.*;

public class TestCarte {
    @Test
    public void initialisationCarte(){
        Animal carte = new Chat();

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
