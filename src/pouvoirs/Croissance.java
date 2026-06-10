package pouvoirs;

public class Croissance extends Pouvoir {
    private int m_nbTours = 0;

    public Croissance(){
        super("Croissance");
    }

    @Override
    public String toString() {
        return "Croissance{" +
                "m_nbTours=" + m_nbTours +
                '}';
    }
}
