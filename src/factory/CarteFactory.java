package factory;

import carteAnimal.*;
import obstacles.*;
import typeCarte.Animal;
import typeCarte.Obstacle;

public class CarteFactory {

    public static Animal createChat() { return new Chat(); }
    public static Animal createGrizzly() { return new Grizzly(); }
    public static Animal createCoyote() { return new Coyote(); }
    public static Animal createMoineau() { return new Moineau(); }
    public static Animal createCorbeau() { return new Corbeau(); }
    public static Animal createEcureuil() { return new Ecureuil(); }
    public static Animal createHermine() { return new Hermine(); }
    public static Animal createLouveteau() { return new Louveteau(); }
    public static Animal createLoup() { return new Loup(); }
    public static Animal createPunaise() { return new Punaise(); }

    public static Obstacle createRocher() { return new Rocher(); }
    public static Obstacle createSapin() { return new Sapin(); }
}