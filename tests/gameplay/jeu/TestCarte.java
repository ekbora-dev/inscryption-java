package gameplay.jeu;

import carteAnimal.Chat;
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
        Animal her = new Hermine();
        Animal ecu = new Ecureuil();


        her.attaquer(ecu);
        assertSame(0, ecu.getPV());
    }
}
