package gameplay.jeu;

import factory.CarteFactory;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class TestJoueur {
    @Test
    public void piocher() {
        Joueur joueur = new Joueur();
        int taillePioche = joueur.getSizePioche();
        joueur.piocher();
        assertEquals(taillePioche - 1, joueur.getSizePioche());
        assertEquals(1, joueur.getMain().size());
    }

    @Test
    public void miseEnPlacePartie() {
        Joueur joueur = new Joueur();

        for (int i = 0; i < joueur.getPlateau().length; i++){
            assertTrue(joueur.getPlateau()[i].isEmpty());
        }

        assertTrue(joueur.getSizePioche() > 0);
    }

    @Test
    public void testAjoutCartePioche() {
        Joueur joueur = new Joueur();
        int tailleAvant = joueur.getSizePioche();
        joueur.getPioche().push(CarteFactory.createLoup());
        assertEquals(tailleAvant + 1, joueur.getSizePioche());
    }


    @Test
    public void miseAJourScore(){
        Joueur player = new Joueur();
        Robot robot = new Robot(player);

        player.getPlateau()[3] = Optional.of(CarteFactory.createCoyote());
        player.attaquer(robot);

        assertSame(2, player.getScoreJoueur());
    }
}
