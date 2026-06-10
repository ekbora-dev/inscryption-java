package factory;

import typeCarte.Animal;
import typeCarte.Obstacle;
import pouvoirs.*;

import java.util.Optional;

public class CarteFactory {

    // ───── Animaux ─────
    public static Animal createChat() {
        return new Animal("Chat", 0, 1, 1, 0, false, Optional.empty());
    }

    public static Animal createGrizzly() {
        return new Animal("Grizzly", 4, 6, 3, 0, false, Optional.empty());
    }

    public static Animal createCoyote() {
        return new Animal("Coyote", 2, 1, 0, 4, false, Optional.empty());
    }

    public static Animal createMoineau() {
        return new Animal("Moineau", 1, 2, 1, 0, true, Optional.empty());
    }

    public static Animal createCorbeau() {
        return new Animal("Corbeau", 2, 3, 2, 0, true, Optional.empty());
    }

    public static Animal createEcureuil() {
        return new Animal("Ecureuil", 0, 1, 0, 0, false, Optional.empty());
    }

    public static Animal createHermine() {
        return new Animal("Hermine", 1, 3, 1, 0, false, Optional.empty());
    }

    public static Animal createLouveteau() {
        return new Animal("Louveteau", 1, 1, 1, 0, false, Optional.of(new Croissance()));
    }

    public static Animal createLoup() {
        return new Animal("Loup", 3, 2, 2, 0, false, Optional.empty());
    }

    public static Animal createPunaise() {
        return new Animal("Punaise", 1, 2, 0, 2, false, Optional.of(new Puant()));
    }

    public static Animal createElan() {
        return new Animal("Elan", 2, 4, 2, 0, false, Optional.of(new Coureur()));
    }

    public static Animal createVipere() {
        return new Animal("Vipère", 1, 1, 2, 0, false, Optional.of(new ContactMortel()));
    }

    public static Animal createPorcEpic() {
        return new Animal("Porc-épic", 1, 2, 1, 0, false, Optional.of(new PiquesPointues()));
    }

    // ───── Obstacles ─────
    public static Obstacle createRocher() {
        return new Obstacle(5, "Rocher");
    }

    public static Obstacle createSapin() {
        return new Obstacle(3, "Sapin");
    }
}