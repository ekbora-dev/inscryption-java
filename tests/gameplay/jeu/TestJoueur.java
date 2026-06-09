package gameplay.jeu;

import factory.CarteFactory;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class TestJoueur {
    @Test
    public void piocher(){
        Joueur player = new Joueur();

        player.piocher();

        assertSame(14, player.getSizePioche());
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
